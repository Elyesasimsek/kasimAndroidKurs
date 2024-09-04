package com.example.a056sozlukuygulamasifirebase;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    private RecyclerView rv;
    private ArrayList<Kelimeler> kelimelerArrayList;
    private KelimelerAdapter adapter;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

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
        toolbar.setTitle("Sozluk Uygulaması");
        setSupportActionBar(toolbar);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("kelimeler");


        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));



        kelimelerArrayList = new ArrayList<>();
        tumkelimeler();
        adapter = new KelimelerAdapter(this, kelimelerArrayList);
        rv.setAdapter(adapter);

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
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        kelimeAra(newText);
        return false;
    }

    public void tumkelimeler(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                kelimelerArrayList.clear();
                for (DataSnapshot d:snapshot.getChildren()){
                    Kelimeler kelime = d.getValue(Kelimeler.class);
                    kelime.setKelime_id(d.getKey());
                    kelimelerArrayList.add(kelime);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void kelimeAra(String aramaKelime){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                kelimelerArrayList.clear();
                for (DataSnapshot d:snapshot.getChildren()){
                    Kelimeler kelime = d.getValue(Kelimeler.class);
                    if (kelime.getIngilizce().contains(aramaKelime)){
                        kelime.setKelime_id(d.getKey());
                        kelimelerArrayList.add(kelime);
                    }

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}