package com.example.ninefourone.nutritionmaster.modules.classifyresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.adapter.MaterialResultAdapter;
import com.example.ninefourone.nutritionmaster.adapter.MaterialResultHolder;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;
import com.example.ninefourone.nutritionmaster.bean.ClassifyResult;
import com.example.ninefourone.nutritionmaster.bean.FoodMenu;
import com.example.ninefourone.nutritionmaster.bean.Material;
import com.example.ninefourone.nutritionmaster.utils.WebUtil;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MaterialResultActivity extends BaseActivity {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    ArrayList<ClassifyResult> classifyResults;
    ArrayList<FoodMenu> list;
    private ArrayList<String> nameList;
    private MaterialResultAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_material_result;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Intent intent = getIntent();
//        classifyResults = (ArrayList<ClassifyResult>) intent.getSerializableExtra("LIST");
//        list = classifyResults.get(0).getFoodMaterial().getMenus();
        nameList = (ArrayList<String>) intent.getSerializableExtra("LIST");
        adapter = new MaterialResultAdapter(list, MaterialResultActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(MaterialResultActivity.this));

        WebUtil.getInstance().getMenusByMaterials(nameList, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                String json = response.body().string();
                FoodMenu[] menus = new Gson().fromJson(json, FoodMenu[].class);
                for (FoodMenu foodMenu : menus) {
                    list.add(foodMenu);
                }
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);


    }
}
