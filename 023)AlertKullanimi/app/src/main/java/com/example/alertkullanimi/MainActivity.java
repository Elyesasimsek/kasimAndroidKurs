package com.example.alertkullanimi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button buttonNormal, buttonOzel;

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

        buttonNormal = findViewById(R.id.buttonNormal);
        buttonOzel = findViewById(R.id.buttonOzel);

        buttonNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setMessage("Mesaj");
                ad.setTitle("Başlık");
                ad.setIcon(R.drawable.resim);

                ad.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Tamam Tıklandı", Toast.LENGTH_SHORT).show();
                    }
                });
                ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "İptal Tıklandı", Toast.LENGTH_SHORT).show();
                    }
                });
                ad.create().show();
            }
        });

        buttonOzel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View tasarim = getLayoutInflater().inflate(R.layout.alert_tasarim, null);

                final EditText editTextAlert = tasarim.findViewById(R.id.editTextAlert);
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
                ad.setTitle("Başlık");
                ad.setMessage("Mesaj");
                ad.setView(tasarim);
                ad.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String gelenVeri = editTextAlert.getText().toString();
                        Toast.makeText(MainActivity.this, "Alınan veri: " + gelenVeri, Toast.LENGTH_SHORT).show();
                    }
                });
                ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Özel İptal Seçildi" , Toast.LENGTH_SHORT).show();
                    }
                });
                ad.create().show();
            }
        });
    }
}