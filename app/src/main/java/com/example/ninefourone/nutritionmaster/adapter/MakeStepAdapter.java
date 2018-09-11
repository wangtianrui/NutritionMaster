package com.example.ninefourone.nutritionmaster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninefourone.nutritionmaster.R;

import java.util.ArrayList;

/**
 * Created by ScorpioMiku on 2018/9/9.
 */

public class MakeStepAdapter extends RecyclerView.Adapter<MakeStepHolder> {
    private ArrayList<String> mList;
    private Context mContext;

    public MakeStepAdapter(ArrayList mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public MakeStepHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.make_step_item, parent, false);
        return new MakeStepHolder(view);
    }

    @Override
    public void onBindViewHolder(MakeStepHolder holder, int position) {
        holder.bindView(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
