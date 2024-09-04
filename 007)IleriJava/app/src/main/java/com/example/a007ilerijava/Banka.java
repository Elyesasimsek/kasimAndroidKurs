package com.example.a007ilerijava;

public class Banka {
    private int bakiye;

    public Banka() {
    }

    public Banka(int bakiye) {
        this.bakiye = bakiye;
    }

    public synchronized void paraCek(String isim, int tutar){
        if (tutar > bakiye){
            System.out.println(isim + ": hesapta yeterince para yok");
        }else {
            bakiye -= tutar;
            System.out.println(isim + ": hesapta kalan para: " + bakiye);
        }
    }
}
