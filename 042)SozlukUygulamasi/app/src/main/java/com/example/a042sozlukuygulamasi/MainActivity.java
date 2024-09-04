package com.example.a042sozlukuygulamasi;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ArrayList<Kelimeler> kelimelerArrayList;
    private KelimelerAdapter adapter;
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

        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recyclerView);

        toolbar.setTitle("Sözlük Uygulaması");
        setSupportActionBar(toolbar);

        vt = new Veritabani(this);

        veritabaniKopyala();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        kelimelerArrayList = new KelimelerDAO().tumKelimeler(vt);

        adapter = new KelimelerAdapter(this, kelimelerArrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        MenuItem item = menu.findItem(R.id.actionAra);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("Gönderilen Arama", query);
        aramaYap(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("Harf Girdikçe", newText);
        aramaYap(newText);
        return false;
    }

    public void veritabaniKopyala(){
        DatabaseCopyHelper databaseCopyHelper = new DatabaseCopyHelper(this);
        try {
            databaseCopyHelper.createDataBase();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        databaseCopyHelper.openDataBase();
    }

    public void aramaYap(String aramaKelime){
        kelimelerArrayList = new KelimelerDAO().kelimeAra(vt, aramaKelime);

        adapter = new KelimelerAdapter(this, kelimelerArrayList);
        recyclerView.setAdapter(adapter);
    }
}