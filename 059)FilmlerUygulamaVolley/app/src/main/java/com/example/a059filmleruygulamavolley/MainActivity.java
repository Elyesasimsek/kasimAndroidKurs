package com.example.a059filmleruygulamavolley;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;
    private RecyclerView mainRV;
    private ArrayList<Kategoriler> kategorilerArrayList;
    private KategoriAdapter adapter;

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
        mainRV = findViewById(R.id.mainRV);
        toolbarMain.setTitle("Kategoriler");
        setSupportActionBar(toolbarMain);

        mainRV.setHasFixedSize(true);
        mainRV.setLayoutManager(new LinearLayoutManager(this));
        tumKategoriler();
    }

    public void tumKategoriler(){
        String url = "https://elyesasimsek.com/filmler/tum_kategoriler.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                kategorilerArrayList = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray kategorilerList = jsonObject.getJSONArray("kategoriler");
                    for (int i = 0;i < kategorilerList.length();i++){
                        JSONObject k = kategorilerList.getJSONObject(i);
                        int kategoriId = k.getInt("kategoriId");
                        String kategoriAd = k.getString("kategoriAd");
                        Kategoriler kategori = new Kategoriler(kategoriId, kategoriAd);
                        kategorilerArrayList.add(kategori);
                    }
                    adapter = new KategoriAdapter(MainActivity.this, kategorilerArrayList);
                    mainRV.setAdapter(adapter);
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
}