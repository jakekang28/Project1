package com.example.project1;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class VocaAdapter extends RecyclerView.Adapter<VocaAdapter.ViewHolder>{
    List<Dataset> items = new ArrayList<Dataset>();
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text1;
        ImageView picture;
        public ViewHolder(View itemView) {
            super(itemView);
            text1 = (TextView)itemView.findViewById(R.id.text1);
            picture = (ImageView) itemView.findViewById(R.id.image);
        }
        public void setData(Dataset data){
            text1.setText(data.text);
            picture.setImageDrawable(data.image);
        }
    }
    public void add(Dataset item){
        items.add(item);
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(items.get(position));
    }
    @Override
    public int getItemCount(){
        return items.size();
    }
    RecyclerView.OnItemTouchListener onItemTouchListener = new RecyclerView.OnItemTouchListener() {
        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
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
