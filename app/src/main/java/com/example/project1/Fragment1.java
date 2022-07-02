package com.example.project1;



import android.content.Intent;
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

    private final ArrayList<Item> phonelist = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private String getJsonString()
    {
        String json = "";

        try {
            InputStream is = getActivity().getAssets().open("Phonenum.json");
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return json;
    }
    private void jsonParsing(String json)
    {
        try{
            JSONObject jsonObject = new JSONObject(json);

            JSONArray phoneArray = jsonObject.getJSONArray("Phone number");

            for(int i=0; i<phoneArray.length(); i++)
            {
                JSONObject phoneObject = phoneArray.getJSONObject(i);

                Item phone = new Item();

                phone.setNumber(phoneObject.getString("number"));
                phone.setName(phoneObject.getString("name"));

                phonelist.add(phone);
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }
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
//                Item item = mAdapter.getItem(position);
//                Toast.makeText(getActivity().getApplicationContext(), item.getName() +": 전화를 거시겠습니까?",
//                        Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getActivity(),CallActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        return rootView;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        phonelist.clear();
        jsonParsing(getJsonString());
    }

}