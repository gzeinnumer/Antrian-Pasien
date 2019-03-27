package com.riska.riskatulmahmudah.antrianpasien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DokterActivity extends AppCompatActivity {
    //3.Deklarasikan Rv
    RecyclerView rvDataDokter;
    //18 deklarasikan
    ArrayList<ResultDokterItem> mList = new ArrayList<>();
    //23 tambahkan variabel global
    AdapterDokter adapter;
    List<ResultDokterItem> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokter);

        rvDataDokter = findViewById(R.id.rvdatadokter);

        initData();
    }
    public void initData(){
        //hapus for
        //for(int i=0;i<10;i++){
          //  mList.add(new DataDokter(i,"Nama Dokter "+i,"Spesialis Dokter "+i,"Alamat "+i));
        //}
        RetroServer.getInstance().readDokter().enqueue(new Callback<ResponseDokter>() {
            @Override
            public void onResponse(Call<ResponseDokter> call, Response<ResponseDokter> response) {

                list = response.body().getResultDokter();
                for (int i=0; i<list.size(); i++){
                    String temp1= list.get(i).getDokterId();
                    String temp2= list.get(i).getDokterAlamat();
                    String temp3= list.get(i).getDokterNama();
                    String temp4= list.get(i).getDokterSpesialis();
                    mList.add(new ResultDokterItem(temp1, temp2, temp3, temp4));
                }

                initToRecycler();
            }

            @Override
            public void onFailure(Call<ResponseDokter> call, Throwable t) {

            }
        });

    }
    public void initToRecycler(){
        adapter = new AdapterDokter(this, mList);
        rvDataDokter.setHasFixedSize(true);
        rvDataDokter.setLayoutManager(new LinearLayoutManager(this));
        rvDataDokter.setAdapter(adapter);

    }
}
