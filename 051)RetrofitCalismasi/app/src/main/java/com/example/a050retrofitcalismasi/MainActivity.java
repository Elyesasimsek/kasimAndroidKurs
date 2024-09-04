package com.example.a050retrofitcalismasi;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private KisilerDAOInterface kisilerDIF;

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
        kisilerDIF = ApiUtils.getKisilerDaoInterface();
        //TumKisiler();
        //KisiAra();
        //KisiSil();
        //KisiEkle();
        KisiGuncelle();
    }

    public void TumKisiler(){
        kisilerDIF.tumKisiler().enqueue(new Callback<KisilerCevap>() {
            @Override
            public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {
                List<Kisiler> kisilerList = response.body().getKisiler();
                for (Kisiler k:kisilerList){
                    Log.e("*****","*****");
                    Log.e("kisiId", k.getKisiId());
                    Log.e("kisiAd", k.getKisiAd());
                    Log.e("kisiTel", k.getKisiTel());
                }
            }

            @Override
            public void onFailure(Call<KisilerCevap> call, Throwable t) {

            }
        });
    }

    public void KisiAra(){
        kisilerDIF.kisiAra("a").enqueue(new Callback<KisilerCevap>() {
            @Override
            public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {
                List<Kisiler> kisilerList = response.body().getKisiler();
                for (Kisiler k:kisilerList){
                    Log.e("*****","*****");
                    Log.e("kisiId", k.getKisiId());
                    Log.e("kisiAd", k.getKisiAd());
                    Log.e("kisiTel", k.getKisiTel());
                }
            }

            @Override
            public void onFailure(Call<KisilerCevap> call, Throwable t) {

            }
        });
    }

    public void KisiSil(){
        kisilerDIF.kisiSil(8).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                Log.e("Başarı", response.body().getSuccess().toString());
                Log.e("Mesaj", response.body().getMessage().toString());
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }

    public void KisiEkle(){
        kisilerDIF.kisiEkle("Meryem", "00000000000").enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                Log.e("Başarı", response.body().getSuccess().toString());
                Log.e("Mesaj", response.body().getMessage().toString());
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }

    public void KisiGuncelle(){
        kisilerDIF.kisiGuncelle(9, "Meryem", "05000000000").enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                Log.e("Başarı", response.body().getSuccess().toString());
                Log.e("Mesaj", response.body().getMessage().toString());
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }
}