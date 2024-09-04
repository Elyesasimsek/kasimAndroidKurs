package com.example.a068kisileruygulamasimvvmretrofit2.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KisilerCevap {
    @SerializedName("kisiler")
    @Expose
    private List<Kisiler> kisiler;
    @SerializedName("success")
    @Expose
    private int success;


    public KisilerCevap() {
    }

    public KisilerCevap(List<Kisiler> kisiler, int success) {
        this.kisiler = kisiler;
        this.success = success;
    }

    public List<Kisiler> getKisiler() {
        return kisiler;
    }

    public void setKisiler(List<Kisiler> kisiler) {
        this.kisiler = kisiler;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
