package com.example.project1;



import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;
import android.content.res.AssetManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;
import java.io.InputStream;
import java.io.IOException;
public class Fragment1 extends Fragment {

    private ArrayList<Item> phonelist = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragmentdisplay1, container, false);
        //recycler view
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        mAdapter = new MyAdapter(phonelist);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClicklistener(new OnItemClickListener() {
            @Override
            public void onItemClick(MyAdapter.ViewHolder holder, View view, int position) {
                Item item = mAdapter.getItem(position);
                Toast.makeText(getActivity().getApplicationContext(), item.getName() +"에게 전화를 거시겠습니까?",
                        Toast.LENGTH_LONG).show();
            }
        });
        prepareData();
        return rootView;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    private void prepareData(){
        phonelist.add(new Item(1,"넙죽1", "010-1234-5678"));
        phonelist.add(new Item(2,"넙죽2", "010-1234-5678"));
        phonelist.add(new Item(3,"넙죽3", "010-1234-5678"));
        phonelist.add(new Item(4, "넙죽4", "010-1234-5678"));
    }
}