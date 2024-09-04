package com.example.a007ilerijava;

public class ThreadBankaMain {
    public static void main(String[] args) {
        Banka banka = new Banka(900);
        BankaIslemThread is1 = new BankaIslemThread(banka, "Elyesa", 500);
        BankaIslemThread is2 = new BankaIslemThread(banka, "Fatma", 500);
        is1.start();
        is2.start();
    }

    static class BankaIslemThread extends Thread{
        private Banka banka;
        private String isim;
        private int tutar;

        public BankaIslemThread(Banka banka, String isim, int tutar) {
            this.banka = banka;
            this.isim = isim;
            this.tutar = tutar;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
                banka.paraCek(isim,tutar);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
