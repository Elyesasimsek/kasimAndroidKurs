package com.example.a068kisileruygulamasimvvmretrofit2.data.repo;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.a068kisileruygulamasimvvmretrofit2.MainActivity;
import com.example.a068kisileruygulamasimvvmretrofit2.Retrofit.KisilerDAO;
import com.example.a068kisileruygulamasimvvmretrofit2.data.entity.CRUDCevap;
import com.example.a068kisileruygulamasimvvmretrofit2.data.entity.Kisiler;
import com.example.a068kisileruygulamasimvvmretrofit2.data.entity.KisilerCevap;
import com.example.a068kisileruygulamasimvvmretrofit2.ui.fragment.AnasayfaFragment;
import com.example.a068kisileruygulamasimvvmretrofit2.ui.viewmodel.AnasayfaViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KisilerDAORepository {
    private MutableLiveData<List<Kisiler>> kisilerList;
    private KisilerDAO kdao;
    private Context mContext;

    public KisilerDAORepository(KisilerDAO kdao) {
        this.kdao = kdao;
        kisilerList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Kisiler>> kisileriGetir(){
        return kisilerList;
    }

    public void kisiKayit(String kisiAd, String kisiTel){
        kdao.kisiEkle(kisiAd, kisiTel).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                tumKisileriAl();
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }

    public void kisiGuncelle(int kisiId, String kisiAd, String kisiTel){
        kdao.kisiGuncelle(kisiId, kisiAd, kisiTel).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                tumKisileriAl();
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }

    public void kisiAra(String aramaKelimesi){
        kdao.kisiAra(aramaKelimesi).enqueue(new Callback<KisilerCevap>() {
            @Override
            public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {
                List<Kisiler> list = response.body().getKisiler();
                kisilerList.setValue(list);
            }

            @Override
            public void onFailure(Call<KisilerCevap> call, Throwable t) {
                List<Kisiler> list = new ArrayList<>();
                kisilerList.setValue(list);
            }
        });
    }

    public void kisiSil(int kisiId){
        kdao.kisiSil(kisiId).enqueue(new Callback<CRUDCevap>() {
            @Override
            public void onResponse(Call<CRUDCevap> call, Response<CRUDCevap> response) {
                tumKisileriAl();
            }

            @Override
            public void onFailure(Call<CRUDCevap> call, Throwable t) {

            }
        });
    }

    public void tumKisileriAl(){
        kdao.tumKisiler().enqueue(new Callback<KisilerCevap>() {
            @Override
            public void onResponse(Call<KisilerCevap> call, Response<KisilerCevap> response) {
                List<Kisiler> list = response.body().getKisiler();
                kisilerList.setValue(list);
            }

            @Override
            public void onFailure(Call<KisilerCevap> call, Throwable t) {

            }
        });
    }
}
