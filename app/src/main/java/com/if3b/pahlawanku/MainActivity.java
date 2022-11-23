package com.if3b.pahlawanku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPahlawan;
    private ArrayList<ModelPahlawan> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPahlawan = findViewById(R.id.rv_pahlawan);
        rvPahlawan.setHasFixedSize(true);

        data.addAll(DataPahlawan.ambilDataPahlawan());
        tampilDataCard();
    }

    private void tampilDataCard() {
        rvPahlawan.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard varAdapterCard = new AdapterCard(data, MainActivity.this);
        rvPahlawan.setAdapter(varAdapterCard);
    }

    private void tampilDataGrid() {
        rvPahlawan.setLayoutManager(new GridLayoutManager(this, 2));
        AdapterCard varAdapterGrid = new AdapterCard(data, MainActivity.this);
        rvPahlawan.setAdapter(varAdapterGrid);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mode, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_mode_card:
                tampilDataCard();
                break;
            case R.id.menu_mode_grid:
                tampilDataGrid();
                break;
        }
            return super.onOptionsItemSelected(item);
        }
    }