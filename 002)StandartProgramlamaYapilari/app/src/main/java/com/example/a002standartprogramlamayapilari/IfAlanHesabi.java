package com.example.a002standartprogramlamayapilari;

import java.util.Scanner;

public class IfAlanHesabi {
    public static void main(String[] args) {
        Scanner tarayici = new Scanner(System.in);
        System.out.println("Alan hesabına hoşgeldiniz.");
        System.out.println("(1) Dikdörtgen alanı.");
        System.out.println("(2) Çember alanı.");
        int tercih = tarayici.nextInt();
        if (tercih == 1){
            System.out.print("Kısa kenar giriniz: ");
            int kisaKenar = tarayici.nextInt();
            System.out.print("Uzun kenarı giriniz: ");
            int uzunKenar = tarayici.nextInt();
            System.out.println("Sonuç: " + (kisaKenar * uzunKenar));
        } else if (tercih == 2) {
            System.out.print("Yarıçapı Giriniz: ");
            int yariCap = tarayici.nextInt();
            System.out.println("Çebmer alanı: " + (3.14 * yariCap * yariCap));
        }
    }
}
