package com.example.a048countdowntimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button buttonBasla;
    private TextView cikti;

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
        buttonBasla = findViewById(R.id.buttonBasla);
        cikti = findViewById(R.id.cikti);

        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CountDownTimer(30000, 1000){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        cikti.setText("Kalan Süre: " + millisUntilFinished/1000 + " sn");
                    }

                    @Override
                    public void onFinish() {
                        cikti.setText("Bitti");
                    }
                }.start();
            }
        });
    }
}