package com.example.project1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class pokemonPick extends Activity {
    private RecyclerView recyclerView;
    private ImageAdapter iAdapter;
    private Button btn;
    private int clickcnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemonpick);

        ArrayList<Drawable> imageList = new ArrayList<>();
        boolean[] clicked = new boolean[21];    //클릭 저장

        int[] picarray={0, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7,
                R.drawable.image8, R.drawable.image9, R.drawable.image10, R.drawable.image11, R.drawable.image12, R.drawable.image13, R.drawable.image14, R.drawable.image15
                ,R.drawable.image16, R.drawable.image17, R.drawable.image18, R.drawable.image19, R.drawable.image20};

        for(int i = 1; i <= 20; i++){
            Drawable drawable = ContextCompat.getDrawable(this, picarray[i]);
            imageList.add(drawable);
        }
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        recyclerView.setLayoutManager(layoutManager);
        iAdapter = new ImageAdapter(imageList);
        recyclerView.setAdapter(iAdapter);

        iAdapter.setOnItemClicklistener(new OnPersonItemClickListener(){
            @Override
            public void onItemClick(ImageAdapter.imgViewHolder holder, View view, int pos) {
                if(clicked[pos+1]){//click off
                    holder.itemView.setBackgroundColor(Color.WHITE);
                    clickcnt -= 1;
                }
                else{
                    if(clickcnt == 2){
                        return;
                    }
                    holder.itemView.setBackgroundColor(Color.RED);
                    clickcnt += 1;
                }
                clicked[pos + 1] = !clicked[pos+1];
            }
        });

        btn = (Button)findViewById(R.id.startbutton);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(clickcnt == 2){
                    boolean two = false;
                    int pos1 = 0;
                    int pos2= 0; //two characters' position
                    for(int i=1;i<=20;i++){
                        if(clicked[i] && !two){
                            pos1 = i;
                            two = true;
                        }
                        else if(clicked[i] && two){
                            pos2 = i;
                            break;
                        }
                    }
                    Intent intent = new Intent(getApplicationContext(),BattleActivity.class);
                    intent.putExtra("position1",pos1);
                    intent.putExtra("position2",pos2);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Select two Pokemons.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}