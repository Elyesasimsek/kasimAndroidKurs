package com.example.a072animasyonlufab;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabMain, fabBirinci, fabIkinci;
    private Animation fabAcik, fabKapali, geriDon, ileriDon;
    private Boolean fabDurum = false;

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

        fabMain = findViewById(R.id.fabMain);
        fabBirinci = findViewById(R.id.fabBirinci);
        fabIkinci = findViewById(R.id.fabIkinci);

        fabAcik = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_acik);
        fabKapali = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_kapali);
        ileriDon = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ileri_don);
        geriDon = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.geri_don);

        fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fabDurum){
                    fabMain.startAnimation(geriDon);
                    fabBirinci.startAnimation(fabKapali);
                    fabIkinci.startAnimation(fabKapali);
                    fabBirinci.setClickable(false);
                    fabIkinci.setClickable(false);
                    fabDurum = false;
                }else {
                    fabMain.startAnimation(ileriDon);
                    fabBirinci.startAnimation(fabAcik);
                    fabIkinci.startAnimation(fabAcik);
                    fabBirinci.setClickable(true);
                    fabIkinci.setClickable(true);
                    fabDurum = true;
                }
            }
        });
    }
}