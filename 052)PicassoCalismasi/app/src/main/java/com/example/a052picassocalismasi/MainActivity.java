package com.example.a052picassocalismasi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewResimTutucu;
    private Button buttonLocal, buttonInternet, buttonInternet2, buttonDegistir;

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

        imageViewResimTutucu = findViewById(R.id.imageViewResimTutucu);
        buttonLocal = findViewById(R.id.buttonLocal);
        buttonInternet = findViewById(R.id.buttonInternet);
        buttonInternet2 = findViewById(R.id.buttonInternet2);
        buttonDegistir = findViewById(R.id.buttonDegistir);

        buttonLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.get().load(R.drawable.resim2).into(imageViewResimTutucu);
            }
        });

        buttonInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://fotolifeakademi.com/uploads/2020/04/manzara-fotografciligi-1.jpg";
                Picasso.get().load(url).into(imageViewResimTutucu);
            }
        });

        buttonInternet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.dekoros.com/wp-content/uploads/2023/04/YD-00693-autumn-forest.jpg";
                Picasso.get().load(url).into(imageViewResimTutucu);
            }
        });

        buttonDegistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.dekoros.com/wp-content/uploads/2023/04/YD-00693-autumn-forest.jpg";
                Picasso.get().load(url).resize(1000, 1000).rotate(45).into(imageViewResimTutucu);
            }
        });
    }
}