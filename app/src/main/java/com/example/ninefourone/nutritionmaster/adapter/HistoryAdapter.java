package com.example.ninefourone.nutritionmaster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.History;

import java.util.List;

/**
 * Created by ScorpioMiku on 2018/11/7.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryHolder> {
    private Context context;
    private List<History> mList;

    public HistoryAdapter(Context context, List mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public HistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dish_item, parent, false);
        HistoryHolder historyHolder = new HistoryHolder(view);
        return historyHolder;
    }

    @Override
    public void onBindViewHolder(HistoryHolder holder, int position) {
        holder.bindView(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
