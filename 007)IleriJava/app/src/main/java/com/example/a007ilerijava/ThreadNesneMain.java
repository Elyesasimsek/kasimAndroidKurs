package com.example.a007ilerijava;

public class ThreadNesneMain {
    public static void main(String[] args) {
        Ogrenci elyesa = new Ogrenci(625, "Elyesa");
        BenimThread benimThread = new BenimThread("İlk iş", elyesa);
        benimThread.start();

        Ogrenci fatma = new Ogrenci(628, "Fatma");
        BenimThread benimThread1 = new BenimThread("İkinci iş", fatma);
        benimThread1.start();
    }

    static class BenimThread extends Thread{
        private String isinAdi;
        private Ogrenci ogrenci;

        public BenimThread(String isinAdi, Ogrenci ogrenci) {
            this.isinAdi = isinAdi;
            this.ogrenci = ogrenci;
        }

        @Override
        public void run() {
            ogrenci.bilgiAl(isinAdi)
            ;
        }
    }
}
