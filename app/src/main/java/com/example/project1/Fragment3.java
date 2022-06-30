package com.example.project1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment3 extends Fragment {
    RecyclerView recyclerView;
    private VocaAdapter mAdapter;
    String eWord[] = {"sunny", "cloudy", "rainy", "snowy", "windy", "giraffe", "elephant", "turtle", "rabbit", "zebra", "baseball", "football", "basketball", "volleyball", "badminton", "KOREA", "JAPAN", "CHINA", "USA", "THAILAND"};
    String kWord[] = {"햇빛이 창창한", "구름 낀", "비가 오는", "눈이 내리는", "바람이 센", "기린", "코끼리", "거북", "토끼", "얼룩말", "야구", "축구", "농구", "배구", "배드민턴", "한국", "일본", "중국", "미국", "태국"};
    public GestureDetector gestureDetector;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragmentdisplay3, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new VocaAdapter();
        recyclerView.setAdapter(mAdapter);

        makeData();

        gestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener(){
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
        recyclerView.addOnItemTouchListener(onItemTouchListener);
        return rootView;
    }
    public void makeData(){
        for(int i=0;i<20;i++)
        {
            Dataset data = new Dataset();
            data.image = ResourcesCompat.getDrawable(getResources(),R.drawable.pic0 + i,null);
            data.text = eWord[i];
            mAdapter.add(data);
        }
    }
    RecyclerView.OnItemTouchListener onItemTouchListener = new RecyclerView.OnItemTouchListener() {
        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            View childView = rv.findChildViewUnder(e.getX(),e.getY());
            if(childView != null && gestureDetector.onTouchEvent((e)))
            {
                int currentPos =  rv.getChildAdapterPosition(childView);
                Toast.makeText(getActivity(),kWord[currentPos],Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }

        @Override
        public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    };
}