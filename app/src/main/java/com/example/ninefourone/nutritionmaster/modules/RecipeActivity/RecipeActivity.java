package com.example.ninefourone.nutritionmaster.modules.RecipeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.adapter.MakeStepAdapter;
import com.example.ninefourone.nutritionmaster.adapter.MaterialAdapter;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;
import com.example.ninefourone.nutritionmaster.bean.Material;
import com.example.ninefourone.nutritionmaster.bean.Menu;
import com.example.ninefourone.nutritionmaster.bean.RecommendFood;
import com.example.ninefourone.nutritionmaster.utils.UiUtils;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.BindView;

public class RecipeActivity extends BaseActivity {


    @BindView(R.id.protein_circle)
    ArcProgress proteinCircle;
    @BindView(R.id.fat_circle)
    ArcProgress fatCircle;
    @BindView(R.id.carbohydrate_circle)
    ArcProgress carbohydrateCircle;
    @BindView(R.id.material_recycler_view)
    RecyclerView materialRecyclerView;
    @BindView(R.id.detail_way_recycler_view)
    RecyclerView detailWayRecyclerView;
    private RecommendFood recommendFood;
    private Menu menu;

    private MaterialAdapter materialAdapter;
    private MakeStepAdapter makeStepAdapter;

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
        initList();
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void initList() {
        ArrayList<Material> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Material material = new Material("毛豆", 100);
            list.add(material);
        }
        ArrayList<String> mList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            String step = "第一步";
            mList.add(step);
        }
        menu = new Menu("毛豆炒肉", list, mList);

        makeStepAdapter = new MakeStepAdapter(menu.getMakeSteps(), this);
        detailWayRecyclerView.setAdapter(makeStepAdapter);
        detailWayRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        materialAdapter = new MaterialAdapter(menu.getMaterialArrayList(), this);
        materialRecyclerView.setAdapter(materialAdapter);
        materialRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
