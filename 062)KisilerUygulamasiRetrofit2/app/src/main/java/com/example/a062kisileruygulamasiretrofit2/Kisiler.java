
package com.example.a062kisileruygulamasiretrofit2;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Kisiler {

    @SerializedName("kisiId")
    @Expose
    private String kisiId;
    @SerializedName("kisiAd")
    @Expose
    private String kisiAd;
    @SerializedName("kisiTel")
    @Expose
    private String kisiTel;

    public String getKisiId() {
        return kisiId;
    }

    public void setKisiId(String kisiId) {
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
