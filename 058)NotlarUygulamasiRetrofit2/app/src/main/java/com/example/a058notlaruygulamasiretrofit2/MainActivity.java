package com.example.a058notlaruygulamasiretrofit2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;
    private RecyclerView rv;
    private FloatingActionButton fab;
    private ArrayList<Notlar> notlarArrayList;
    private NotlarAdapter adapter;
    private NotlarDAOInterface notlarDIF;

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
        rv = findViewById(R.id.rv);
        fab = findViewById(R.id.fab);
        toolbarMain.setTitle("Notlar Uygulamasi");
        setSupportActionBar(toolbarMain);

        notlarDIF = ApiUtils.getNotlarDaoInterface();

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));


        tumNotlar();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NotKayitActivity.class));
            }
        });
    }
    public void tumNotlar(){
        notlarDIF.tumNotlar().enqueue(new Callback<NotlarCevap>() {
            @Override
            public void onResponse(Call<NotlarCevap> call, Response<NotlarCevap> response) {
                double toplam = 0.0;
                List<Notlar> notlarList = response.body().getNotlar();
                for (Notlar n:notlarList){
                    toplam = toplam + (Integer.parseInt(n.getNot1()) + Integer.parseInt(n.getNot2()))/2;
                }

                adapter = new NotlarAdapter(MainActivity.this, notlarList);
                rv.setAdapter(adapter);
                toolbarMain.setSubtitle("Ortalama: " + (toplam/notlarList.size()));
            }

            @Override
            public void onFailure(Call<NotlarCevap> call, Throwable t) {

            }
        });
    }
}