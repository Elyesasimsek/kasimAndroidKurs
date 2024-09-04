package com.example.bayrakuygulamasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewSonuc, textViewYuzdeSonuc;
    private Button buttonTekrar;
    private int dogruSayac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewSonuc = findViewById(R.id.textViewSonuc);
        textViewYuzdeSonuc = findViewById(R.id.textViewYuzdeSonuc);
        buttonTekrar = findViewById(R.id.buttonTekrar);

        dogruSayac = getIntent().getIntExtra("dogrusayac", 0);
        textViewSonuc.setText(dogruSayac + " DOĞRU " + (7 - dogruSayac + " YANLIŞ"));
        textViewYuzdeSonuc.setText("%" + dogruSayac*100/5 + " BAŞARI");

        buttonTekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, QuizActivity.class));
                finish();
            }
        });
    }
}