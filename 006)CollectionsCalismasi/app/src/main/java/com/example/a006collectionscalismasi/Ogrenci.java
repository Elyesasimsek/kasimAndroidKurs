package com.example.a006collectionscalismasi;

import androidx.annotation.Nullable;

public class Ogrenci implements Comparable<Ogrenci>{
    private  int tcNo;
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

    @Override
    public int compareTo(Ogrenci o) {
        return new String(this.isim).compareTo(o.getIsim());
    }

    @Override
    public int hashCode() {
        return this.tcNo;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (this.tcNo == ((Ogrenci)obj).getTcNo()){
            return true;
        }else {
            return false;
        }
    }
}
