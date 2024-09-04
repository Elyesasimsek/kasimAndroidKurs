package com.example.a062kisileruygulamasiretrofit2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface KisilerDAOInterface {
    @GET("kisiler/tum_kisiler.php")
    Call<KisilerCevap> tumKisiler();

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    Call<KisilerCevap>  kisiEkle(@Field("kisiAd") String kisiAd, @Field("kisiTel") String kisiTel);

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    Call<KisilerCevap> kisiArama(@Field("kisiAd") String kisiAd);

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    Call<KisilerCevap> kisiSil(@Field("kisiId") int kisiId);

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    Call<KisilerCevap> kisiGuncelle(@Field("kisiId") int kisiId, @Field("kisiAd") String kisiAd, @Field("kisiTel") String kisiTel);

}
