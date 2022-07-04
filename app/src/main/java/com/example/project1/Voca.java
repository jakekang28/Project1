package com.example.project1;

public class Voca {
    private String word;
    private String pronunciation;
    private String type1;
    private String meaning1;
    private String type2;
    private String meaning2;
    private String example;
    private String example_korean;

    public void setWord(String word){
        this.word = word;
    }
    public void setPronunciation(String pronunciation){
        this.pronunciation = pronunciation;
    }
    public void setType1(String type1){
        this.type1 = type1;
    }
    public void setMeaning1(String meaning1){
        this.meaning1 = meaning1;
    }
    public void setType2(String type2){
        this.meaning2 = meaning2;
    }
    public void setMeaning2(String meaning2){
        this.meaning2 = meaning2;
    }
    public void setExampl(String example){
        this.example = example;
    }
    public void setExample_korean(String example_korean){
        this.example_korean = example_korean;
    }
    public String getWord(){
        return word;
    }
    public String getType1(){
        return type1;
    }
    public String getPronunciation(){
        return pronunciation;
    }
    public String getMeaning1(){
        return meaning1;
    }
    public String getMeaning2(){
        return meaning2;
    }
    public String getType2(){
        return type2;
    }
    public String getExampl(){
        return example;
    }
    public String getExample_korean(){
        return example_korean;
    }
}