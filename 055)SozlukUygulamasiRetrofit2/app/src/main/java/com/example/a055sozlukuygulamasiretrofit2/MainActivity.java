package com.example.a055sozlukuygulamasiretrofit2;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    private RecyclerView rv;
    private ArrayList<Kelimeler> kelimelerArrayList;
    private KelimelerAdapter adapter;
    private KelimelerDAOInterface kelimelerDIF;

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
        rv = findViewById(R.id.rv);
        toolbar.setTitle("Sözlük Uygulaması");
        setSupportActionBar(toolbar);

        kelimelerDIF = ApiUtils.getKisilerDaoInterface();

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        tumKelimeler();
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
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("Harf Girdikçe", newText);
        kelimeAra(newText);
        return false;
    }

    public void  tumKelimeler(){
        kelimelerDIF.tumKelimeler().enqueue(new Callback<KelimelerCevap>() {
            @Override
            public void onResponse(Call<KelimelerCevap> call, Response<KelimelerCevap> response) {
                List<Kelimeler> kelimelerList = response.body().getKelimeler();
                adapter = new KelimelerAdapter(MainActivity.this,kelimelerList);
                rv.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<KelimelerCevap> call, Throwable t) {

            }
        });
    }

    public void kelimeAra(String aramaKelime){
        kelimelerDIF.kelimeAra(aramaKelime).enqueue(new Callback<KelimelerCevap>() {
            @Override
            public void onResponse(Call<KelimelerCevap> call, Response<KelimelerCevap> response) {
                List<Kelimeler> kelimelerList = response.body().getKelimeler();
                adapter = new KelimelerAdapter(MainActivity.this,kelimelerList);
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<KelimelerCevap> call, Throwable t) {

            }
        });
    }
}