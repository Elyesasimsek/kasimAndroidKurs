package com.example.a005nesnetabanliprogramlama;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Ogrenci {
    private int tcNo;
    private  String isim;

    public Ogrenci() {
    }

    public Ogrenci(int tcNo, String isim) {
        this.tcNo = tcNo;
        this.isim = isim;
    }

    public int getTcNo() {
        return tcNo;
    }

    public void setTcNo(int tcNo) {
        this.tcNo = tcNo;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    @NonNull
    @Override
    public String toString() {
        return "Öğrenci adı: " + isim + " TC no: " + tcNo;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (tcNo == ((Ogrenci)obj).getTcNo()){
            return true;
        }else {
            return false;
        }
    }
}
