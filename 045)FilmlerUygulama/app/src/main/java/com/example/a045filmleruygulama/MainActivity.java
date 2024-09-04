package com.example.a045filmleruygulama;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;
    private RecyclerView kategoriRV;
    private ArrayList<Kategoriler> kategorilerArrayList;
    private KategoriAdapter adapter;
    private Veritabani vt;

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

        toolbarMain = findViewById(R.id.toolbarMain);
        kategoriRV = findViewById(R.id.kategoriRV);

        VeritabaniKopyala();
        vt = new Veritabani(this);

        toolbarMain.setTitle("Kategoriler");
        setSupportActionBar(toolbarMain);

        kategoriRV.setHasFixedSize(true);
        kategoriRV.setLayoutManager(new LinearLayoutManager(this));

        kategorilerArrayList = new KategoriDAO().tumKategoriler(vt);

        adapter = new KategoriAdapter(this, kategorilerArrayList);
        kategoriRV.setAdapter(adapter);
    }

    public void VeritabaniKopyala(){
        DatabaseCopyHelper helper = new DatabaseCopyHelper(this);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        helper.openDataBase();
    }
}