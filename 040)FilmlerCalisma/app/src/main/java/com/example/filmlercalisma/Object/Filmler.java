package com.example.filmlercalisma.Object;

public class Filmler {
    private int film_id;
    private String film_ad;
    private int film_yil;
    private String film_resim;
    private Kategoriler kategori;
    private Yonetmenler yonetmen;

    public Filmler() {
    }

    public Filmler(int film_id, String film_ad, int film_yil, String film_resim, Kategoriler kategori, Yonetmenler yonetmen) {
        this.film_id = film_id;
        this.film_ad = film_ad;
        this.film_yil = film_yil;
        this.film_resim = film_resim;
        this.kategori = kategori;
        this.yonetmen = yonetmen;
    }


    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getFilm_ad() {
        return film_ad;
    }

    public void setFilm_ad(String film_ad) {
        this.film_ad = film_ad;
    }

    public int getFilm_yil() {
        return film_yil;
    }

    public void setFilm_yil(int film_yil) {
        this.film_yil = film_yil;
    }

    public String getFilm_resim() {
        return film_resim;
    }

    public void setFilm_resim(String film_resim) {
        this.film_resim = film_resim;
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
