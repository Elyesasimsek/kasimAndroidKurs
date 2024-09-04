package com.example.a067kisileruygulamasimvvm.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.a067kisileruygulamasimvvm.data.entity.Kisiler;
import com.example.a067kisileruygulamasimvvm.room.KisilerDAO;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class KisilerDAORepository {
    private MutableLiveData<List<Kisiler>> kisilerList;
    private KisilerDAO kdao;

    public KisilerDAORepository(KisilerDAO kdao) {
        this.kdao = kdao;
        kisilerList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Kisiler>> kisileriGetir(){
        return kisilerList;
    }

    public void kisiKayit(String kisiAd, String kisiTel){
        Kisiler eklenenKisi = new Kisiler(0, kisiAd, kisiTel);
        kdao.kisiEkle(eklenenKisi).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
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

    public void kisiGuncelle(int kisiId, String kisiAd, String kisiTel){
        Kisiler guncellenenKisi = new Kisiler(kisiId, kisiAd, kisiTel);
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

    public void kisiAra(String aramaKelimesi) {
        kdao.kisiAra(aramaKelimesi).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<Kisiler>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<Kisiler> list) {
                kisilerList.setValue(list);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public void kisiSil(int kisiId){
        Kisiler silinenKisi = new Kisiler(kisiId, "", "");
        kdao.kisiSil(silinenKisi).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
                tumKisileriAl();
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public void tumKisileriAl(){
        kdao.tumKisiler().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<Kisiler>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<Kisiler> list) {
                kisilerList.setValue(list);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

}
