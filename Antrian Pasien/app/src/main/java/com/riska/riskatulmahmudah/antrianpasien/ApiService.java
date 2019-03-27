package com.riska.riskatulmahmudah.antrianpasien;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("get_antrian.php")
    Call<ResponseAntrian> readAntrian(@Field("dokter_id") String dokter_id);

    @GET("get_dokter.php")
    Call<ResponseDokter> readDokter();

}
