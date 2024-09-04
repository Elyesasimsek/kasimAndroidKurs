package com.example.a050retrofitcalismasi;

public class ApiUtils {
    public static  final  String BASE_URL = "https://elyesasimsek.com/";
    public static  KisilerDAOInterface getKisilerDaoInterface(){
        return RetrofitClient.getClient(BASE_URL).create(KisilerDAOInterface.class);
    }
}
