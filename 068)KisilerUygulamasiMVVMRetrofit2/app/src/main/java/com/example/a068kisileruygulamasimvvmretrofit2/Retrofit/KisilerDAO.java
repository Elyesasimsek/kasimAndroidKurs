package com.example.a068kisileruygulamasimvvmretrofit2.Retrofit;

import com.example.a068kisileruygulamasimvvmretrofit2.data.entity.CRUDCevap;
import com.example.a068kisileruygulamasimvvmretrofit2.data.entity.KisilerCevap;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface KisilerDAO {
//https://elyesasimsek.com/kisiler/tum_kisiler.php
    @GET("kisiler/tum_kisiler.php")
    Call<KisilerCevap> tumKisiler();

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    Call<KisilerCevap> kisiAra(@Field("kisiAd") String kisiAd);

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    Call<CRUDCevap> kisiSil(@Field("kisiId") int kisiId);

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    Call<CRUDCevap> kisiEkle(@Field("kisiAd") String kisiAd, @Field("kisiTel") String kisiTel);

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    Call<CRUDCevap> kisiGuncelle(@Field("kisiId") int kisiId, @Field("kisiAd") String kisiAd, @Field("kisiTel") String kisiTel);
}
