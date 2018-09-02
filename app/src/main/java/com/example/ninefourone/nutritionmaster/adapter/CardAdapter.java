package com.example.ninefourone.nutritionmaster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninefourone.nutritionmaster.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

/**
 * Created by ScorpioMiku on 2018/9/2.
 */

public class CardAdapter extends RecyclerView.Adapter<CardHolder> {
    private Context context;
    private ArrayList<String> mList;

    public CardAdapter(Context context, ArrayList<String> mList) {
        this.context = context;
        this.mList = mList;
    }


    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        CardHolder cardHolder = new CardHolder(view);
        return cardHolder;
    }

    @Override
    public void onBindViewHolder(CardHolder holder, int position) {
        holder.bindView(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 右划
     */
    public void swipe2Right() {
        Logger.d("右划");
    }

    /**
     * 左划
     */
    public void swipe2left() {
        Logger.d("左划");
    }
}
