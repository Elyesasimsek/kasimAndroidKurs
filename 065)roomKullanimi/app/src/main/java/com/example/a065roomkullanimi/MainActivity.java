package com.example.a065roomkullanimi;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Veritabani vt;
    private KisilerDAOInterface kdao;

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

        vt = Veritabani.veritabaniErisim(this);
        kdao = vt.getKisilerDAO();

        kontrol();
        //getir();
        //ara();
        //rastgelel();
        //sil();
        //guncelle();
        //ekle();
        //kisilerYukle();
    }

    public  void kisilerYukle(){
        kdao.tumKisiler().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<Kisiler>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<Kisiler> kisilers) {
                for (Kisiler k:kisilers){
                    Log.e("kisiId", String.valueOf(k.getKisiId()));
                    Log.e("kisiAd", k.getKisiAd());
                    Log.e("kisiYas", String.valueOf(k.getKisiYas()));
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public  void ekle(){
        Kisiler yeniKisi = new Kisiler(0, "Bekir", 45);

        kdao.kisiEkle(yeniKisi).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public  void guncelle(){
        Kisiler guncellenenKisi = new Kisiler(3, "Bekir", 50);

        kdao.kisiGuncelle(guncellenenKisi).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public void sil(){
        Kisiler silinenKisi = new Kisiler(4,"Bekir",45);

        kdao.kisiSil(silinenKisi).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public  void rastgelel(){
        kdao.rastgele1KisiGetir().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<Kisiler>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<Kisiler> kisilers) {
                for (Kisiler k:kisilers){
                    Log.e("kisiId", String.valueOf(k.getKisiId()));
                    Log.e("kisiAd", k.getKisiAd());
                    Log.e("kisiYas", String.valueOf(k.getKisiYas()));
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public  void ara(){
        kdao.kisiAra("r").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<Kisiler>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<Kisiler> kisilers) {
                for (Kisiler k:kisilers){
                    Log.e("kisiId", String.valueOf(k.getKisiId()));
                    Log.e("kisiAd", k.getKisiAd());
                    Log.e("kisiYas", String.valueOf(k.getKisiYas()));
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public  void getir(){
        kdao.kisiGetir(1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<Kisiler>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Kisiler kisiler) {
                Log.e("kisiId", String.valueOf(kisiler.getKisiId()));
                Log.e("kisiAd", kisiler.getKisiAd());
                Log.e("kisiYas", String.valueOf(kisiler.getKisiYas()));
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public  void kontrol(){
        kdao.kayitKontrol("Elyesa").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Integer integer) {
                Log.e("Kişi kayıt kontrol", String.valueOf(integer));
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}