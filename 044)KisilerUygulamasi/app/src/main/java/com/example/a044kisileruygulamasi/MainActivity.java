package com.example.a044kisileruygulamasi;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar toolbarMain;
    private RecyclerView rv;
    private FloatingActionButton fab;
    private ArrayList<Kisiler> kisilerArrayList;
    private KisilerAdapter adapter;
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
        rv = findViewById(R.id.rv);
        fab = findViewById(R.id.fab);

        vt = new Veritabani(this);

        toolbarMain.setTitle("Kişiler Uygulaması");
        setSupportActionBar(toolbarMain);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        kisilerArrayList = new KisilerDAO().tumKisiler(vt);

        adapter = new KisilerAdapter(this, kisilerArrayList, vt);
        rv.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertGoster();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.actionAra);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("onQueryTextSubmit", query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("onQueryTextChange", newText);
        kisilerArrayList = new KisilerDAO().kisiAra(vt, newText);
        adapter = new KisilerAdapter(this, kisilerArrayList, vt);
        rv.setAdapter(adapter);
        return false;
    }

    public void alertGoster(){
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View tasarim = layoutInflater.inflate(R.layout.alert_tasarim, null);
        EditText editTextAd, editTextTel;
        editTextAd = tasarim.findViewById(R.id.editTextAd);
        editTextTel = tasarim.findViewById(R.id.editTextTel);

        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setTitle("Kişi Ekle");
        ad.setView(tasarim);
        ad.setPositiveButton("Ekle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String kisiAd = editTextAd.getText().toString().trim();
                String kisiTel = editTextTel.getText().toString().trim();

                new KisilerDAO().KisiEkle(vt, kisiAd, kisiTel);
                kisilerArrayList = new KisilerDAO().tumKisiler(vt);
                adapter = new KisilerAdapter(MainActivity.this, kisilerArrayList, vt);
                rv.setAdapter(adapter);
            }
        });
        ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ad.create().show();
    }
}