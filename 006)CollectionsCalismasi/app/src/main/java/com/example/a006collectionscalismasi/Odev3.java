package com.example.a006collectionscalismasi;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Odev3 {
    public static void main(String[] args) {
        ArrayList<Integer> sayilar = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int sayi = random.nextInt(101);

        for (int i = 0;i < 5;i++){
            System.out.print((i + 1) + ". tahminini giriniz: ");
            int tahmin = scanner.nextInt();
            sayilar.add(tahmin);
            if (tahmin == sayi){
                System.out.println("Tebrikler kazandınız.");
                break;
            } else if (tahmin > sayi) {
                System.out.println("Tahminini azalt");
            }else {
                System.out.println("Tahminini yükset");
            }
        }
        System.out.println("--------------");
        System.out.println("Üretilen sayı: " + sayi);
        System.out.println("Tahminler:");
        for (Integer i:sayilar){
            System.out.print(i + "  ");
        }
    }
}
