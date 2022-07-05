package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class pokemonResult extends AppCompatActivity {
    ImageView winner;
    TextView result;
    Button goback;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemonresult);

        winner=(ImageView) findViewById(R.id.winner);
        Intent intent = getIntent();
        int id = intent.getIntExtra("winner",0);
        winner.setImageResource(id);
        result = (TextView) findViewById(R.id.resulttext);
        goback = (Button)findViewById(R.id.backbutton);

        //intent 이긴 포켓몬 받아서 결과에 띄움(winner, result)
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                //이러면 아마도 첫화면으로 돌아갈듯
            }
        });
    }
}