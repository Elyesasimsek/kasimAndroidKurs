package com.example.a060filmleruygulamaretrofit2;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FilmlerDAOInterface {
    @GET("filmler/tum_kategoriler.php")
    Call<KategorilerCevap> tumKategoriler();

    @POST("filmler/filmler_by_kategori_id.php")
    @FormUrlEncoded
    Call<FilmlerCevap> filmGetir(@Field("kategoriId") int kategoriId);
}
