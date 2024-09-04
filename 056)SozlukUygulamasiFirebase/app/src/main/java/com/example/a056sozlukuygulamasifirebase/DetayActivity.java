package com.example.a056sozlukuygulamasifirebase;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetayActivity extends AppCompatActivity {

    private TextView textViewIngilizceDetay, textViewTurkceDetay;
    private Kelimeler kelime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detay);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewIngilizceDetay = findViewById(R.id.textViewIngilizceDetay);
        textViewTurkceDetay = findViewById(R.id.textViewTurkceDetay);

        kelime = (Kelimeler)getIntent().getSerializableExtra("nesne");
        textViewIngilizceDetay.setText(kelime.getIngilizce());
        textViewTurkceDetay.setText(kelime.getTurkce());
    }
}