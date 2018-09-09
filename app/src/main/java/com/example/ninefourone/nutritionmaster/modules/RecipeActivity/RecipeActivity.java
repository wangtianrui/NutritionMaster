package com.example.ninefourone.nutritionmaster.modules.RecipeActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;
import com.example.ninefourone.nutritionmaster.bean.Menu;
import com.example.ninefourone.nutritionmaster.bean.RecommendFood;
import com.orhanobut.logger.Logger;

public class RecipeActivity extends BaseActivity {

    private RecommendFood recommendFood;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_recipe;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Intent intent = getIntent();
        recommendFood = (RecommendFood) intent.getSerializableExtra("SEND_OBJECT");
        Logger.d(recommendFood.getItemType());
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
