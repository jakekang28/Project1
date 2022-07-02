package com.example.project1;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.imgViewHolder> implements OnPersonItemClickListener{

    private ArrayList<Drawable> images;
    OnPersonItemClickListener listener;

    public ImageAdapter(ArrayList<Drawable> imageList){
        images = imageList;
    }

    @NonNull
    @Override
    public imgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment2contents, parent, false);
        return new imgViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(imgViewHolder holder, int position){
        Drawable curimage = images.get(position);
        holder.imageView.setImageDrawable(curimage);
    }
    @Override
    public int getItemCount(){
        return images.size();
    }

    public void setOnItemClicklistener(OnPersonItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onItemClick(imgViewHolder holder, View view, int pos){
        if(listener != null){
            listener.onItemClick(holder, view, pos);
        }
    }

    public static class imgViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public Button btn;

        public imgViewHolder(View itemView, final OnPersonItemClickListener listener){
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image_example);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(imgViewHolder.this, v, pos);
                    }
                }
            });
        }
    }
}

interface OnPersonItemClickListener{
    public void onItemClick(ImageAdapter.imgViewHolder holder, View view, int pos);
}