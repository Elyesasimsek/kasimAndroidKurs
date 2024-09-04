package com.example.a006collectionscalismasi;

public class Ogrencii {
    private  int okulNo;
    private  String isim;

    public Ogrencii() {
    }

    public Ogrencii(int okulNo, String isim) {
        this.okulNo = okulNo;
        this.isim = isim;
    }

    public int getOkulNo() {
        return okulNo;
    }

    public void setOkulNo(int okulNo) {
        this.okulNo = okulNo;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
}
