
package com.example.a060filmleruygulamaretrofit2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Filmler implements Serializable {

    @SerializedName("filmId")
    @Expose
    private String filmId;
    @SerializedName("filmAd")
    @Expose
    private String filmAd;
    @SerializedName("filmYil")
    @Expose
    private String filmYil;
    @SerializedName("filmResim")
    @Expose
    private String filmResim;
    @SerializedName("kategori")
    @Expose
    private Kategoriler kategori;
    @SerializedName("yonetmen")
    @Expose
    private Yonetmenler yonetmen;

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmAd() {
        return filmAd;
    }

    public void setFilmAd(String filmAd) {
        this.filmAd = filmAd;
    }

    public String getFilmYil() {
        return filmYil;
    }

    public void setFilmYil(String filmYil) {
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
