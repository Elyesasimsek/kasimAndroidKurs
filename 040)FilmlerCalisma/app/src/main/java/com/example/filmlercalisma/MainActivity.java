package com.example.filmlercalisma;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.filmlercalisma.DAO.DatabaseCopyHelper;
import com.example.filmlercalisma.DAO.FilmlerDAO;
import com.example.filmlercalisma.DAO.KategorilerDAO;
import com.example.filmlercalisma.DAO.VeritabaniYardimcisi;
import com.example.filmlercalisma.Object.Filmler;
import com.example.filmlercalisma.Object.Kategoriler;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private VeritabaniYardimcisi veritabaniYardimcisi = new VeritabaniYardimcisi(this);

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
        kopyala();
        ArrayList<Filmler> liste = new FilmlerDAO().tumFilmler(veritabaniYardimcisi);

        for (Filmler f:liste){
            Log.e("******", "******");
            Log.e("Film id",  String.valueOf(f.getFilm_id()));
            Log.e("Film ad",  f.getFilm_ad());
            Log.e("Film yıl",  String.valueOf(f.getFilm_yil()));
            Log.e("Film resim", f.getFilm_resim());
            Log.e("Film Kategori", f.getKategori().getKategori_ad());
            Log.e("Film yonetmen", f.getYonetmen().getYonetmen_ad());
            Log.e("******", "******");
        }
    }

    public void kopyala(){
        DatabaseCopyHelper helper = new DatabaseCopyHelper(this);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        helper.openDataBase();
    }
}