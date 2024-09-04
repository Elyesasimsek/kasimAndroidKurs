package com.example.a068kisileruygulamasimvvmretrofit2.Retrofit;

public class ApiUtils {
    public static final String BASE_URL = "https://elyesasimsek.com/";

    public static KisilerDAO getKisilerDAO(){
        return RetrofitClient.getClient(BASE_URL).create(KisilerDAO.class);
    }
}
