package com.example.a070animasyonislemleri;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button buttonYap, button2;
    private Animation alphaCalismasi, scaleCalismasi, rotateCalismasi, translateCalismasi, blinkCalismasi, ayniAndaCalismasi, ardisikCalismasi;

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

        buttonYap = findViewById(R.id.buttonYap);
        button2 = findViewById(R.id.button2);

        alphaCalismasi = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_calisma);
        scaleCalismasi = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_calismasi);
        rotateCalismasi = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_calismasi);
        translateCalismasi = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_calismasi);
        blinkCalismasi = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_calismasi);
        ayniAndaCalismasi = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ayni_anda_calismasi);
        ardisikCalismasi = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ardisik_calismasi);

        buttonYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.startAnimation(ardisikCalismasi);
            }
        });
    }
}