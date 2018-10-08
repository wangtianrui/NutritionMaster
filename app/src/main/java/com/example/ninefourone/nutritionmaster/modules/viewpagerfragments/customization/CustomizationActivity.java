package com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.customization;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;
import com.example.ninefourone.nutritionmaster.bean.FoodMenu;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomizationActivity extends BaseActivity {

    @BindView(R.id.breakfast_energy_text)
    TextView breakfastEnergyText;
    @BindView(R.id.breakfast_recycler_view)
    RecyclerView breakfastRecyclerView;
    @BindView(R.id.lunch_energy_text)
    TextView lunchEnergyText;
    @BindView(R.id.lunch_recycler_view)
    RecyclerView lunchRecyclerView;
    @BindView(R.id.dinner_energy_text)
    TextView dinnerEnergyText;
    @BindView(R.id.dinner_recycler_view)
    RecyclerView dinnerRecyclerView;
    @BindView(R.id.calorie_text)
    TextView calorieText;
    @BindView(R.id.fat_text)
    TextView fatText;
    @BindView(R.id.suger_text)
    TextView sugerText;
    @BindView(R.id.protein_text)
    TextView proteinText;
    @BindView(R.id.change_button)
    LinearLayout changeButton;
    @BindView(R.id.copy_button)
    LinearLayout copyButton;

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

    @OnClick({R.id.change_button, R.id.copy_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.change_button:
                break;
            case R.id.copy_button:
                break;
        }
    }
}
