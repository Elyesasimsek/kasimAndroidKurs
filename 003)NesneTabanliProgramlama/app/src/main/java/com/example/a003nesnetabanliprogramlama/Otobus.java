package com.example.a003nesnetabanliprogramlama;

public class Otobus {
    int kapasite;
    int mevcutYolcu;
    String nereden;
    String nereye;
    String marka;

    public void bilgiAl(){
        System.out.println(marka + "Kapasite: " + kapasite);
        System.out.println(marka + "Mevcut yolcu: " + mevcutYolcu);
        System.out.println(marka + "Nereden: " + nereden);
        System.out.println(marka + "Nereye: " + nereye);
    }

    public void yolcuAl(int yolcuMiktari){
        mevcutYolcu += yolcuMiktari;
        if (mevcutYolcu >= kapasite){
            System.out.println(marka + "Otobüs dolu");
        }else {
            System.out.println(marka + "Yolcu sayısı: " + mevcutYolcu);
        }
    }

    public void yolcuIndir(int yolcuMiktari){
        mevcutYolcu -= yolcuMiktari;
        if (mevcutYolcu == 0){
            System.out.println(marka + "Otobüs boş");
        } else if (mevcutYolcu < 0) {
            System.out.println(marka + "Hata");
        } else {
            System.out.println(marka + "Yolcu sayısı: " + mevcutYolcu);
        }
    }
}
