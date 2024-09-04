package com.example.a003nesnetabanliprogramlama;

public class OdevlerSinifi {
    public void SicaklikDonustur(double sicaklik){
        double fahrenayt = sicaklik * 1.8 + 32;
        System.out.println("Sıcaklık fahrenaytı: " + fahrenayt);
    }

    public int cevreHesapla(int kisaKenar, int uzunKenar){
        int cevre = (2 * kisaKenar) + (2 * uzunKenar);
        return cevre;
    }

    public int faktoriyel(int sayi){
        int sonuc = 0;
        if (sayi == 0){
            sonuc = 1;
        } else if (sayi < 0) {
            System.out.println("Negatif sayıların faktoryeli yok.");
        }else {
            sonuc = 1;
            for (int i = sayi;i > 1;i--){
                sonuc *= i;
            }
        }
        return sonuc;
    }

    public void harfSayisiBul(String kelime, char harf){
        int boyut = kelime.length();
        char[] harfler = new char[boyut];

        for (int i = 0;i < boyut;i++){
            harfler[i] = kelime.charAt(i);
        }

        int sayac = 0;
        for (int i = 0;i < boyut;i++){
            if (harfler[i] == harf){
                sayac++;
            }
        }
        System.out.println("Harf sayısı: " + sayac);
    }

    public int icAciToplami(int kenarSayisi){
        int sonuc = (kenarSayisi - 2) * 180;
        return sonuc;
    }

    public void dilekceOlustur(String ogrenciAdi, String okulNo, int izinMiktari, String tarih, String veliAdi){
        String dilekce = "\t\t\t Bursa Anadolu Lisesi Müdürlüğüne, \n"
                + ogrenciAdi + " adlı " + okulNo + " nolu öğrencinin " + izinMiktari + " gün izinli olmasını rica ediyorum.\n" +
                "Tarih: " + tarih + "\n" +
                "Veli Ad-Soyad: " + veliAdi;
        System.out.println(dilekce);
    }

    public int maasHesapla(int gun){
        int calismaSaati = gun * 8;
        int mesaiSaati = calismaSaati - 160;
        int mesaiUcret = mesaiSaati * 100;
        int maas = 17002 + mesaiUcret;
        return maas;
    }

    public void internetUcretiHesapla(int gb){
        int fazlaGb = gb -50;
        int faturaMiktari = 100 + fazlaGb * 4;
        System.out.println("Fatura: " + faturaMiktari + " tl");
    }
}
