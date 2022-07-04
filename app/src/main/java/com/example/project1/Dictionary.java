package com.example.project1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Dictionary extends AppCompatActivity {
    ArrayList<Voca> vocaArrayList = new ArrayList<>();
    ImageView wordimage;
    TextView word;
    TextView pronunciation;
    TextView type1;
    TextView meaning1;
    TextView type2;
    TextView meaning2;
    TextView example;
    TextView example_korean;

    private String getJsonString()
    {
        String json = "";
        try {
            InputStream is = this.getAssets().open("Vocabulary.json");
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return json;
    }
    private void jsonParsing(String json)
    {
        try{
            JSONObject jsonObject = new JSONObject(json);

            JSONArray vocaArray = jsonObject.getJSONArray("Vocabulary");

            for(int i=0; i<vocaArray.length(); i++)
            {
                JSONObject vocaObject = vocaArray.getJSONObject(i);

                Voca voca = new Voca();
                voca.setWord(vocaObject.getString("word"));
                voca.setPronunciation(vocaObject.getString("pronunciation"));
                voca.setType1(vocaObject.getString("type1"));
                voca.setMeaning1(vocaObject.getString("meaning1"));
                voca.setType2(vocaObject.getString("type2"));
                voca.setMeaning2(vocaObject.getString("meaning2"));
                voca.setExampl(vocaObject.getString("example"));
                voca.setExample_korean(vocaObject.getString("example_korean"));
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment3contents);

        word = (TextView)findViewById(R.id.word);
        pronunciation = (TextView)findViewById(R.id.pronounciation);
        type1 = (TextView)findViewById(R.id.type1);
        meaning1 = (TextView)findViewById(R.id.meaning1);
        type2 = (TextView)findViewById(R.id.type2);
        meaning2 = (TextView)findViewById(R.id.meaning2);
        example = (TextView)findViewById(R.id.example);
        example_korean=(TextView)findViewById(R.id.example_korean);

        jsonParsing(getJsonString());
    }

    private void setData(int pos){
        Voca curvoca = vocaArrayList.get(pos);
        word.setText(curvoca.getWord());
        pronunciation.setText(curvoca.getPronunciation());
        type1.setText(curvoca.getType1());
        meaning1.setText(curvoca.getMeaning1());
        type2.setText(curvoca.getType2());
        meaning2.setText(curvoca.getMeaning2());
        example.setText(curvoca.getExampl());
        example_korean.setText(curvoca.getExample_korean());

    }
}