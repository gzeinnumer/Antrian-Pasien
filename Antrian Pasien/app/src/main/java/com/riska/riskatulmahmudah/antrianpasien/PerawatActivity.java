package com.riska.riskatulmahmudah.antrianpasien;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerawatActivity extends AppCompatActivity implements AdapterPerawat.MyOnItemClick {
    //3.Deklarasikan Rv
    RecyclerView rvDataPasien;
    //18 deklarasikan
    ArrayList<ResponseAntrianAPI> mList = new ArrayList<>();
    //23 tambahkan variabel global
    AdapterPerawat adapter;
    List<ResultAntrianItem> list;
    @BindView(R.id.fab1)
    FloatingActionButton fab1;
    @BindView(R.id.fab2)
    FloatingActionButton fab2;
    @BindView(R.id.fab3)
    FloatingActionButton fab3;
    @BindView(R.id.fab4)
    FloatingActionButton fab4;

    public static int indexClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perawat);
        ButterKnife.bind(this);

        indexClick = 0;

        //4.FindviewByid kan recyclerview
        rvDataPasien = findViewById(R.id.rvDataPasien);

        //20 panggil initData
        initData();
        //22 Panggil initToRecycler

    }

    //19 tambahkan initData
    public void initData() {
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

    //21 tambahkan initToRecyler dan isi 3 baris
    public void initToRecycler() {
        adapter = new AdapterPerawat(this, mList);
        rvDataPasien.setHasFixedSize(true);
        rvDataPasien.setLayoutManager(new LinearLayoutManager(this));
        rvDataPasien.setAdapter(adapter);

        //24Panggil setDragRv
        setDragRecyclerView();

    }

    //23
    public void setDragRecyclerView() {
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvDataPasien.addItemDecoration(divider);

        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(
                        ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder drag,
                                  @NonNull RecyclerView.ViewHolder drop) {
                int dragged = drag.getAdapterPosition();
                int dropped = drop.getAdapterPosition();
                Collections.swap(mList, dragged, dropped);
                adapter.notifyItemMoved(dragged, dropped);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

                int position  = viewHolder.getAdapterPosition();
                mList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        helper.attachToRecyclerView(rvDataPasien);
    }

    @OnClick({R.id.fab1, R.id.fab2, R.id.fab3, R.id.fab4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab1:
                Toast.makeText(this, "fab1 ditekan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab2:
                Toast.makeText(this, "fab2 ditekan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab3:
                Toast.makeText(this, "fab3 ditekan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab4:
                Toast.makeText(this, "fab4 ditekan", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onItemClick(int position) {
        
    }
}
