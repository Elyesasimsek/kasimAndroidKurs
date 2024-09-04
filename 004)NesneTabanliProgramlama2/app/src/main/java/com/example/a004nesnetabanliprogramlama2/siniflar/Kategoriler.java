package com.example.a004nesnetabanliprogramlama2.siniflar;

public class Kategoriler {
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
