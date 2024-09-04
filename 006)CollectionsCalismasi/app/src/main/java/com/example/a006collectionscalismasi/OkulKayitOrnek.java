package com.example.a006collectionscalismasi;

import java.util.ArrayList;
import java.util.Scanner;

public class OkulKayitOrnek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Ogrencii> ogrenciler = new ArrayList<>();

        while (true) {
            System.out.print("Öğrenci okul no giriniz: ");
            int no = scanner.nextInt();

            System.out.print("Öğrenci ismini giriniz: ");
            String isim = scanner.next();

            Ogrencii yeniOgrenci = new Ogrencii(no, isim);
            ogrenciler.add(yeniOgrenci);

            System.out.println("Çıkış 1 - Devam için diğer sayılar.");
            int secim = scanner.nextInt();

            if (secim == 1){
                for (Ogrencii o:ogrenciler){
                    System.out.println("----------------");
                    System.out.println("Okul no: " + o.getOkulNo());
                    System.out.println("İsim: " + o.getIsim());
                }
                break;
            }
        }
    }
}
