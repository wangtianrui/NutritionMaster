package com.example.ninefourone.nutritionmaster.modules.classifyresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.adapter.ResultListAdapter;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;
import com.example.ninefourone.nutritionmaster.bean.ClassifyResult;
import com.example.ninefourone.nutritionmaster.utils.ConstantUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.BindView;

public class DishResultActivity extends BaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.calorie)
    TextView calorie;
    @BindView(R.id.suger)
    TextView suger;
    @BindView(R.id.fat)
    TextView fat;
    @BindView(R.id.protein)
    TextView protein;
    @BindView(R.id.ok_button)
    Button okButton;
    //    private ResultList results;
    private ArrayList<ClassifyResult> results;
    private ResultListAdapter resultListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_dish_result;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        Intent intent = getIntent();
        results = (ArrayList<ClassifyResult>) intent.getSerializableExtra("LIST");
//        for (int i = 0; i < results.size(); i++) {
//            Logger.d(results.get(i));
//        }
        resultListAdapter = new ResultListAdapter(ConstantUtils.testData, this);
        recyclerView.setAdapter(resultListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
