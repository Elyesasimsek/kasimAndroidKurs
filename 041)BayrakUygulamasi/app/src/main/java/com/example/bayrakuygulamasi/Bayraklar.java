package com.example.bayrakuygulamasi;

public class Bayraklar {
    private int bayrakId;
    private String bayrakAd;
    private String bayrakResim;

    public Bayraklar() {
    }

    public Bayraklar(int bayrakId, String bayrakAd, String bayrakResim) {
        this.bayrakId = bayrakId;
        this.bayrakAd = bayrakAd;
        this.bayrakResim = bayrakResim;
    }

    public int getBayrakId() {
        return bayrakId;
    }

    public void setBayrakId(int bayrakId) {
        this.bayrakId = bayrakId;
    }

    public String getBayrakAd() {
        return bayrakAd;
    }

    public void setBayrakAd(String bayrakAd) {
        this.bayrakAd = bayrakAd;
    }

    public String getBayrakResim() {
        return bayrakResim;
    }

    public void setBayrakResim(String bayrakResim) {
        this.bayrakResim = bayrakResim;
    }
}
