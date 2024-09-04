package com.example.a057notlaruygulamasivolley;

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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbarMain;
    private RecyclerView rv;
    private FloatingActionButton fab;
    private ArrayList<Notlar> notlarArrayList;
    private NotlarAdapter adapter;

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

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        tumNotar();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NotKayitActivity.class));
            }
        });
    }

    public void tumNotar(){
        String url = "https://elyesasimsek.com/notlar/tum_notlar.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
""                double toplam = 0;

                notlarArrayList = new ArrayList<>();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray notlarList = jsonObject.getJSONArray("notlar");
                    for (int i = 0;i < notlarList.length();i++){
                        JSONObject n = notlarList.getJSONObject(i);
                        int notId = n.getInt("notId");
                        String dersAdi = n.getString("dersAdi");
                        int not1 = n.getInt("not1");
                        int not2 = n.getInt("not2");
                        Notlar not  = new Notlar(notId, dersAdi, not1, not2);
                        notlarArrayList.add(not);
                    }
                    for (Notlar notlar:notlarArrayList){
                        toplam = toplam + (double) (notlar.getNot1() + notlar.getNot2()) /2;
                    }
                    adapter = new NotlarAdapter(MainActivity.this, notlarArrayList);
                    rv.setAdapter(adapter);
                    toolbarMain.setSubtitle("Ortalama: " + toplam/notlarArrayList.size());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(MainActivity.this).add(stringRequest);
    }
}