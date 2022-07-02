package com.example.project1;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class Fragment2 extends Fragment {

    private RecyclerView recyclerView;
    private ImageAdapter iAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ArrayList<Drawable> imageList = new ArrayList<>();
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragmentdisplay2, container, false);

        int[] picarray={0, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7,
                R.drawable.image8, R.drawable.image9, R.drawable.image10, R.drawable.image11, R.drawable.image12, R.drawable.image13, R.drawable.image14, R.drawable.image15
            ,R.drawable.image16, R.drawable.image17, R.drawable.image18, R.drawable.image19, R.drawable.image20};

        for(int i = 1; i <= 20; i++){
            Drawable drawable = ContextCompat.getDrawable(getContext(), picarray[i]);
            imageList.add(drawable);
        }
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        recyclerView.setLayoutManager(layoutManager);
        iAdapter = new ImageAdapter(imageList);
        recyclerView.setAdapter(iAdapter);

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