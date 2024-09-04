package com.example.a004nesnetabanliprogramlama2.siniflar;

public class Renkler {
    public static final int BEYAZ = 111;
    public static final int SIYAH = 000;
    public static final int KIRMIZI = 333;

    public void boya(int renkTercihi){
        if (renkTercihi == 111)
            System.out.println("Beyaza boyandı.");
        if (renkTercihi == 000)
            System.out.println("Siyaha boyandı.");
        if (renkTercihi == 333)
            System.out.println("Kırmızıya boyandı.");

    }
}
