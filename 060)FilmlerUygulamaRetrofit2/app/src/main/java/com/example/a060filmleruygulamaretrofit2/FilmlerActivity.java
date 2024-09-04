package com.example.a060filmleruygulamaretrofit2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmlerActivity extends AppCompatActivity {

    private Toolbar toolbarFilmler;
    private RecyclerView filmlerRV;
    private ArrayList<Filmler> filmlerArrayList;
    private FilmlerAdapter adapter;
    private Kategoriler kategori;
    private FilmlerDAOInterface filmlerDIF;

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

        filmlerDIF = ApiUtils.getFilmlerDaoInterface();

        filmlerRV.setHasFixedSize(true);
        filmlerRV.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        filmGetir(Integer.parseInt(kategori.getKategoriId()));
    }

    public void filmGetir(int kategoriId){
        filmlerDIF.filmGetir(Integer.parseInt(kategori.getKategoriId())).enqueue(new Callback<FilmlerCevap>() {
            @Override
            public void onResponse(Call<FilmlerCevap> call, Response<FilmlerCevap> response) {
                List<Filmler> filmlerList = response.body().getFilmler();
                adapter = new FilmlerAdapter(FilmlerActivity.this, filmlerList);
                filmlerRV.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<FilmlerCevap> call, Throwable t) {

            }
        });
    }
}