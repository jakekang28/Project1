package com.example.project1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.imgViewHolder>{

    private ArrayList<Image> images = new ArrayList<>();
    private int[] picarray;

    public ImageAdapter(ArrayList<Image> imageList){
        images = imageList;
    }

    @NonNull
    @Override
    public imgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragmentdisplay2, parent, false);
        return new imgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(imgViewHolder holder, int position){
        Image curimage = images.get(position);
        holder.btn.setText(curimage.button);
        holder.imageView.setImageDrawable(curimage.image);
    }
    @Override
    public int getItemCount(){
        return images.size();
    }

    public static class imgViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public Button btn;
        private LinearLayout layout;
        public imgViewHolder(View itemView){
            super(itemView);

            layout = (LinearLayout)itemView.findViewById(R.id.imagecontents);
            imageView = itemView.findViewById(R.id.image_example);
            btn = itemView.findViewById(R.id.biggerimage);
        }
    }
}