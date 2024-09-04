package com.example.a045filmleruygulama;

import java.io.Serializable;

public class Filmler implements Serializable {
    private int filmId;
    private String filmAd;
    private int filmYil;
    private String filmResim;
    private Kategoriler kategori;
    private Yonetmenler yonetmen;

    public Filmler() {
    }

    public Filmler(int filmId, String filmAd, int filmYil, String filmResim, Kategoriler kategori, Yonetmenler yonetmen) {
        this.filmId = filmId;
        this.filmAd = filmAd;
        this.filmYil = filmYil;
        this.filmResim = filmResim;
        this.kategori = kategori;
        this.yonetmen = yonetmen;
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

    public int getFilmYil() {
        return filmYil;
    }

    public void setFilmYil(int filmYil) {
        this.filmYil = filmYil;
    }

    public String getFilmResim() {
        return filmResim;
    }

    public void setFilmResim(String filmResim) {
        this.filmResim = filmResim;
    }

    public Kategoriler getKategori() {
        return kategori;
    }

    public void setKategori(Kategoriler kategori) {
        this.kategori = kategori;
    }

    public Yonetmenler getYonetmen() {
        return yonetmen;
    }

    public void setYonetmen(Yonetmenler yonetmen) {
        this.yonetmen = yonetmen;
    }
}
