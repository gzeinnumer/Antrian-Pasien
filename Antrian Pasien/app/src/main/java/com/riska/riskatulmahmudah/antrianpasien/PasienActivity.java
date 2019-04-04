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
    ArrayList<ResponseAntrianAPI> mList = new ArrayList<>();
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
        RetroServer.getInstance().readAntrianAPI(
                "agusbudiman@gmail.com",
                "04-04-2019",
                "09:00:00",
                "RSPWD")
                .enqueue(new Callback<List<ResponseAntrianAPI>>() {
                    @Override
                    public void onResponse(Call<List<ResponseAntrianAPI>> call, Response<List<ResponseAntrianAPI>> response) {

                        List<ResponseAntrianAPI> list = response.body();
                        for (int i=0; i<list.size(); i++){
                            mList.add(new ResponseAntrianAPI(
                                    list.get(i).getDokterID(),
                                    list.get(i).getNoUrut(),
                                    list.get(i).getAntrianID(),
                                    list.get(i).getNoAntrian(),
                                    list.get(i).getJam(),
                                    list.get(i).getTgl(),
                                    list.get(i).getRSID(),
                                    list.get(i).getNamaPasien(),
                                    list.get(i).getDokterName()));
                        }
                        initToRecycler();
                    }

                    @Override
                    public void onFailure(Call<List<ResponseAntrianAPI>> call, Throwable t) {

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
