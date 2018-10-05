package com.example.ninefourone.nutritionmaster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninefourone.nutritionmaster.R;

import java.util.ArrayList;

/**
 * Created by ScorpioMiku on 2018/10/5.
 */

public class PickerAdapter extends RecyclerView.Adapter<PickerHolder> {
    private ArrayList<String> list;
    private Context context;

    public PickerAdapter(ArrayList<String> list, Context context) {
        super();
        this.list = list;
        this.context = context;
    }

    @Override
    public PickerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.picker_item, parent, false);
        return new PickerHolder(view);
    }

    @Override
    public void onBindViewHolder(PickerHolder holder, int position) {
        holder.bindView(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
