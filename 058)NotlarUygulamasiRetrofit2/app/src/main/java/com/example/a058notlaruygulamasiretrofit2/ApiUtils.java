package com.example.a058notlaruygulamasiretrofit2;

public class ApiUtils {
    public static  final  String BASE_URL = "https://elyesasimsek.com/";
    public static  NotlarDAOInterface getNotlarDaoInterface(){
        return RetrofitClient.getClient(BASE_URL).create(NotlarDAOInterface.class);
    }
}
