package com.example.ninefourone.nutritionmaster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.FoodMenu;

import java.util.ArrayList;

/**
 * Created by ScorpioMiku on 2018/10/7.
 */

public class MaterialResultAdapter extends RecyclerView.Adapter<MaterialResultHolder> {
    private ArrayList<FoodMenu> foodMenus;
    private Context context;

    public MaterialResultAdapter(ArrayList<FoodMenu> foodMenus, Context context) {
        this.foodMenus = foodMenus;
        this.context = context;
    }

    @Override
    public MaterialResultHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.material_result_item, parent, false);
        return new MaterialResultHolder(view);
    }

    @Override
    public void onBindViewHolder(MaterialResultHolder holder, int position) {
        holder.bindView(foodMenus.get(position));
    }

    @Override
    public int getItemCount() {
        return foodMenus.size();
    }
}
