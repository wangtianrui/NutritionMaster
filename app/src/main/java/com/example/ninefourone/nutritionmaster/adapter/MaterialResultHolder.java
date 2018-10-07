package com.example.ninefourone.nutritionmaster.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.FoodMenu;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ScorpioMiku on 2018/10/7.
 */

public class MaterialResultHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.recommend_item_imageview)
    ImageView recommendItemImageview;
    @BindView(R.id.recommend_item_title)
    TextView recommendItemTitle;
    @BindView(R.id.whole_layout)
    LinearLayout wholeLayout;

    public MaterialResultHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(FoodMenu foodMenu) {
        Glide.with(itemView.getContext()).load(foodMenu.getImage_url()).into(recommendItemImageview);
        recommendItemTitle.setText(foodMenu.getName());
    }
}
