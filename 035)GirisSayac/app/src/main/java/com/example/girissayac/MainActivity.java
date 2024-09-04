package com.example.girissayac;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textViewSayac;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

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

        textViewSayac = findViewById(R.id.textViewSayac);

        sharedPreferences = getSharedPreferences("GirisSayac", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        int sayac = sharedPreferences.getInt("sayac", 0);
        editor.putInt("sayac", ++sayac);
        editor.commit();
        textViewSayac.setText("Sayac: " + String.valueOf(sayac));
    }
}