package com.example.toolbarmenuekleme;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

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

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Toolbar Menu");

        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.actionBilgi){
            Toast.makeText(getApplicationContext(), "Bilgi Tıklandı", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.actionAyarlar) {
            Toast.makeText(getApplicationContext(), "Ayarlar Tıklandı", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.actionCikis) {
            Toast.makeText(getApplicationContext(), "Çıkış Tıklandı", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.actionEkle) {
            Toast.makeText(getApplicationContext(), "Ekle Tıklandı", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }
}