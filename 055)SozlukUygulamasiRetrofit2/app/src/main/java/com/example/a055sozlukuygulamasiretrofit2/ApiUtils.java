package com.example.a055sozlukuygulamasiretrofit2;

public class ApiUtils {
    public static  final  String BASE_URL = "https://elyesasimsek.com/";
    public static  KelimelerDAOInterface getKisilerDaoInterface() {
        return RetrofitClient.getClient(BASE_URL).create(KelimelerDAOInterface.class);
    }
}
