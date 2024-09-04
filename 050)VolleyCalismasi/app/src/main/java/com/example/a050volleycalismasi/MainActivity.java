package com.example.a050volleycalismasi;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

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
//        KisiEkle();
        //KisiGuncelle();
        //KisiSil();
        //TumKisiler();
        KisiArama();
    }

    public void KisiEkle(){
        String url = "http://elyesasimsek.com/kisiler/insert_kisiler.php";
        StringRequest istek = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap", response);
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
                params.put("kisiAd", "Zeynep Feyza");
                params.put("kisiTel", "05346664998");
                return params;
            }
        };
        Volley.newRequestQueue(this).add(istek);
    }

    public void KisiGuncelle(){
        String url = "https://elyesasimsek.com/kisiler/update_kisiler.php";
        StringRequest istek = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap", response);
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
                params.put("kisiId", "5");
                params.put("kisiAd", "Ahmet Baha");
                params.put("kisiTel", "05368932391");
                return params;
            }
        };
        Volley.newRequestQueue(this).add(istek);
    }

    public void KisiSil(){
        String url = "https://elyesasimsek.com/kisiler/delete_kisiler.php";
        StringRequest istek = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap", response);
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
                params.put("kisiId", "6");
                return params;
            }
        };
        Volley.newRequestQueue(this).add(istek);
    }

    public void TumKisiler(){
        String url = "https://elyesasimsek.com/kisiler/tum_kisiler.php";
        StringRequest istek = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray kisilerList = jsonObject.getJSONArray("kisiler");
                    for (int i = 0;i < kisilerList.length();i++){
                        JSONObject k = kisilerList.getJSONObject(i);
                        int kisiId = k.getInt("kisiId");
                        String kisiAd = k.getString("kisiAd");
                        String kisiTel = k.getString("kisiTel");
                        Log.e("kisiId", String.valueOf(kisiId));
                        Log.e("kisiAd", kisiAd);
                        Log.e("kisiTel", kisiTel);
                        Log.e("*****", "*****");
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(istek);
    }

    public void KisiArama(){
        String url = "https://elyesasimsek.com/kisiler/tum_kisiler_arama.php";
        StringRequest istek = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray kisilerList = jsonObject.getJSONArray("kisiler");
                    for (int i = 0;i < kisilerList.length();i++){
                        JSONObject k = kisilerList.getJSONObject(i);
                        int kisiId = k.getInt("kisiId");
                        String kisiAd = k.getString("kisiAd");
                        String kisiTel = k.getString("kisiTel");
                        Log.e("kisiId", String.valueOf(kisiId));
                        Log.e("kisiAd", kisiAd);
                        Log.e("kisiTel", kisiTel);
                        Log.e("*****", "*****");
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
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
                params.put("kisiAd", "a");
                return params;
            }
        };
        Volley.newRequestQueue(this).add(istek);
    }
}