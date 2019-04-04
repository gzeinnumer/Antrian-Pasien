package com.riska.riskatulmahmudah.antrianpasien;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
//    public static String BASE_URL = "https://gzeinnumer.000webhostapp.com/antrian/";
    public static String BASE_URL = "http://dev.smart-ics.com:222/antrian-api/Api/";
    public static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getInstance(){
        return setInit().create(ApiService.class);
    }
}
