package com.example.sharedprefenceskullanimi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Button buttonKaydet;

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

        buttonKaydet = findViewById(R.id.buttonKaydet);

        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("KişiselBilgiler", MODE_PRIVATE);
                SharedPreferences.Editor e = sharedPreferences.edit();
                e.putString("ad", "Elyesa");
                e.putInt("yas", 25);
                e.putFloat("boy", 1.78f);
                e.putBoolean("bekarmi", false);

                Set<String> arkadasListesi = new HashSet<>();
                arkadasListesi.add("Fatma");
                arkadasListesi.add("Meryem");
                e.putStringSet("arkadasListesi", arkadasListesi);
                e.commit();

                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
}