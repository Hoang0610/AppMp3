package com.example.hoangmp3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.hoangmp3.Adapter.DanhsachtatcachudeAdapter;
import com.example.hoangmp3.Model.ChuDe;
import com.example.hoangmp3.R;
import com.example.hoangmp3.Service.ApiService;
import com.example.hoangmp3.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcachudeActivity extends AppCompatActivity {

    RecyclerView recyclerViewtatcachude;
    Toolbar toolbartatcachude;
    DanhsachtatcachudeAdapter danhsachtatcachudeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatcachude);

        init();
        Getdata();
    }

    private void Getdata() {
        DataService dataService = ApiService.getService();
        Call<List<ChuDe>> callback = dataService.GetAllChude();
        callback.enqueue(new Callback<List<ChuDe>>() {
            @Override
            public void onResponse(Call<List<ChuDe>> call, Response<List<ChuDe>> response) {
                ArrayList<ChuDe> mangchude = (ArrayList<ChuDe>) response.body();
                danhsachtatcachudeAdapter = new DanhsachtatcachudeAdapter(DanhsachtatcachudeActivity.this,mangchude);
                recyclerViewtatcachude.setLayoutManager(new GridLayoutManager(DanhsachtatcachudeActivity.this,1));
                recyclerViewtatcachude.setAdapter(danhsachtatcachudeAdapter);

            }

            @Override
            public void onFailure(Call<List<ChuDe>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewtatcachude = findViewById(R.id.recylerviewAllchude);
        toolbartatcachude= findViewById(R.id.toolbarallchude);
        setSupportActionBar(toolbartatcachude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("All Chủ Đề");
        toolbartatcachude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}