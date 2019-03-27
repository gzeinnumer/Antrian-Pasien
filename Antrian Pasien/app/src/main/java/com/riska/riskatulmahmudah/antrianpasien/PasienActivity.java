package com.riska.riskatulmahmudah.antrianpasien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PasienActivity extends AppCompatActivity {
    RecyclerView rvpasien;
    ArrayList<ResultAntrianItem> mList = new ArrayList<>();
    List<ResultAntrianItem>list;
    AdapterPasien adapter;

    public static String no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasien);
        rvpasien = findViewById(R.id.rvpasien);

        Intent intent = getIntent();
        no= intent.getStringExtra("no");

        initData();

    }
    public void initData(){
        //for(int i=0;i<10;i++){
         //   mList.add(new DataAntrian(i,"Nama Antrian "+i,"Alamat Antrian "+i));
        //}
        String dokter_id ="";
        RetroServer.getInstance().readAntrian(dokter_id).enqueue(new Callback<ResponseAntrian>() {
            @Override
            public void onResponse(Call<ResponseAntrian> call, Response<ResponseAntrian> response) {
                list = response.body().getResultAntrian();
                for (int i=0; i<list.size(); i++){
                    String temp1 = list.get(i).getPasienId();
                    String temp2 = list.get(i).getPasienNama();
                    String temp3 = list.get(i).getDokterId();
                    String temp4 = list.get(i).getPasienAlamat();
                    String temp5 = list.get(i).getPasienAntrian();

                    mList.add(new ResultAntrianItem(temp1, temp2, temp3, temp4, temp5));
                }
                initToRecycler();
            }

            @Override
            public void onFailure(Call<ResponseAntrian> call, Throwable t) {

            }
        });

    }
    public void initToRecycler(){
        adapter = new AdapterPasien(this, mList);
        rvpasien.setHasFixedSize(true);
        rvpasien.setLayoutManager(new LinearLayoutManager(this));
        rvpasien.setAdapter(adapter);

    }

}
