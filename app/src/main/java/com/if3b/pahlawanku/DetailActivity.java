package com.if3b.pahlawanku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivFoto;
    private TextView tvNama, tvTentang;
    private  String yNama, yTentang, yFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivFoto = findViewById(R.id.iv_foto);
        tvNama = findViewById(R.id.tv_nama);
        tvTentang = findViewById(R.id.tv_tentang);

        Intent ambil = getIntent();
        yNama = ambil.getStringExtra("xNama");
        yTentang= ambil.getStringExtra("xTentang");
        yFoto = ambil.getStringExtra("xFoto");

        tvNama.setText(yNama);
        tvTentang.setText(yTentang);
        Glide
                .with(DetailActivity.this)
                .load(yFoto)
                .into(ivFoto);
    }
}