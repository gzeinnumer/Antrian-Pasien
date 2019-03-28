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
    private ArrayList<ResultAntrianItem> list;

    //to do 7 create construktor

    public AdapterPerawat(Context context, ArrayList<ResultAntrianItem> list) {
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
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        //18 - 3 baris-
        String temp1 = list.get(i).getPasienId();
        String temp2 = list.get(i).getDokterId();
        //myHolder.antrianNo.setText(String.valueOf(list.get(i).getPasienAntrian()));
        myHolder.antrianNo.setText(String.valueOf(i+1));
        myHolder.antrianNama.setText(String.valueOf(list.get(i).getPasienNama()));
        myHolder.antrianAlamat.setText(String.valueOf(list.get(i).getPasienAlamat()));
    }

    @Override
    public int getItemCount() {
       //19
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.antrianNo)
        TextView antrianNo;
        @BindView(R.id.antrianNama)
        TextView antrianNama;
        @BindView(R.id.antrianAlamat)
        TextView antrianAlamat;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            //16.
            ButterKnife.bind(this,itemView);
        }
    }
    //17 hapus sisa nya
   // static class ViewHolder {
        //15 copy yang di komentar ke myholder
        //@BindView(R.id.antrianNo)
        //TextView antrianNo;
        //@BindView(R.id.antrianNama)
        //TextView antrianNama;
        //@BindView(R.id.antrianAlamat)
        //TextView antrianAlamat;

   //     ViewHolder(View view) {
    //       ButterKnife.bind(this, view);
    //    }
   // }
}
