package com.example.a058notlaruygulamasiretrofit2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NotlarDAOInterface {
    @GET("notlar/tum_notlar.php")
    Call<NotlarCevap> tumNotlar();

    @POST("notlar/insert_not.php")
    @FormUrlEncoded
    Call<NotlarCevap> notEkle(@Field("dersAdi") String dersAdi, @Field("not1") int not1, @Field("not2") int not2);

    @POST("notlar/delete_not.php")
    @FormUrlEncoded
    Call<NotlarCevap> notSil(@Field("notId") int notId);

    @POST("notlar/update_not.php")
    @FormUrlEncoded
    Call<NotlarCevap> notGuncelle(@Field("notId") int notId, @Field("dersAdi") String dersAdi, @Field("not1") int not1, @Field("not2") int not2);
}
