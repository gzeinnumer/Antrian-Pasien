package com.riska.riskatulmahmudah.antrianpasien;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

//to do 5 tambahkan extend rv dan pada setiap error pecahkan bohlam dan pilih yang pertama sampai semua error hilang
public class AdapterPerawat extends RecyclerView.Adapter<AdapterPerawat.MyHolder> {

    //to do 6 deklarasikan context dan array, pada array pecahkan bohlam dan create class dataandtrian
    private Context context;
    private ArrayList<ResponseAntrianAPI> list;

    private MyOnItemClick click;

    //to do 7 create construktor

    public AdapterPerawat(Context context, ArrayList<ResponseAntrianAPI> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //to do 8 pecahkan bohlam dan buat layout item --3 baris--
        //14. klik kanan di item generate butterknife , centang viewholder
        View view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {
        myHolder.antrianID.setText(list.get(i).getAntrianID());
        myHolder.dokterID.setText(list.get(i).getDokterID());
        myHolder.dokterName.setText(list.get(i).getDokterName());
        myHolder.tgl.setText(list.get(i).getTgl());
        myHolder.jam.setText(list.get(i).getJam());
        myHolder.rsid.setText(list.get(i).getRSID());
        myHolder.noAntrian.setText(String.valueOf(list.get(i).getNoAntrian()));
        myHolder.noUrut.setText(String.valueOf(list.get(i).getNoUrut()));
        myHolder.namaPasient.setText(list.get(i).getNamaPasien());
    }

    @Override
    public int getItemCount() {
        //19
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.antrianID)
        TextView antrianID;
        @BindView(R.id.dokterID)
        TextView dokterID;
        @BindView(R.id.dokterName)
        TextView dokterName;
        @BindView(R.id.tgl)
        TextView tgl;
        @BindView(R.id.jam)
        TextView jam;
        @BindView(R.id.rsid)
        TextView rsid;
        @BindView(R.id.noAntrian)
        TextView noAntrian;
        @BindView(R.id.noUrut)
        TextView noUrut;
        @BindView(R.id.namaPasient)
        TextView namaPasient;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            //16.
            ButterKnife.bind(this, itemView);
        }
    }

    public interface MyOnItemClick {
        void onItemClick(int position);
    }


    public void setOnClickListener2(MyOnItemClick onClick) {
        click = onClick;
    }

}
