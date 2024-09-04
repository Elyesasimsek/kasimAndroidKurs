package com.example.detaylirecyclerviewkullanimi;

public class Filmler {
    private int filmId;
    private String filmAd;
    private double filmFiyat;
    private  String filmResimAd;

    public Filmler() {
    }

    public Filmler(int filmId, String filmAd, double filmFiyat, String filmResimAd) {
        this.filmId = filmId;
        this.filmAd = filmAd;
        this.filmFiyat = filmFiyat;
        this.filmResimAd = filmResimAd;
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

    public double getFilmFiyat() {
        return filmFiyat;
    }

    public void setFilmFiyat(double filmFiyat) {
        this.filmFiyat = filmFiyat;
    }

    public String getFilmResimAd() {
        return filmResimAd;
    }

    public void setFilmResimAd(String filmResimAd) {
        this.filmResimAd = filmResimAd;
    }
}
