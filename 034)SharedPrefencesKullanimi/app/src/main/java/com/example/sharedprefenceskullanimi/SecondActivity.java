package com.example.sharedprefenceskullanimi;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Set;

public class SecondActivity extends AppCompatActivity {

    private Button buttonSil, buttonGuncelle;
    private TextView textViewCikti;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor e;
    private String ad;
    private int yas;
    private float boy;
    private boolean bekarmi;
    private Set<String> arkadasListesi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonSil = findViewById(R.id.buttonSil);
        buttonGuncelle = findViewById(R.id.buttonGuncelle);
        textViewCikti = findViewById(R.id.textViewCikti);

        sharedPreferences = getSharedPreferences("KişiselBilgiler", MODE_PRIVATE);
        e = sharedPreferences.edit();

        ad = sharedPreferences.getString("ad", "isim yok");
        yas = sharedPreferences.getInt("yas", 0);
        boy = sharedPreferences.getFloat("boy", 0f);
        bekarmi = sharedPreferences.getBoolean("bekarmi", true);
        arkadasListesi =sharedPreferences.getStringSet("arkadasListesi", null);

        final StringBuilder stringBuilder = new StringBuilder();
        for (String s:arkadasListesi){
            stringBuilder.append(s + ", ");
        }
        textViewCikti.setText("Ad: " + ad + " Yaş: " + yas + " Boy: " + boy + " Bekar mı: " + bekarmi + " Arkadaşlar: " + stringBuilder.toString());

        buttonSil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e.remove("ad");
                e.commit();
                ad = sharedPreferences.getString("ad", "isim yok");
                textViewCikti.setText("Ad: " + ad + " Yaş: " + yas + " Boy: " + boy + " Bekar mı: " + bekarmi + " Arkadaşlar: " + stringBuilder.toString());
            }
        });

        buttonGuncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e.putInt("yas", 400);
                e.commit();
                yas = sharedPreferences.getInt("yas", 0);
                textViewCikti.setText("Ad: " + ad + " Yaş: " + yas + " Boy: " + boy + " Bekar mı: " + bekarmi + " Arkadaşlar: " + stringBuilder.toString());
            }
        });
    }
}