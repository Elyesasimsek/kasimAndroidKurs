package com.example.detaylirecyclerviewkullanimi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Filmler> filmlerArraList;
    private FilmAdapter adapter;

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

        recyclerView =findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        Filmler f1 = new Filmler(1, "Django", 130, "django");
        Filmler f2 = new Filmler(2, "Inception", 110, "inception");
        Filmler f3 = new Filmler(3, "İnterstellar", 300, "interstellar");
        Filmler f4 = new Filmler(4, "The Hateful Eight", 60, "thehatefuleight");
        Filmler f5 = new Filmler(5, "The Pianist", 120, "thepianist");
        Filmler f6 = new Filmler(6, "Bir Zamanlar Anadoluda", 130, "birzamanlaranadoluda");

        filmlerArraList = new ArrayList<>();
        filmlerArraList.add(f1);
        filmlerArraList.add(f2);
        filmlerArraList.add(f3);
        filmlerArraList.add(f4);
        filmlerArraList.add(f5);
        filmlerArraList.add(f6);

        adapter = new FilmAdapter(this, filmlerArraList);
        recyclerView.setAdapter(adapter);
    }
}