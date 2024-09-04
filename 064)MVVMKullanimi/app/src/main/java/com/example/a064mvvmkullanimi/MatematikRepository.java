package com.example.a064mvvmkullanimi;

import androidx.lifecycle.MutableLiveData;

public class MatematikRepository {
    private MutableLiveData<String> matematikselSonuc;

    public MatematikRepository() {
        matematikselSonuc = new MutableLiveData<String>("0");
    }

    public MutableLiveData<String> getMatematikselSonuc() {
        return matematikselSonuc;
    }

    public void topla (String alinansayi1, String alinansayi2){
        int sayi1 = Integer.parseInt(alinansayi1);
        int sayi2 = Integer.parseInt(alinansayi2);

        int toplam = sayi1 + sayi2;

        matematikselSonuc.setValue(String.valueOf(toplam));
    }

    public  void carp(String alinansayi1, String alinansayi2){
        int sayi1 = Integer.parseInt(alinansayi1);
        int sayi2 = Integer.parseInt(alinansayi2);

        int carpma  = sayi1 * sayi2;

        matematikselSonuc.setValue(String.valueOf(carpma));
    }
}
