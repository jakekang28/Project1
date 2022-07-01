package com.example.project1;

import android.view.View;

public interface OnItemClickListener{
    void onItemClick(MyAdapter.ViewHolder holder, View v, int pos);
}