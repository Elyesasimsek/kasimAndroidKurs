package com.example.a005nesnetabanliprogramlama;

public class Arac {
    private String renk;
    private String vitesTipi;

    public Arac() {
        super();
        System.out.println("Araç boş constructor çalıştı");
    }

    public Arac(String renk, String vitesTipi) {
        super();
        System.out.println("Araç dolu constructor çalıştı");
        this.renk = renk;
        this.vitesTipi = vitesTipi;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public String getVitesTipi() {
        return vitesTipi;
    }

    public void setVitesTipi(String vitesTipi) {
        this.vitesTipi = vitesTipi;
    }
}
