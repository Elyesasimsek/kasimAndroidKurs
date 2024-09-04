package com.example.a043notlaruygulamasi;

import java.io.Serializable;

public class Notlar implements Serializable {
    private  int notId;
    private String dersAdi;
    private int not1;
    private int not2;

    public Notlar() {
    }

    public Notlar(int notId, String dersAdi, int not1, int not2) {
        this.notId = notId;
        this.dersAdi = dersAdi;
        this.not1 = not1;
        this.not2 = not2;
    }

    public int getNotId() {
        return notId;
    }

    public void setNotId(int notId) {
        this.notId = notId;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public int getNot1() {
        return not1;
    }

    public void setNot1(int not1) {
        this.not1 = not1;
    }

    public int getNot2() {
        return not2;
    }

    public void setNot2(int not2) {
        this.not2 = not2;
    }
}
