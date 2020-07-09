package com.example.hoangmp3.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.hoangmp3.Adapter.AllAlbumAdapter;
import com.example.hoangmp3.Model.Album;
import com.example.hoangmp3.R;
import com.example.hoangmp3.Service.ApiService;
import com.example.hoangmp3.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcaAlbumActivity extends AppCompatActivity {

    RecyclerView recyclerViewAllalbum;
    Toolbar toolbarAllalbum;
    AllAlbumAdapter allAlbumAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatca_album);
        //khoi tao va anh xa view 
        init();
        Getdata();
    }

    private void Getdata() {
        DataService dataService = ApiService.getService();
        Call<List<Album>> callback = dataService.GetAllAlbum();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> mangalbum= (ArrayList<Album>) response.body();
                allAlbumAdapter = new AllAlbumAdapter( DanhsachtatcaAlbumActivity.this,mangalbum);
                recyclerViewAllalbum.setLayoutManager(new GridLayoutManager(DanhsachtatcaAlbumActivity.this,2));
                recyclerViewAllalbum.setAdapter(allAlbumAdapter);

            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }

    private void init() {
        recyclerViewAllalbum = findViewById(R.id.recyclerviewAllalbum);
        toolbarAllalbum = findViewById(R.id.toolbarallalbum);
        setSupportActionBar(toolbarAllalbum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("All Albums");
        toolbarAllalbum.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}