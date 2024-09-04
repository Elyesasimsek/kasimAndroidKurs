package com.example.a045filmleruygulama;

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

public class FilmlerActivity extends AppCompatActivity {

    private Toolbar toolbarFilmler;
    private RecyclerView filmlerRV;
    private ArrayList<Filmler> filmlerArrayList;
    private FilmlerAdapter adapter;
    private Kategoriler kategori;
    private Veritabani vt;

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

        vt = new Veritabani(this);

        kategori = (Kategoriler) getIntent().getSerializableExtra("kategori_nesne");

        toolbarFilmler.setTitle(kategori.getKategoriAd());
        setSupportActionBar(toolbarFilmler);

        filmlerArrayList = new FilmlerDAO().tumFilmlerByKategoriId(vt, kategori.getKategoriId());

        filmlerRV.setHasFixedSize(true);
        filmlerRV.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));



        adapter = new FilmlerAdapter(this, filmlerArrayList);
        filmlerRV.setAdapter(adapter);
    }
}