package com.riska.riskatulmahmudah.antrianpasien;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerawatActivity extends AppCompatActivity {
    //3.Deklarasikan Rv
    RecyclerView rvDataPasien;
    //18 deklarasikan
    ArrayList<ResultAntrianItem> mList = new ArrayList<>();
    //23 tambahkan variabel global
    AdapterPerawat adapter;
    List<ResultAntrianItem>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perawat);
        //4.FindviewByid kan recyclerview
        rvDataPasien = findViewById(R.id.rvDataPasien);

        //20 panggil initData
        initData();
        //22 Panggil initToRecycler

    }
    //19 tambahkan initData
    public void initData(){
        //for(int i=0;i<10;i++){
         //   mList.add(new DataAntrian(i,"Nama Antrian "+i,"Alamat Antrian "+i));
       // }
        RetroServer.getInstance().readAntrian(getIntent().getStringExtra("dokter_id")).enqueue(new Callback<ResponseAntrian>() {
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

    //21 tambahkan initToRecyler dan isi 3 baris
    public void initToRecycler(){
        adapter = new AdapterPerawat(this, mList);
        rvDataPasien.setHasFixedSize(true);
        rvDataPasien.setLayoutManager(new LinearLayoutManager(this));
        rvDataPasien.setAdapter(adapter);

        //24Panggil setDragRv
        setDragRecyclerView();

    }
    //23
    public void setDragRecyclerView(){
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rvDataPasien.addItemDecoration(divider);

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,0) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder drag,
                                  @NonNull RecyclerView.ViewHolder drop) {
                int dragged = drag.getAdapterPosition();
                int dropped = drop.getAdapterPosition();
                Collections.swap(mList,dragged,dropped);
                adapter.notifyItemMoved(dragged,dropped);
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            }
        });
        helper.attachToRecyclerView(rvDataPasien);
    }
}
