package com.example.a002standartprogramlamayapilari;

public class DizilerDonguler {
    public static void main(String[] args) {
        String sehirler[] = {"Sivas", "Bursa", "İzmir", "Manisa", "Van"};

        for (int i = 0; i < sehirler.length;i++){
            System.out.println(sehirler[i]);
        }

        System.out.println(sehirler[0]);

        String maralar[] = {"apple", "google", "monster"};

        for (int i = 0;i < maralar.length;i++){
            System.out.println(maralar[i]);
        }

        String isimler[] = {"Elyesa", "Fatma", "Meryem", "Bekir", "Rabia"};

        for (String s:isimler){
            System.out.println(s);
        }
    }
}
