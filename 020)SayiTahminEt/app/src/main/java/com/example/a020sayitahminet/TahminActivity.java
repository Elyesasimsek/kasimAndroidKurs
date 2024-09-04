package com.example.a020sayitahminet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {

    private TextView textViewKalanHak, textViewYardim;
    private EditText editTextGirdi;
    private Button buttonTahmin;

    private int rastgeleSayi;
    private int sayac = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tahmin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewKalanHak = findViewById(R.id.textViewKalanHak);
        textViewYardim = findViewById(R.id.textViewYardim);
        editTextGirdi = findViewById(R.id.editTextGirdi);
        buttonTahmin = findViewById(R.id.buttonTahmin);

        Random random = new Random();
        rastgeleSayi = random.nextInt(101);
        Log.e("Rastgele Sayı ", String.valueOf(rastgeleSayi));

        buttonTahmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac -= 1;
                int tahmin = Integer.parseInt(editTextGirdi.getText().toString());
                if (tahmin == rastgeleSayi){
                    Intent intent = new Intent(TahminActivity.this, SonucActivity.class);
                    intent.putExtra("sonuc", true);
                    startActivity(intent);
                    finish();
                    return;
                } else if (tahmin > rastgeleSayi) {
                    textViewYardim.setText("Azalt");
                    textViewKalanHak.setText("Kalan Hak: " + sayac);
                } else if (tahmin < rastgeleSayi) {
                    textViewYardim.setText("Arttır");
                    textViewKalanHak.setText("Kalan Hak: " + sayac);
                }
                if (sayac == 0) {
                    Intent intent = new Intent(TahminActivity.this, SonucActivity.class);
                    intent.putExtra("sonuc", false);
                    startActivity(intent);
                    finish();
                }
                editTextGirdi.setText("");
            }
        });
    }
}