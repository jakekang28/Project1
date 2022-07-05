package com.example.project1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class BattleActivity extends Activity {
    public String gender(){
        double i= Math.random();
        if(i<=0.5) return "(남) :";
        else return "(여) :";
    }
    //grass type
    Skill VineWhip = new Skill("VineWhip","grass",0.9,15,45);
    Skill Solarbeam = new Skill("Solarbeam","grass",0.6,5,80);
    Skill SeedBomb = new Skill("SeedBomb","grass",0.8,20,55);
    // normal type
    Skill Tackle = new Skill("Tackle","normal",1,30,20);
    Skill DoubleEdge = new Skill("DoubleEdge","normal",0.6,10, 90);
    Skill Sing = new Skill("Sing","normal",0.3,5,0);
    Skill TakeDown = new Skill("TakeDown","normal",0.8,15,60);
    Skill Scratch = new Skill("Scratch","normal",1,20,25);
    Skill HornDrill = new Skill("HornDrill","normal", 0.8, 20, 55);
    Skill Imitate = new Skill("Imitate","normal", 1,50, 0);
    // water type
    Skill Watergun = new Skill("Watergun","water", 0.9,30,40);
    Skill BubbleBeam = new Skill("BubbleBeam","water",0.7,20, 65);
    Skill HydroPump =  new Skill("HydroPump","water",0.5,10,75);
    Skill WaterPool = new Skill("WaterPool","water", 0.8,15,60);
    Skill AquaBreak = new Skill("AquaBreak","water", 0.7,20, 65);
    // dragon type
    Skill Twister = new Skill("Twister","dragon",0.8,25,40);
    // fire type
    Skill FireSpin = new Skill("FireSpin","fire",0.8,25,35);
    Skill FireFang = new Skill("FireFang","fire",0.7,15,70);
    Skill FlareDrive = new Skill("FlareDrive","fire", 0.5, 10, 90);
    // fly type
    Skill WingSlash = new Skill("WingSlash","fly", 0.8, 15, 60);
    // psychic type
    Skill Psychic = new Skill("Psychic","psychic",0.8,15,60 );
    Skill PsychicBeam = new Skill("PsychicBeam","psychic",0.9,20, 45);
    Skill PsychoCut = new Skill("PsychoCut","psychic",0.7,15, 80);
    Skill MirrorShot = new Skill("MirrorShot","psychic", 0.8, 20, 50);
    // ground type
    Skill Dig = new Skill("Dig","ground",0.9,15, 60);
    Skill Earthquake =new Skill("Earthquake","ground", 0.7,20,80);
    Skill Dust = new Skill("Dust","ground",0.8,20, 55);
    // electric type
    Skill ElectricShock = new Skill("ElectricShock","electric", 0.8,20, 60);
    Skill VoltTackle = new Skill("VoltTackle","electric", 0.6,5, 100);
    Skill Thunder = new Skill("Thunder","electric",0.7,15, 80);

    Pokemon Bulbasaur = new Pokemon("Bulbasaur",R.drawable.back1,40, gender(),"grass","poison",SeedBomb,Solarbeam,VineWhip,Tackle);
    Pokemon Squirtle = new Pokemon("Squirtle",R.drawable.back2,40, gender(),"water","none",BubbleBeam,Watergun,Scratch,WaterPool);
    Pokemon Charmander = new Pokemon("Charmander",R.drawable.back3,40, gender(),"fire","none",FireFang,FireSpin,Scratch,FlareDrive);
    Pokemon Caterpie = new Pokemon("Caterpie",R.drawable.back4,35, gender(),"bug","poison",Dig,Tackle,Scratch,SeedBomb);
    Pokemon Pikachu = new Pokemon("Pikachu",R.drawable.back5,40, gender(),"electric","normal",VoltTackle,Thunder,Scratch,ElectricShock);
    Pokemon Jigglypuff = new Pokemon("Jigglypuff",R.drawable.back6,60, gender(),"normal","none",Sing,Tackle,TakeDown,DoubleEdge);
    Pokemon Diglett = new Pokemon("Diglett",R.drawable.back7,35, gender(),"ground","none",Dig,Earthquake,Tackle,TakeDown);
    Pokemon Meowth = new Pokemon("Meowth",R.drawable.back8,40, gender(),"normal","none",Scratch,Sing,FireFang,TakeDown);
    Pokemon Psyduck = new Pokemon("Psyduck",R.drawable.back9,40, gender(),"water","psychic",BubbleBeam,Watergun,Scratch,Psychic);
    Pokemon Slowbro = new Pokemon("Slowbro",R.drawable.back10,55, gender(),"water","psychic",HydroPump,Watergun,PsychoCut,Psychic);
    Pokemon Horsea = new Pokemon("Horsea",R.drawable.back11,35, gender(),"water","dragon",BubbleBeam,AquaBreak,Twister,HydroPump);
    Pokemon Goldeen = new Pokemon("Goldeen",R.drawable.back12,45, gender(),"water","none",BubbleBeam,Watergun,HornDrill,TakeDown);
    Pokemon Ditto = new Pokemon("Ditto",R.drawable.back13,35, gender(),"normal","none",Imitate,null,null,null);
    Pokemon Eevee = new Pokemon("Eevee",R.drawable.back14,45, gender(),"normal","none",TakeDown,Tackle,DoubleEdge,Sing);
    Pokemon Snorlax = new Pokemon("Snorlax",R.drawable.back15,70, gender(),"normal","none",TakeDown,DoubleEdge,FireFang,Earthquake);
    Pokemon Mew = new Pokemon("Mew",R.drawable.back16,45, gender(),"psychic","none",Psychic,PsychicBeam,PsychoCut,Twister);
    Pokemon Woubuffet = new Pokemon("Woubuffet",R.drawable.back17,50, gender(),"psychic","none",Psychic,PsychicBeam,Sing,MirrorShot);
    Pokemon Torchic= new Pokemon("Torchic",R.drawable.back18,40, gender(),"fire","fly",FireSpin,WingSlash,FlareDrive,Scratch);
    Pokemon Piplup = new Pokemon("Piplup",R.drawable.back19,40, gender(),"water","normal",BubbleBeam,Watergun,Scratch,HydroPump);
    Pokemon Pachirisu = new Pokemon("Pachirisu",R.drawable.back20,45, gender(),"electric","normal",Thunder,ElectricShock,Sing,TakeDown);
    Skill[] skillset = {VineWhip,Solarbeam,SeedBomb,Tackle,DoubleEdge,Sing,TakeDown,Scratch, HornDrill,Imitate,Watergun, BubbleBeam,HydroPump,WaterPool,AquaBreak,Twister,FireSpin,FireFang,FlareDrive,WingSlash,Psychic,PsychicBeam,PsychoCut,MirrorShot,Dig,Earthquake,Dust,ElectricShock,VoltTackle,Thunder};
    Pokemon[] pokemonset = {Bulbasaur,Squirtle,Charmander,Caterpie,Pikachu,Jigglypuff,Diglett,Meowth,Psyduck,Slowbro,Horsea,Goldeen,Ditto,Eevee,Snorlax,Mew,Woubuffet,Torchic,Piplup,Pachirisu};
    private Button fight;
    private Button surrender;
    @Override
    public void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.battlefield);
        Intent intent = this.getIntent();
        ImageView yourimgview = (ImageView) findViewById(R.id.front);
        ImageView myimgview = (ImageView) findViewById(R.id.back);
        TextView myname = (TextView) findViewById(R.id.nameback);
        TextView yourname = (TextView) findViewById(R.id.namefront);
        TextView mygender = (TextView) findViewById(R.id.genderback);
        TextView yourgender = (TextView) findViewById(R.id.genderfront);
        Button skillview1 =  (Button) findViewById(R.id.skillbutton1);
        Button skillview2 =  (Button)  findViewById(R.id.skillbutton2);
        Button skillview3 =  (Button)  findViewById(R.id.skillbutton3);
        Button skillview4 =  (Button)  findViewById(R.id.skillbutton4);
        int pos1 = intent.getIntExtra("position1",0);
        int pos2 = intent.getIntExtra("position2",0);
        Pokemon mypoke = pokemonset[pos1-1];
        Pokemon yourpoke = pokemonset[pos2-1];
        myname.setText(mypoke.getName(mypoke));
        yourname.setText(yourpoke.getName(yourpoke));
        mygender.setText(mypoke.getGender(mypoke));
        yourgender.setText(yourpoke.getGender(yourpoke));
        int cnt1 = mypoke.skill1.getCount(mypoke.skill1);
        int cnt2 = mypoke.skill2.getCount(mypoke.skill2);
        int cnt3 = mypoke.skill3.getCount(mypoke.skill3);
        int cnt4 = mypoke.skill4.getCount(mypoke.skill4);
        yourimgview.setImageResource(yourpoke.picture);
        myimgview.setImageResource(mypoke.picture);
        skillview1.setText((String) mypoke.skill1.getType(mypoke.skill1)+"\n"+(String) mypoke.skill1.getName(mypoke.skill1)+"\n"+ Integer.toString(mypoke.skill1.getCount(mypoke.skill1))+"/"+Integer.toString(cnt1));
        skillview2.setText((String) mypoke.skill2.getType(mypoke.skill2)+"\n"+(String) mypoke.skill2.getName(mypoke.skill2)+"\n"+ Integer.toString(mypoke.skill2.getCount(mypoke.skill2))+"/"+Integer.toString(cnt2));
        skillview3.setText((String) mypoke.skill3.getType(mypoke.skill3)+"\n"+(String) mypoke.skill3.getName(mypoke.skill3)+"\n"+ Integer.toString(mypoke.skill3.getCount(mypoke.skill3))+"/"+Integer.toString(cnt3));
        skillview4.setText((String) mypoke.skill4.getType(mypoke.skill4)+"\n"+(String) mypoke.skill4.getName(mypoke.skill4)+"\n"+ Integer.toString(mypoke.skill4.getCount(mypoke.skill4))+"/"+Integer.toString(cnt4));
        fight = (Button) findViewById(R.id.fightbutton);
        surrender = (Button) findViewById(R.id.surrenderbutton);
        fight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                fight.setVisibility(fight.GONE);
                surrender.setVisibility(surrender.GONE);
                skillview1.setVisibility(skillview1.VISIBLE);
                skillview2.setVisibility(skillview2.VISIBLE);
                skillview3.setVisibility(skillview3.VISIBLE);
                skillview4.setVisibility(skillview4.VISIBLE);
                skillview1.setOnClickListener(new View.OnClickListener(){
                    Handler handler = new Handler();
                  Runnable run = new Runnable() {
                      @Override
                      public void run() {
                          public void onClick(View view){

                          }
                      }
                  };
                  handler.postDelayed(run(),1000);
                });
            }
        });
        surrender.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switch(view.getId()){
                    case R.id.surrenderbutton:
                        new AlertDialog.Builder(BattleActivity.this).setTitle("Alert").setMessage("You are about to lose!\n\n Are you sure you want to continue?").setNegativeButton("Return to Battle", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(BattleActivity.this,"Return to Battle",Toast.LENGTH_SHORT).show();
                            }
                        }).setPositiveButton("Surrender", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        }).create().show();
            }
        };
    });

    }
}

