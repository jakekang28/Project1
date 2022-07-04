package com.example.project1;

import android.graphics.drawable.Drawable;

public class Skill {
    String type;
    double prob;
    int count;
    int power;
    public String getType(Skill skill){
        return skill.type;
    }
    public double getProb(Skill skill){
        return skill.prob;
    }
    public int getCount(Skill skill){
        return skill.count;
    }
    public int getPower(Skill skill){
        return skill.power;
    }
    public void setType(String type){
        this.type=type;
    }
    public void setProb(double prob){
        this.prob=prob;
    }
    public void setCount(int count){
        this.count=count;
    }
    public void setPower(int power){
        this.power=power;
    }
}



