package com.example.project1;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment2 extends Fragment {

    private ArrayList<Image> imageList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ImageAdapter iAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragmentdisplay2, container, false);

        int[] picarray={0, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7};
        for(int i = 1; i <= 7; i++){
            Drawable drawable = ContextCompat.getDrawable(getContext(), picarray[i]);
            imageList.add(new Image(drawable, Integer.toString(i)));
        }
        //RecyclerView, Adapter add
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        iAdapter = new ImageAdapter(imageList);
        recyclerView.setAdapter(iAdapter);

        //Layout manager add
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        iAdapter.setOnItemClicklistener(new OnPersonItemClickListener(){
            @Override
            public void onItemClick(ImageAdapter.imgViewHolder holder, View view, int pos) {
                Intent intent = new Intent(getActivity(), BigImage.class);
                intent.putExtra("position", pos);
                startActivity(intent);
            }
        });
        return rootView;
    }

}