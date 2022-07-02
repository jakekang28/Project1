package com.example.project1;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements OnItemClickListener{
    private ArrayList<Item> items = new ArrayList<Item>();
    private static OnItemClickListener listener;

    public MyAdapter(ArrayList<Item> myData){
        this.items = myData;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(items.get(position));
    }

    public void setFriendList(ArrayList<Item> list){
        this.items = list;
        notifyDataSetChanged();
    }

    public void add(Item item){
        items.add(item);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setOnItemClicklistener(OnItemClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder,view,position);
        }
    }
    @Override
    public int getItemViewType(int position){
        return position;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView message;

        public ViewHolder(@NonNull View itemView,final OnItemClickListener listener) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            message = (TextView) itemView.findViewById(R.id.message);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        if(listener != null){
                            listener.onItemClick(ViewHolder.this, v,pos);
                        }
                    }
                }
            });
        }
        void onBind(Item item) {
            name.setText(item.getName());
            message.setText(item.getNumber());
        }
    }
    public void setItems(ArrayList<Item> items){
        this.items = items;
    }
    public Item getItem(int position){
        return items.get(position);
    }
    public void setItem(int position, Item item){
        items.set(position,item);
    }
}