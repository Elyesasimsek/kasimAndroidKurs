package com.example.a004nesnetabanliprogramlama2.siniflar;

public class Yonetmenler {
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
