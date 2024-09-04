package com.example.a045filmleruygulama;

import java.io.Serializable;

public class Kategoriler implements Serializable {
    private int kategoriId;
    private String kategoriAd;

    public Kategoriler() {
    }

    public Kategoriler(int kategoriId, String kategoriAd) {
        this.kategoriId = kategoriId;
        this.kategoriAd = kategoriAd;
    }

    public int getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(int kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getKategoriAd() {
        return kategoriAd;
    }

    public void setKategoriAd(String kategoriAd) {
        this.kategoriAd = kategoriAd;
    }
}
