package com.if3b.pahlawanku;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.ClassViewHolder>{
    private ArrayList<ModelPahlawan> dataPahlawan;
    private Context ctx;

    public AdapterCard(ArrayList<ModelPahlawan> dataPahlawan, Context ctx) {
        this.dataPahlawan = dataPahlawan;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.item_card, parent, false);
        return new ClassViewHolder(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
    ModelPahlawan pahlawan = dataPahlawan.get(position);
    holder.tvNama.setText(pahlawan.getNama());
    holder.tvTentang.setText(pahlawan.getTentang());
    Glide
            .with(ctx)
            .load(pahlawan.getFoto())
            .centerCrop()
            .into(holder.ivFoto);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String xNama, xTentang, xFoto;

            xNama = pahlawan.getNama();
            xTentang = pahlawan.getTentang();
            xFoto = pahlawan.getFoto();

        //    Log.d("CEKNRICEK", xNama+ " | " + xTentang + " | " + xFoto);

            Intent kirim = new Intent(ctx, DetailActivity.class);
             kirim.putExtra("xNama", xNama);
            kirim.putExtra("xTentang", xTentang);
            kirim.putExtra("xFoto", xFoto);
            ctx.startActivity(kirim);
        }
    });
    }


    @Override
    public int getItemCount() {
        return dataPahlawan.size();
    }

    public class ClassViewHolder extends RecyclerView.ViewHolder {
    ImageView ivFoto;
    TextView tvNama, tvTentang;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.iv_foto);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvTentang = itemView.findViewById(R.id.tv_tentang);
        }
    }
}
