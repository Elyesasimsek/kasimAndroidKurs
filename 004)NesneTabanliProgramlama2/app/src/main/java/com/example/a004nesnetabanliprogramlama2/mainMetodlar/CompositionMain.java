package com.example.a004nesnetabanliprogramlama2.mainMetodlar;

import com.example.a004nesnetabanliprogramlama2.siniflar.Adresler;
import com.example.a004nesnetabanliprogramlama2.siniflar.Filmler;
import com.example.a004nesnetabanliprogramlama2.siniflar.Kategoriler;
import com.example.a004nesnetabanliprogramlama2.siniflar.Kisiler;
import com.example.a004nesnetabanliprogramlama2.siniflar.Yonetmenler;

public class CompositionMain {
    public static void main(String[] args) {
      /*  Adresler adres = new Adresler("Sivas", "Merkez");
        Kisiler kisi1 = new Kisiler("Elyesa", 6586799, adres);
        System.out.println( "Kişi ad: " + kisi1.getIsim());
        System.out.println("Kişi tel: " + kisi1.getTel());
        System.out.println("Kişi il: " + kisi1.getAdres().getIl());
        System.out.println("Kişi ilçe: " + kisi1.getAdres().getIlce());*/

        Kategoriler kategori1 = new Kategoriler(1,"Korku");
        Kategoriler kategori2 = new Kategoriler(2,"Bilim Kurgu");
        Kategoriler kategori3 = new Kategoriler(3, "Gerilim");

        Yonetmenler yonetmen1 = new Yonetmenler(1,"Hasan KARACADAĞ");

        Filmler film = new Filmler(1, "Dabbe 3 ", 2012, yonetmen1, kategori1);
        System.out.println("Film id: " + film.getFilmId());
        System.out.println("Film ad: " + film.getFilmAd());
        System.out.println("Film yılı: " + film.getFilmYili());
        System.out.println("Film yönetmeni: " + film.getYonetmen().getYonetmenAd());
        System.out.println("Film kategori: " + film.getKategori().getKategoriAd());
    }
}
