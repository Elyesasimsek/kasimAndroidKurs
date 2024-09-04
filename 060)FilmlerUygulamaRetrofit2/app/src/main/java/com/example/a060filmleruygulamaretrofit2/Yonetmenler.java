
package com.example.a060filmleruygulamaretrofit2;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Yonetmenler implements Serializable {

    @SerializedName("yonetmenId")
    @Expose
    private String yonetmenId;
    @SerializedName("yonetmenAd")
    @Expose
    private String yonetmenAd;

    public String getYonetmenId() {
        return yonetmenId;
    }

    public void setYonetmenId(String yonetmenId) {
        this.yonetmenId = yonetmenId;
    }

    public String getYonetmenAd() {
        return yonetmenAd;
    }

    public void setYonetmenAd(String yonetmenAd) {
        this.yonetmenAd = yonetmenAd;
    }

}
