package com.example.ninefourone.nutritionmaster.modules.RecipeActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.adapter.MenuAdapter;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;
import com.example.ninefourone.nutritionmaster.bean.Menu;
import com.example.ninefourone.nutritionmaster.bean.RecommendFood;
import com.example.ninefourone.nutritionmaster.utils.UiUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.BindView;

public class RecipeActivity extends BaseActivity {


    private RecommendFood recommendFood;
    private Menu menu;

    private ArrayList<String> menuList = new ArrayList<>();

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

        final int changedHeight = UiUtils.dp2px(this, 214);

        Intent intent = getIntent();
        recommendFood = (RecommendFood) intent.getSerializableExtra("SEND_OBJECT");
        Logger.d(recommendFood.getItemType());
        initList();
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void initList() {
        for (int i = 0; i < 10; i++) {
            menuList.add("1");
        }
    }

    @Override
    public void initRecyclerView() {
        super.initRecyclerView();
        MenuAdapter adapter = new MenuAdapter(menuList, this);
    }
}
