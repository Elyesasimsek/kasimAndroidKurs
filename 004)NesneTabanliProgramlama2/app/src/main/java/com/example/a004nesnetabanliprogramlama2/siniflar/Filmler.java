package com.example.a004nesnetabanliprogramlama2.siniflar;

public class Filmler {
    private int filmId;
    private String filmAd;
    private int filmYili;
    private Yonetmenler yonetmen;
    private Kategoriler kategori;

    public Filmler() {
    }

    public Filmler(int filmId, String filmAd, int filmYili, Yonetmenler yonetmen, Kategoriler kategori) {
        this.filmId = filmId;
        this.filmAd = filmAd;
        this.filmYili = filmYili;
        this.yonetmen = yonetmen;
        this.kategori = kategori;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmAd() {
        return filmAd;
    }

    public void setFilmAd(String filmAd) {
        this.filmAd = filmAd;
    }

    public int getFilmYili() {
        return filmYili;
    }

    public void setFilmYili(int filmYili) {
        this.filmYili = filmYili;
    }

    public Yonetmenler getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(Yonetmenler yonetmen) {
        this.yonetmen = yonetmen;
    }

    public Kategoriler getKategori() {
        return kategori;
    }

    public void setKategori(Kategoriler kategori) {
        this.kategori = kategori;
    }
}
