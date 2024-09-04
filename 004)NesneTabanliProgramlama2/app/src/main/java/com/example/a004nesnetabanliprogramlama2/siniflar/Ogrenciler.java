package com.example.a004nesnetabanliprogramlama2.siniflar;

public class Ogrenciler {
    private String isim;
    private String okulNo;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getOkulNo() {
        return okulNo;
    }

    public void setOkulNo(String okulNo) {
        this.okulNo = okulNo;
    }

    public void bilgial(){
        System.out.println("Öğrenci adı: " + isim);
        System.out.println("Öğrenci okul no: " + okulNo);
    }
}
