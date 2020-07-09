package com.example.hoangmp3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hoangmp3.Activity.DanhsachbaihatActivity;
import com.example.hoangmp3.Model.Album;
import com.example.hoangmp3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter  extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{

    Context context;
    ArrayList<Album> mangaalbum;

    public AlbumAdapter(Context context, ArrayList<Album> mangaalbum) {
        this.context = context;
        this.mangaalbum = mangaalbum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dong_album,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = mangaalbum.get(position);
        holder.txtcasialbum.setText(album.getTencasiAlbum());
        holder.txttenalbum.setText(album.getTenAlbum());
        Picasso.with(context).load(album.getHinhanhAlbum()).into(holder.imghinhalbum);

    }

    @Override
    public int getItemCount() {
        return mangaalbum.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        ImageView imghinhalbum;
        TextView txttenalbum, txtcasialbum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghinhalbum = itemView.findViewById(R.id.imageviewalbum);
            txttenalbum = itemView.findViewById(R.id.textviewtenalbum);
            txtcasialbum = itemView.findViewById(R.id.textviewtencasialbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("album",mangaalbum.get(getPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }

}
