package com.example.a057notlaruygulamasivolley;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.Map;

public class DetayActivity extends AppCompatActivity {

    private Toolbar toolbarDetay;
    private EditText editTextDersDetay, editTextNot1Detay, editTextNot2Detay;
    private Notlar not;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detay);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbarDetay = findViewById(R.id.toolbarDetay);
        editTextDersDetay = findViewById(R.id.editTextDersDetay);
        editTextNot1Detay = findViewById(R.id.editTextNot1Detay);
        editTextNot2Detay = findViewById(R.id.editTextNot2Detay);
        not = (Notlar) getIntent().getSerializableExtra("nesne");
        toolbarDetay.setTitle("Not Detay");
        setSupportActionBar(toolbarDetay);

        editTextDersDetay.setText(not.getDersAdi());
        editTextNot1Detay.setText(String.valueOf(not.getNot1()));
        editTextNot2Detay.setText(String.valueOf(not.getNot2()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.actionSil){
            Snackbar.make(toolbarDetay, "Siilinsin mi?", Snackbar.LENGTH_SHORT).setAction("Evet", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String url = "https://elyesasimsek.com/notlar/delete_not.php";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();

                            params.put("notId", String.valueOf(not.getNotId()));
                            return params;
                        }
                    };
                    Volley.newRequestQueue(DetayActivity.this).add(stringRequest);

                    startActivity(new Intent(DetayActivity.this, MainActivity.class));
                    finish();
                }
            }).show();
            return true;
        } else if (id == R.id.actionDuzenle) {
            String dersAdi = editTextDersDetay.getText().toString().trim();
            String not1 = editTextNot1Detay.getText().toString().trim();
            String not2 = editTextNot2Detay.getText().toString().trim();

            if (TextUtils.isEmpty(dersAdi)){
                Snackbar.make(toolbarDetay, "Ders adı giriniz", Snackbar.LENGTH_SHORT).show();
                return false;
            }
            if (TextUtils.isEmpty(not1)){
                Snackbar.make(toolbarDetay, "Not 1 giriniz", Snackbar.LENGTH_SHORT).show();
                return false;
            }
            if (TextUtils.isEmpty(not2)){
                Snackbar.make(toolbarDetay, "Not 2 giriniz", Snackbar.LENGTH_SHORT).show();
                return false;
            }

            String url = "https://elyesasimsek.com/notlar/update_not.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("notId", String.valueOf(not.getNotId()));
                    params.put("dersAdi", editTextDersDetay.getText().toString());
                    params.put("not1", editTextNot1Detay.getText().toString());
                    params.put("not2", editTextNot2Detay.getText().toString());
                    return params;
                }
            };
            Volley.newRequestQueue(DetayActivity.this).add(stringRequest);

            startActivity(new Intent(DetayActivity.this, MainActivity.class));
            finish();
            return true;
        }else {
            return false;
        }
    }
}