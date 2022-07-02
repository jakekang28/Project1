package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import java.lang.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BigImage extends AppCompatActivity {

    public BigImage(){}

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bigimageview);
        ImageView imgview = (ImageView)findViewById(R.id.bigimage);

        Intent intent = getIntent();
        int pos = intent.getIntExtra("position", 0);

        switch(pos+1){
            case 1:
                imgview.setImageResource(R.drawable.image1);
                break;
            case 2:
                imgview.setImageResource(R.drawable.image2);
                break;
            case 3:
                imgview.setImageResource(R.drawable.image3);
                break;
            case 4:
                imgview.setImageResource(R.drawable.image4);
                break;
            case 5:
                imgview.setImageResource(R.drawable.image5);
                break;
            case 6:
                imgview.setImageResource(R.drawable.image6);
                break;
            case 7:
                imgview.setImageResource(R.drawable.image7);
                break;
            default:
                imgview.setImageResource(R.drawable.error);
                break;
        }

        Button exitbtn = (Button)findViewById(R.id.button3);
        exitbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }
}