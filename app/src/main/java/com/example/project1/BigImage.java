package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BigImage extends AppCompatActivity {
    private ImageView imgview;

    public BigImage(int pos){
        switch(pos){
            case 1:
                imgview.setImageResource(R.drawable.image1);
            case 2:
                imgview.setImageResource(R.drawable.image2);
            case 3:
                imgview.setImageResource(R.drawable.image3);
            case 4:
                imgview.setImageResource(R.drawable.image4);
            case 5:
                imgview.setImageResource(R.drawable.image5);
            case 6:
                imgview.setImageResource(R.drawable.image6);
            case 7:
                imgview.setImageResource(R.drawable.image7);
            default:
                imgview.setImageResource(R.drawable.error);
        }
    }
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bigimageview);

        Button exitbtn = (Button)findViewById(R.id.button3);
        exitbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }
}