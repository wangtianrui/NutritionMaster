package com.example.ninefourone.nutritionmaster.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.FoodMenu;
import com.example.ninefourone.nutritionmaster.bean.RecommendFood;
import com.example.ninefourone.nutritionmaster.modules.RecipeActivity.RecipeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ScorpioMiku on 2018/10/7.
 */

public class MaterialResultHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.whole_layout)
    LinearLayout wholeLayout;

    public MaterialResultHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(final FoodMenu foodMenu) {
        Glide.with(itemView.getContext()).load(foodMenu.getImage_url()).into(image);
        name.setText(foodMenu.getName());
        wholeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext().getApplicationContext(), RecipeActivity.class);
                RecommendFood recommendFood = new RecommendFood(foodMenu, 1);
                intent.putExtra("SEND_OBJECT", recommendFood);
                itemView.getContext().getApplicationContext().startActivity(intent);
            }
        });
    }
}
