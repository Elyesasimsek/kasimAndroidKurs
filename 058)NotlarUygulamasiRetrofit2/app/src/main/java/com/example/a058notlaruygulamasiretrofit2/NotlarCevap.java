
package com.example.a058notlaruygulamasiretrofit2;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class NotlarCevap {

    @SerializedName("notlar")
    @Expose
    private List<Notlar> notlar;
    @SerializedName("success")
    @Expose
    private Integer success;

    public List<Notlar> getNotlar() {
        return notlar;
    }

    public void setNotlar(List<Notlar> notlar) {
        this.notlar = notlar;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

}
