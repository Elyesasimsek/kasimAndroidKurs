package com.example.a060filmleruygulamaretrofit2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
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

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;
    private RecyclerView kategoriRV;
    private ArrayList<Kategoriler> kategorilerArrayList;
    private KategoriAdapter adapter;
    private FilmlerDAOInterface kategorilerDIF;

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
        toolbarMain.setTitle("Kategoriler");
        setSupportActionBar(toolbarMain);

        kategorilerDIF = ApiUtils.getFilmlerDaoInterface();

        kategoriRV.setHasFixedSize(true);
        kategoriRV.setLayoutManager(new LinearLayoutManager(this));
        tumKategoriler();
    }

    public void tumKategoriler(){
        kategorilerDIF. tumKategoriler().enqueue(new Callback<KategorilerCevap>() {
            @Override
            public void onResponse(Call<KategorilerCevap> call, Response<KategorilerCevap> response) {
                List<Kategoriler> kategorilerList = response.body().getKategoriler();
                adapter = new KategoriAdapter(MainActivity.this, kategorilerList);
                kategoriRV.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<KategorilerCevap> call, Throwable t) {

            }
        });
    }
}