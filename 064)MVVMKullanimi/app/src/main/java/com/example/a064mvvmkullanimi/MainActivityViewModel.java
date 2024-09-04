package com.example.a064mvvmkullanimi;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<String> sonuc;
    private  MatematikRepository mrepo = new MatematikRepository();

    public MainActivityViewModel() {
        sonuc = mrepo.getMatematikselSonuc();
    }

    public MutableLiveData<String> getSonuc() {
        return sonuc;
    }

    public void toplamaYap(String alinansayi1, String alinansayi2){
        mrepo.topla(alinansayi1, alinansayi2);
    }

    public  void carpmaYap(String alinansayi1, String alinansayi2){
        mrepo.carp(alinansayi1, alinansayi2);
    }
}
