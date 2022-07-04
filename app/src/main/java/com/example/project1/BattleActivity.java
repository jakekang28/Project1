package com.example.project1;

import java.sql.Array;
import java.util.ArrayList;

public class BattleActivity {
    //grass type
    Skill VineWhip = new Skill("grass",0.9,15,45);
    Skill Solarbeam = new Skill("grass",0.6,5,80);
    Skill SeedBomb = new Skill("grass",0.8,20,55);
    // normal type
    Skill Tackle = new Skill("normal",1,30,20);
    Skill DoubleEdge = new Skill("normal",0.6,10, 90);
    Skill Sing = new Skill("normal",0.3,5,0);
    Skill TakeDown = new Skill("normal",0.8,15,60);
    Skill Scratch = new Skill("normal",1,20,25);
    // water type
    Skill BubbleBeam = new Skill("water",0.7,20, 65);
    Skill HydroPump =  new Skill("water",0.5,10,75);
    Skill WaterPool = new Skill("water", 0.8,15,60);
    Skill AquaBreak = new Skill("water", 0.7,20, 65);
    // dragon type
    Skill Twister = new Skill("dragon",0.8,25,40);
    // fire type

}

