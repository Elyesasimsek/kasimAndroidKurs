package com.example.a004nesnetabanliprogramlama2.siniflar;

public class Personel {
    private String isim;
    private int yas;
    public static int sayac;

    public Personel(){
        sayac++;
    }

    public Personel(String isim, int yas) {
        sayac++;
        this.isim = isim;
        this.yas = yas;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }
}
