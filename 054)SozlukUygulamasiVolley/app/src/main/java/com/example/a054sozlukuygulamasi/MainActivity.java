package com.example.a054sozlukuygulamasi;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.MenuItemCompat;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private Toolbar toolbar;
    private RecyclerView rv;
    private ArrayList<Kelimeler> kelimelerArrayList;
    private KelimelerAdapter adapter;

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
        toolbar = findViewById(R.id.toolbar);
        rv = findViewById(R.id.rv);

        toolbar.setTitle("Sözlük Uygulaması");
        setSupportActionBar(toolbar);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        tumKelimeler();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem item = menu.findItem(R.id.actionAra);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("Gönderilen arama", query);
       // kelimeAra(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("harf girildikçe", newText);
        kelimeAra(newText);
        return false;
    }

    public void tumKelimeler(){
        String url = "https://elyesasimsek.com/kelimeler/tum_kelimeler.php";
        StringRequest istek =new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                kelimelerArrayList = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray kelimeler = jsonObject.getJSONArray("kelimeler");

                    for (int i = 0;i < kelimeler.length();i++){
                        JSONObject k = kelimeler.getJSONObject(i);
                        int kelimeId = k.getInt("kelimeId");
                        String ingilizce = k.getString("ingilizce");
                        String turkce = k.getString("turkce");
                        Kelimeler kelime = new Kelimeler(kelimeId, ingilizce, turkce);
                        kelimelerArrayList.add(kelime);
                    }
                    adapter = new KelimelerAdapter(MainActivity.this, kelimelerArrayList);
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
        Volley.newRequestQueue(MainActivity.this).add(istek);
    }

    public void kelimeAra(String aramaKelime){
        String url = "https://elyesasimsek.com/kelimeler/kelime_ara.php";
        StringRequest istek = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap", response);
                kelimelerArrayList = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray kelimeler = jsonObject.getJSONArray("kelimeler");

                    for (int i = 0;i < kelimeler.length();i++){
                        JSONObject k = kelimeler.getJSONObject(i);
                        int kelimeId = k.getInt("kelimeId");
                        String ingilizce = k.getString("ingilizce");
                        String turkce = k.getString("turkce");
                        Kelimeler kelime = new Kelimeler(kelimeId, ingilizce, turkce);
                        kelimelerArrayList.add(kelime);
                    }
                    adapter = new KelimelerAdapter(MainActivity.this, kelimelerArrayList);
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
                params.put("ingilizce", aramaKelime);
                return params;
            }
        };
        Volley.newRequestQueue(MainActivity.this).add(istek);
    }


}