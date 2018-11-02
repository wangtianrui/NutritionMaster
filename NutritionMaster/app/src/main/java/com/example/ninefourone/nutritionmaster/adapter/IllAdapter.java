package com.example.ninefourone.nutritionmaster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.Illness;

import java.util.List;

/**
 * Created by ScorpioMiku on 2018/10/6.
 */

public class IllAdapter extends RecyclerView.Adapter<IllnessHolder> {
    private List<String> mList;
    private Context context;

    public IllAdapter(List<String> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public IllnessHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.ill_item, parent, false);
        return new IllnessHolder(v, this);
    }

    @Override
    public void onBindViewHolder(IllnessHolder holder, int position) {
        holder.bindView(mList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void deleteItem(int position) {
        mList.remove(position);
        notifyDataSetChanged();
    }
}
