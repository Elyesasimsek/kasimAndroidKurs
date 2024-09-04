package com.example.a018listviewgridviewkullanimi;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
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

        listView = findViewById(R.id.ListView);

        ulkeler.add("Türkiye");
        ulkeler.add("Japonya");
        ulkeler.add("Güney Kore");
        ulkeler.add("Almanya");
        ulkeler.add("Hollanda");
        ulkeler.add("Çin");

        veriAdaptoru = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1,ulkeler);
        listView.setAdapter(veriAdaptoru);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Seçtiğiniz Ülke: " + ulkeler.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}