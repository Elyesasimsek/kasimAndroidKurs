package com.example.a057notlaruygulamasivolley;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
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

public class NotKayitActivity extends AppCompatActivity {

    private Toolbar toolbarNotKayit;
    private EditText editTextDers, editTextNot1, editTextNot2;
    private Button buttonKaydet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_not_kayit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbarNotKayit = findViewById(R.id.toolbarNotKayit);
        editTextDers = findViewById(R.id.editTextDers);
        editTextNot1 = findViewById(R.id.editTextNot1);
        editTextNot2 = findViewById(R.id.editTextNot2);
        buttonKaydet = findViewById(R.id.buttonKaydet);
        toolbarNotKayit.setTitle("Not Kayıt");
        setSupportActionBar(toolbarNotKayit);

        buttonKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dersAdi = editTextDers.getText().toString().trim();
                String not1 = editTextNot1.getText().toString().trim();
                String not2 = editTextNot2.getText().toString().trim();

                if (TextUtils.isEmpty(dersAdi)){
                    Snackbar.make(v, "Ders adı giriniz", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(not1)){
                    Snackbar.make(v, "Not 1 giriniz", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(not2)){
                    Snackbar.make(v, "Not 2 giriniz", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                String url = "https://elyesasimsek.com/notlar/insert_not.php";
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
                        params.put("dersAdi", editTextDers.getText().toString());
                        params.put("not1", editTextNot1.getText().toString());
                        params.put("not2", editTextNot2.getText().toString());
                        return params;
                    }
                };
                Volley.newRequestQueue(NotKayitActivity.this).add(stringRequest);

                startActivity(new Intent(NotKayitActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}