package com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.customization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;
import com.example.ninefourone.nutritionmaster.bean.FoodMenu;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomizationActivity extends BaseActivity {

    private ArrayList<FoodMenu> breakfastList = new ArrayList<>();
    private ArrayList<FoodMenu> lunchList = new ArrayList<>();
    private ArrayList<FoodMenu> dinnerList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_customization;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        loadData();
        String text = getIntent().getStringExtra("SEND_CODE");
        Logger.d(text);
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void loadData() {
        super.loadData();

    }
}
