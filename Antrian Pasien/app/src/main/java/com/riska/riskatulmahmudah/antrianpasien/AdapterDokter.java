package com.riska.riskatulmahmudah.antrianpasien;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterDokter extends RecyclerView.Adapter<AdapterDokter.MyHolder> {
    private Context context;
    private ArrayList<ResultDokterItem> list;

    public AdapterDokter(Context context, ArrayList<ResultDokterItem> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dokter, viewGroup, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {
        myHolder.dokterID.setText(String.valueOf(list.get(i).getDokterId()));
        myHolder.dokterNama.setText(String.valueOf(list.get(i).getDokterNama()));
        myHolder.dokterSpesialis.setText(String.valueOf(list.get(i).getDokterSpesialis()));
        myHolder.dokterAlamat.setText(String.valueOf(list.get(i).getDokterAlamat()));

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(),PerawatActivity.class);
                intent.putExtra("dokter_id", list.get(i).getDokterId());
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.dokterID)
        TextView dokterID;
        @BindView(R.id.dokterNama)
        TextView dokterNama;
        @BindView(R.id.dokterSpesialis)
        TextView dokterSpesialis;
        @BindView(R.id.dokterAlamat)
        TextView dokterAlamat;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }

    //static class ViewHolder {
      //  @BindView(R.id.dokterID)
        //TextView dokterID;
        //@BindView(R.id.dokterNama)
        //TextView dokterNama;
        //@BindView(R.id.dokterSpesialis)
        //TextView dokterSpesialis;
        //@BindView(R.id.dokterAlamat)
        //TextView dokterAlamat;

 ///       ViewHolder(View view) {
    //        ButterKnife.bind(this, view);
      //  }
    //}
}
