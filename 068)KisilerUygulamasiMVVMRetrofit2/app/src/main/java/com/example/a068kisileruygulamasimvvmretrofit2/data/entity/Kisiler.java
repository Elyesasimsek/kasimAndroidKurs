package com.example.a068kisileruygulamasimvvmretrofit2.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Kisiler implements Serializable {
    @SerializedName("kisiId")
    private int kisiId;
    @SerializedName("kisiAd")
    private String kisiAd;
    @SerializedName("kisiTel")
    private String kisiTel;

    public Kisiler() {
    }

    public Kisiler(int kisiId, String kisiAd, String kisiTel) {
        this.kisiId = kisiId;
        this.kisiAd = kisiAd;
        this.kisiTel = kisiTel;
    }

    public int getKisiId() {
        return kisiId;
    }

    public void setKisiId(int kisiId) {
        this.kisiId = kisiId;
    }

    public String getKisiAd() {
        return kisiAd;
    }

    public void setKisiAd(String kisiAd) {
        this.kisiAd = kisiAd;
    }

    public String getKisiTel() {
        return kisiTel;
    }

    public void setKisiTel(String kisiTel) {
        this.kisiTel = kisiTel;
    }
}
