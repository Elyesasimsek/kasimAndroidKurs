package com.example.a043notlaruygulamasi;

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
import androidx.activity.OnBackPressedCallback;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;
    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private ArrayList<Notlar> notlarArrayList;
    private NotlarAdapter adapter;
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

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);

        toolbarMain = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbarMain);
        recyclerView = findViewById(R.id.recyclerView);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        vt = new Veritabani(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        notlarArrayList =new NotlarDAO().tumNotlar(vt);

        double toplam = 0.0;
        for (Notlar n:notlarArrayList){
            toplam = toplam + (n.getNot1() + n.getNot2())/2;
        }
        toolbarMain.setSubtitle("Ortalama: " + (toplam/notlarArrayList.size()));

        adapter = new NotlarAdapter(this, notlarArrayList);
        recyclerView.setAdapter(adapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NotKayitActivity.class));
            }
        });
    }
}