package com.example.ninefourone.nutritionmaster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.FoodMenu;
import com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.customization.CustomizationActivity;

import java.util.ArrayList;

/**
 * Created by ScorpioMiku on 2018/9/24.
 */

public class CustomizationAdapter extends RecyclerView.Adapter<CustomizationHolder> {
    private ArrayList<FoodMenu> mList;
    private Context context;
    private int flag;

    public CustomizationAdapter(ArrayList<FoodMenu> mList, Context context, int flag) {
        this.mList = mList;
        this.context = context;
        this.flag = flag;
    }

    @Override
    public CustomizationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.customization_item, parent, false);
        return new CustomizationHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomizationHolder holder, int position) {
        holder.bindView(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
