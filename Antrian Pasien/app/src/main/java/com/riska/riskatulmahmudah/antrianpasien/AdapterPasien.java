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

public class AdapterPasien extends RecyclerView.Adapter<AdapterPasien.MyHolder> {

    private Context context;
    private ArrayList<ResultAntrianItem> list;

    public AdapterPasien(Context context, ArrayList<ResultAntrianItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.itempasien, viewGroup, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.antrianNo.setText(String.valueOf(list.get(i).getPasienAntrian()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.antrianNo)
        TextView antrianNo;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    //static class ViewHolder {
      //  @BindView(R.id.antrianNo)
        //TextView antrianNo;

        //ViewHolder(View view) {
          //  ButterKnife.bind(this, view);
        //}
    //}
}
