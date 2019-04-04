package com.riska.riskatulmahmudah.antrianpasien;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @FormUrlEncoded
    @POST("get_antrian.php")
    Call<ResponseAntrian> readAntrian(@Field("dokter_id") String dokter_id);

    @GET("get_dokter.php")
    Call<ResponseDokter> readDokter();

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseLogin> login(@Field("user_email") String user_email);

    @GET("Antrian/ListAntrian")
    Call<List<ResponseAntrianAPI>> readAntrianAPI(@Query("dokterID") String dokterID,
                                             @Query("tgl") String tgl,
                                             @Query("jam") String jam,
                                             @Query("rsid") String rsid);

}
