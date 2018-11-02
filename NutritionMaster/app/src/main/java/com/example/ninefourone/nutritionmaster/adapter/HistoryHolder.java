package com.example.ninefourone.nutritionmaster.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.FoodMenu;
import com.example.ninefourone.nutritionmaster.bean.History;
import com.example.ninefourone.nutritionmaster.bean.RecommendFood;
import com.example.ninefourone.nutritionmaster.modules.RecipeActivity.RecipeActivity;
import com.example.ninefourone.nutritionmaster.utils.WebUtil;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by ScorpioMiku on 2018/11/7.
 */

public class HistoryHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.describle)
    TextView describle;
    private FoodMenu foodMenu;

    public HistoryHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(History history) {
        Glide.with(itemView.getContext()).load(history.getMenu().getImage_url()).into(image);
        name.setText(history.getMenu().getName());
        WebUtil webUtil = WebUtil.getInstance();
        webUtil.getMenu(history.getMenu().getName(), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                foodMenu = new Gson().fromJson(json, FoodMenu.class);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(itemView.getContext().getApplicationContext(), RecipeActivity.class);
                        RecommendFood recommendFood = new RecommendFood(foodMenu, 1);
                        intent.putExtra("SEND_OBJECT", recommendFood);
                        itemView.getContext().getApplicationContext().startActivity(intent);
                    }
                });
            }
        });

    }
}
