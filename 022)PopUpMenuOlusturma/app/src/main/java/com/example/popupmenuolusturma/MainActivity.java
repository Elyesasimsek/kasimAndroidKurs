package com.example.popupmenuolusturma;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button buttonMenuAc;

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

        buttonMenuAc = findViewById(R.id.buttonMenuAc);

        buttonMenuAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, buttonMenuAc);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                       int id = item.getItemId();
                        if (id == R.id.actionSil){
                            Toast.makeText(MainActivity.this, "Sil Seçildi", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (id == R.id.actionDuzenle) {
                            Toast.makeText(MainActivity.this, "Düzenle Seçildi", Toast.LENGTH_SHORT).show();
                            return true;
                        }else {
                            return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }
}