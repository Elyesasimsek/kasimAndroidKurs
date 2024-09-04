package com.example.a015videoviewkullanimi;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;
    private Button buttonBasla, buttonDur;

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

        videoView = findViewById(R.id.videoView);
        buttonBasla = findViewById(R.id.buttonBasla);
        buttonDur = findViewById(R.id.buttonDur);

        buttonBasla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri adres = Uri.parse("android.resource://"+ getPackageName() + "/" + R.raw.video);

                videoView.setVideoURI(adres);
                videoView.start();
            }
        });

        buttonDur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();
            }
        });
    }
}