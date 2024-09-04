package com.example.a006collectionscalismasi;

import java.util.ArrayList;
import java.util.Scanner;

public class Odev4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Personel> personeller = new ArrayList<>();

        for (int i = 0;i < 5;i++){
            System.out.print((i + 1) + ". personel isim: ");
            String isim = scanner.next();

            System.out.print((i + 1) + ". personel adres il: ");
            String il = scanner.next();

            System.out.print((i + 1) + ". personel adres ilçe: ");
            String ilce = scanner.next();

            Adres yeniAdres = new Adres(il, ilce);
            Personel yeniPersonel = new Personel(i + 1, isim, yeniAdres);
            personeller.add(yeniPersonel);
        }

        for (Personel p:personeller){
            System.out.println("---------------------");
            System.out.println("Personel no: " + p.getPersonelNo());
            System.out.println("Personel isim: " + p.getIsim());
            System.out.println("---------Adres--------");
            System.out.println("Personel il: " + p.getAdres().getIl());
            System.out.println("Personel ilçe: " + p.getAdres().getIlce());

        }
    }
}
