package com.example.sozlukuygulamasi;

public class Kelimeler {
    private int kelimeId;
    private String ingilizce;
    private String turkce;

    public Kelimeler(){
    }

    public Kelimeler(int kelimeId, String ingilizce, String turkce) {
        this.kelimeId = kelimeId;
        this.ingilizce = ingilizce;
        this.turkce = turkce;
    }

    public int getKelimeId() {
        return kelimeId;
    }

    public void setKelimeId(int kelimeId) {
        this.kelimeId = kelimeId;
    }

    public String getIngilizce() {
        return ingilizce;
    }

    public void setIngilizce(String ingilizce) {
        this.ingilizce = ingilizce;
    }

    public String getTurkce() {
        return turkce;
    }

    public void setTurkce(String turkce) {
        this.turkce = turkce;
    }
}
