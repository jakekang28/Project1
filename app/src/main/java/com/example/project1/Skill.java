package com.example.project1;

import android.graphics.drawable.Drawable;

public class Skill {
    String name;
    String type;
    double prob;
    int count;
    int power;

    Skill(String name, String type,double prob, int count, int power){
        this.name = name;
        this.type = type;
        this.prob = prob;
        this.count = count;
        this.power = power;
    }
    public String getName(Skill skill){
        return skill.name;
    }
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
    public void setName(String name){
        this.name = name;
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



