package com.example.a078oyuncalismasi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.a078oyuncalismasi.databinding.ActivitySonucEkraniBinding;

public class SonucEkraniActivity extends AppCompatActivity {

    private ActivitySonucEkraniBinding tasarim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        tasarim = DataBindingUtil.setContentView(this, R.layout.activity_sonuc_ekrani);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int skor = getIntent().getIntExtra("skor", 0);
        tasarim.textViewToplamSkor.setText(String.valueOf(skor));

        SharedPreferences sharedPreferences = getSharedPreferences("Sonuc", Context.MODE_PRIVATE);
        int enYuksekSkor = sharedPreferences.getInt("enYuksekSkor", 0);

        if (skor > enYuksekSkor){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("enYuksekSkor", skor);
            editor.commit();
            tasarim.textViewEnYukskSkor.setText(String.valueOf(skor));
        }else {
            tasarim.textViewEnYukskSkor.setText(String.valueOf(enYuksekSkor));
        }

        tasarim.buttonTekrarDene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SonucEkraniActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}