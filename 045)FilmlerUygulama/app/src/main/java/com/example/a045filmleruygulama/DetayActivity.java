package com.example.a045filmleruygulama;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetayActivity extends AppCompatActivity {

    private ImageView imageViewResimDetay;
    private TextView textViewFilmAdDetay, textViewYilDetay, textViewYonetmenDetay;
    private Filmler film;

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

        imageViewResimDetay = findViewById(R.id.imageViewResimDetay);
        textViewFilmAdDetay = findViewById(R.id.textViewFilmAdDetay);
        textViewYilDetay = findViewById(R.id.textViewYilDetay);
        textViewYonetmenDetay = findViewById(R.id.textViewYonetmenDetay);

        film = (Filmler) getIntent().getSerializableExtra("nesne");

        textViewFilmAdDetay.setText(film.getFilmAd());
        textViewYilDetay.setText(String.valueOf(film.getFilmYil()));
        textViewYonetmenDetay.setText(film.getYonetmen().getYonetmenAd());
        imageViewResimDetay.setImageResource(getResources().getIdentifier(film.getFilmResim(), "drawable", getPackageName()));
    }
}