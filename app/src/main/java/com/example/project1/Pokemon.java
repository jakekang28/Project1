package com.example.project1;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;

public class Pokemon {
    String name;
    int picture;
    int hp;
    String gender;
    String type1;
    String type2;
    Skill skill1;
    Skill skill2;
    Skill skill3;
    Skill skill4;

    public Pokemon(String name, int picture, int hp, String gender, String type1,String type2, Skill skill1, Skill skill2, Skill skill3, Skill skill4) {
        this.name = name;
        this.picture = picture;
        this.hp = hp;
        this.gender = gender;
        this.type1 = type1;
        this.type2 = type2;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.skill4 = skill4;
    }

    public String getName(Pokemon pokemon) {
        return pokemon.name;
    }

    public int getPicture(Pokemon pokemon) {
        return pokemon.picture;
    }

    public int getHp(Pokemon pokemon) {
        return pokemon.hp;
    }

    public String getGender(Pokemon pokemon) {
        return pokemon.gender;
    }

    public String getType1(Pokemon pokemon) {
        return pokemon.type1;
    }
    public String getType2(Pokemon pokemon) {
        return pokemon.type2;
    }

    public Skill getSkill1(Pokemon pokemon) {
        return pokemon.skill1;
    }
    public Skill getSkill2(Pokemon pokemon) {
        return pokemon.skill2;
    }
    public Skill getSkill3(Pokemon pokemon) {
        return pokemon.skill3;
    }
    public Skill getSkill4(Pokemon pokemon) {
        return pokemon.skill4;
    }
    public void setName(Pokemon pokemon) {
        pokemon.name=name;
    }

    public void setPicture(Pokemon pokemon) {
        pokemon.picture=picture;
    }

    public void setHp(Pokemon pokemon) {
        pokemon.hp=hp;
    }

    public void setGender(Pokemon pokemon) {
        pokemon.gender=gender;
    }

    public void setType1(Pokemon pokemon) {
        pokemon.type1=type1;
    }
    public void setType2(Pokemon pokemon) {
        pokemon.type2=type2;
    }
    public void setSkill1(Pokemon pokemon) {
       pokemon.skill1=skill1;
    }
    public void setSkill2(Pokemon pokemon) {
        pokemon.skill2=skill2;
    }
    public void setSkill3(Pokemon pokemon) {
        pokemon.skill3=skill3;
    }
    public void setSkill4(Pokemon pokemon) {
        pokemon.skill4=skill4;
    }
}
