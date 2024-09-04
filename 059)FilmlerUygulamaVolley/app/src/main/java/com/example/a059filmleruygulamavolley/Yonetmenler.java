package com.example.a059filmleruygulamavolley;

import java.io.Serializable;

public class Yonetmenler implements Serializable {
    private int yonetmenId;
    private String yonetmenAd;

    public Yonetmenler() {
    }

    public Yonetmenler(int yonetmenId, String yonetmenAd) {
        this.yonetmenId = yonetmenId;
        this.yonetmenAd = yonetmenAd;
    }

    public int getYonetmenId() {
        return yonetmenId;
    }

    public void setYonetmenId(int yonetmenId) {
        this.yonetmenId = yonetmenId;
    }

    public String getYonetmenAd() {
        return yonetmenAd;
    }

    public void setYonetmenAd(String yonetmenAd) {
        this.yonetmenAd = yonetmenAd;
    }
}
