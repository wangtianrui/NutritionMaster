package com.example.ninefourone.nutritionmaster.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.Material;

import java.util.ArrayList;

/**
 * Created by ScorpioMiku on 2018/9/9.
 */

public class MaterialAdapter extends RecyclerView.Adapter<MaterialHolder> {
    private ArrayList<Material> mList;
    private Context mContext;

    public MaterialAdapter(ArrayList mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public MaterialHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.material_item, parent, false);
        return new MaterialHolder(view);
    }

    @Override
    public void onBindViewHolder(MaterialHolder holder, int position) {
        holder.bindView(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
