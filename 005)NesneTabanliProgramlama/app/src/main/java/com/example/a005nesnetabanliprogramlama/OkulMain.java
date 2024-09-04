package com.example.a005nesnetabanliprogramlama;

public class OkulMain {
    public static void main(String[] args) {
        Mudur mudur = new Mudur();
        Personel ogretmen = new Ogretmen();
        Personel isci = new Isci();

        mudur.iseAl(ogretmen);
        mudur.iseAl(isci);

        mudur.terfiEttir(ogretmen);
        mudur.terfiEttir(isci);
    }
}
