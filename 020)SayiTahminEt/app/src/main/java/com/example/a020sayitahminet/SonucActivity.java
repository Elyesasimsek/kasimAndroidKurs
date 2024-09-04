package com.example.a020sayitahminet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SonucActivity extends AppCompatActivity {

    private ImageView imageViewSonuc;
    private TextView textViewSonuc;
    private Button buttonTekrar;

    private boolean sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sonuc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageViewSonuc = findViewById(R.id.imageViewSonuc);
        textViewSonuc = findViewById(R.id.textViewSonuc);
        buttonTekrar = findViewById(R.id.buttonTekrar);

        sonuc = getIntent().getBooleanExtra("sonuc", false);
        if (sonuc){
            textViewSonuc.setText("KAZANDINIZ");
            imageViewSonuc.setImageResource(R.drawable.mutlu_resim);
        }else {
            textViewSonuc.setText("KAYBETTİNİZ");
            imageViewSonuc.setImageResource(R.drawable.uzgun_resim);
        }

        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SonucActivity.this, TahminActivity.class));
                finish();
            }
        });
    }
}