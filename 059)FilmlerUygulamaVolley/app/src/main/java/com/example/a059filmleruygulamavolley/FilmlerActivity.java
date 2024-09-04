package com.example.a059filmleruygulamavolley;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

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

public class FilmlerActivity extends AppCompatActivity {

    private Toolbar toolbarFilmler;
    private RecyclerView filmlerRV;
    private ArrayList<Filmler> filmlerArrayList;
    private FilmlerAdapter adapter;
    private Kategoriler kategori;
    private Yonetmenler yonetmen;
    private Filmler film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_filmler);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbarFilmler = findViewById(R.id.toolbarFilmler);
        filmlerRV = findViewById(R.id.filmlerRV);
        kategori = (Kategoriler) getIntent().getSerializableExtra("kategori_nesne");
        toolbarFilmler.setTitle(kategori.getKategoriAd());
        setSupportActionBar(toolbarFilmler);

        filmlerRV.setHasFixedSize(true);
        filmlerRV.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        filmGetir(kategori.getKategoriId());
    }

    public void filmGetir(int kategoriId){
        String url = "https://elyesasimsek.com/filmler/filmler_by_kategori_id.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                filmlerArrayList = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray filmlerList = jsonObject.getJSONArray("filmler");
                    for (int i = 0;i < filmlerList.length();i++){
                        JSONObject f = filmlerList.getJSONObject(i);
                        int filmId = f.getInt("filmId");
                        String filmAd = f.getString("filmAd");
                        int filmYil = f.getInt("filmYil");
                        String filmResim = f.getString("filmResim");

                        JSONObject k = f.getJSONObject("kategori");
                        int kategoriId = k.getInt("kategoriId");
                        String kategoriAd = k.getString("kategoriAd");

                        JSONObject y = f.getJSONObject("yonetmen");
                        int yonetmenId = y.getInt("yonetmenId");
                        String yonetmenAd = y.getString("yonetmenAd");
                        kategori = new Kategoriler(kategoriId, kategoriAd);
                        yonetmen = new Yonetmenler(yonetmenId, yonetmenAd);
                        film = new Filmler(filmId, filmAd, filmYil, filmResim, kategori, yonetmen);
                        filmlerArrayList.add(film);
                    }
                    adapter = new FilmlerAdapter(FilmlerActivity.this, filmlerArrayList);
                    filmlerRV.setAdapter(adapter);
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
                params.put("kategoriId", String.valueOf(kategoriId));
                return params;
            }
        };
        Volley.newRequestQueue(FilmlerActivity.this).add(stringRequest);
    }

}