package com.example.a075kopyalayapistir;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.a075kopyalayapistir.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding tasarim;
    private ClipboardManager kopyalamaPanom;
    private ClipData clipData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        tasarim = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        kopyalamaPanom = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        tasarim.buttonKopyala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kopyalanacakYazi = tasarim.editText.getText().toString();
                clipData = ClipData.newPlainText("text", kopyalanacakYazi);
                kopyalamaPanom.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(), "Panoya Kopalandı", Toast.LENGTH_SHORT).show();
            }
        });

        tasarim.buttonGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
}