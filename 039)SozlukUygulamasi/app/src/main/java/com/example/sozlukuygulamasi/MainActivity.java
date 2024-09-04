package com.example.sozlukuygulamasi;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private VeritabaniYardimcisi veritabaniYardimcisi;

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

        veritabaniYardimcisi = new VeritabaniYardimcisi(this);

        /*new KelimelerDAO().kelimeEkle(veritabaniYardimcisi, "door", "kapı");
        new KelimelerDAO().kelimeEkle(veritabaniYardimcisi, "window", "pencere");
        new KelimelerDAO().kelimeEkle(veritabaniYardimcisi, "sea", "deniz");
        new KelimelerDAO().kelimeEkle(veritabaniYardimcisi, "table", "masa");
        new KelimelerDAO().kelimeEkle(veritabaniYardimcisi, "pencil", "kalem");*/

        //new KelimelerDAO().kelimeSil(veritabaniYardimcisi, 4);
        //new KelimelerDAO().kelimeGuncelle(veritabaniYardimcisi,5, "pencils", "kalemler");
        int sonuc = new KelimelerDAO().kayitKontrol(veritabaniYardimcisi);
        Log.e("Veri sayısı", String.valueOf(sonuc));
        Kelimeler kelimeler = new KelimelerDAO().kelimeGetir(veritabaniYardimcisi, 1);
        Log.e("Kelime",  kelimeler.getKelimeId() + " - " + kelimeler.getIngilizce() + " - " + kelimeler.getTurkce());

        ArrayList<Kelimeler> gelenKelimelerListesi = new KelimelerDAO().kelimeAra(veritabaniYardimcisi, "o");

        for (Kelimeler kelime : gelenKelimelerListesi){
            Log.e(String.valueOf(kelime.getKelimeId()) , kelime.getIngilizce() + " - " + kelime.getTurkce());
        }
    }
}