package com.example.a019spinnerkullanimi;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button buttonGoster;
    private ArrayList<String> ulkeler = new ArrayList<>();
    private ArrayAdapter<String> veriAdaptoru;

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
        spinner = findViewById(R.id.spinner);
        buttonGoster = findViewById(R.id.buttonGoster);

        ulkeler.add("Türkiye");
        ulkeler.add("Japonya");
        ulkeler.add("Güney Kore");
        ulkeler.add("Almanya");
        ulkeler.add("Hollanda");
        ulkeler.add("Çin");

        veriAdaptoru = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler);
        spinner.setAdapter(veriAdaptoru);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Seçilen Ülke: " + ulkeler.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonGoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Ülke: " + ulkeler.get(spinner.getSelectedItemPosition()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}