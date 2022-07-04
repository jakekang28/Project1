package com.example.project1;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Pokemonclip extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemonclip);
        ImageView imgview = (ImageView)findViewById(R.id.pokeimage);
        final VideoView video = (VideoView)findViewById(R.id.pokemonvideo);
        Resources res=getResources();
        int id_video = res.getIdentifier("test","raw",getPackageName());
        Uri uri;
        String uripath;
        Intent intent = this.getIntent();
        int pos = intent.getIntExtra("position", 0);
        switch(pos+1){
            case 1 :
                imgview.setImageResource(R.drawable.image1);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.bulbasaur;
                uri = Uri.parse(uripath);
                break;
            case 2:
                imgview.setImageResource(R.drawable.image2);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.squirtle;
                uri = Uri.parse(uripath);
                break;
            case 3:
                imgview.setImageResource(R.drawable.image3);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.chimchar;
                uri = Uri.parse(uripath);
                break;
            case 4:
                imgview.setImageResource(R.drawable.image4);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.caterpillar;
                uri = Uri.parse(uripath);
                break;
            case 5:
                imgview.setImageResource(R.drawable.image5);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.pikachu;
                uri = Uri.parse(uripath);
                break;
            case 6:
                imgview.setImageResource(R.drawable.image6);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.purin;
                uri = Uri.parse(uripath);
                break;
            case 7:
                imgview.setImageResource(R.drawable.image7);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.dig;
                uri = Uri.parse(uripath);
                break;
            case 8:
                imgview.setImageResource(R.drawable.image8);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.meowth;
                uri = Uri.parse(uripath);
                break;
            case 9:
                imgview.setImageResource(R.drawable.image9);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.gorapa;
                uri = Uri.parse(uripath);
                break;
            case 10:
                imgview.setImageResource(R.drawable.image10);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.yadoran;
                uri = Uri.parse(uripath);
                break;
            case 11:
                imgview.setImageResource(R.drawable.image11);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.sodra;
                uri = Uri.parse(uripath);
                break;
            case 12:
                imgview.setImageResource(R.drawable.image12);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.goldeen;
                uri = Uri.parse(uripath);
                break;
            case 13:
                imgview.setImageResource(R.drawable.image13);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.ditto;
                uri = Uri.parse(uripath);
                break;
            case 14:
                imgview.setImageResource(R.drawable.image14);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.eevee;
                uri = Uri.parse(uripath);
                break;
            case 15:
                imgview.setImageResource(R.drawable.image15);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.snorlax;
                uri = Uri.parse(uripath);
                break;
            case 16:
                imgview.setImageResource(R.drawable.image16);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.mew;
                uri = Uri.parse(uripath);
                break;
            case 17:
                imgview.setImageResource(R.drawable.image17);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.wobbuffet;
                uri = Uri.parse(uripath);
                break;
            case 18:
                imgview.setImageResource(R.drawable.image18);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.torchic;
                uri = Uri.parse(uripath);
                break;
            case 19:
                imgview.setImageResource(R.drawable.image19);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.piplup;
                uri = Uri.parse(uripath);
                break;
            case 20:
                imgview.setImageResource(R.drawable.image20);
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.pachirisu;
                uri = Uri.parse(uripath);
                break;
            default:
                uripath = "android.resource://"+getPackageName()+"/"+R.raw.bulbasaur;
                uri = Uri.parse(uripath);
                break;
        }
        video.setVideoURI(uri);
        video.start();
        MediaController mcontroller = new MediaController(this);
        video.setMediaController(mcontroller);
        video.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                if(video.isPlaying()){
                    video.pause();
                    return false;
                }else{
                    video.start();
                    return false;
                }
            }
        });
        Button prev_bt = (Button)findViewById(R.id.prevbutton);
        prev_bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }

}
