package com.example.a061kisileruygulamasivolley;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private Toolbar toolbarMain;
    private RecyclerView rv;
    private FloatingActionButton fab;
    private ArrayList<Kisiler> kisilerArrayList;
    private KisilerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        toolbarMain = findViewById(R.id.toolbarMain);
        rv = findViewById(R.id.rv);
        fab = findViewById(R.id.fab);
        toolbarMain.setTitle("Kişiler Uygulaması");
        setSupportActionBar(toolbarMain);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        tumKisiler();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertGoster();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        MenuItem menuItem =menu.findItem(R.id.actionAra);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        ara(newText);
        return false;
    }

    public void alertGoster(){
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View tasarim = layoutInflater.inflate(R.layout.alert_tasarim, null);
        EditText editTextAd, editTextTel;
        editTextAd = tasarim.findViewById(R.id.editTextAd);
        editTextTel = tasarim.findViewById(R.id.editTextTel);

        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setTitle("Kişi Ekle");
        ad.setView(tasarim);
        ad.setPositiveButton("Ekle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String kisiAd = editTextAd.getText().toString().trim();
                String kisiTel = editTextTel.getText().toString().trim();

                String url = "https://elyesasimsek.com/kisiler/insert_kisiler.php";
                StringRequest postStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        tumKisiler();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("kisiAd", kisiAd);
                        params.put("kisiTel", kisiTel);
                        return params;
                    }
                };
                Volley.newRequestQueue(MainActivity.this).add(postStringRequest);
            }
        });
        ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ad.create().show();
    }

    public void tumKisiler(){
        String url = "https://elyesasimsek.com/kisiler/tum_kisiler.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                kisilerArrayList = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray kisiler = jsonObject.getJSONArray("kisiler");
                    for (int i = 0;i < kisiler.length();i++){
                        JSONObject k = kisiler.getJSONObject(i);
                        int kisiId = k.getInt("kisiId");
                        String kisiAd = k.getString("kisiAd");
                        String kisiTel = k.getString("kisiTel");
                        Kisiler kisi = new Kisiler(kisiId, kisiAd, kisiTel);
                        kisilerArrayList.add(kisi);
                    }
                    adapter = new KisilerAdapter(MainActivity.this, kisilerArrayList);
                    rv.setAdapter(adapter);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(MainActivity.this).add(stringRequest);
    }

    public void ara( String kelimeAra){
        String url = "https://elyesasimsek.com/kisiler/tum_kisiler_arama.php";
        StringRequest postStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                kisilerArrayList = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray kisiler = jsonObject.getJSONArray("kisiler");
                    for (int i = 0;i < kisiler.length();i++){
                        JSONObject k = kisiler.getJSONObject(i);
                        int kisiId = k.getInt("kisiId");
                        String kisiAd = k.getString("kisiAd");
                        String kisiTel = k.getString("kisiTel");
                        Kisiler kisi = new Kisiler(kisiId, kisiAd, kisiTel);
                        kisilerArrayList.add(kisi);
                    }
                    adapter = new KisilerAdapter(MainActivity.this, kisilerArrayList);
                    rv.setAdapter(adapter);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("kisiAd", kelimeAra);
                return params;
            }
        };
        Volley.newRequestQueue(MainActivity.this).add(postStringRequest);
    }
}