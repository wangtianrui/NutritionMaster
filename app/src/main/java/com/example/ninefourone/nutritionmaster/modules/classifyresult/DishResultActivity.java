package com.example.ninefourone.nutritionmaster.modules.classifyresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.NutritionMaster;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.adapter.ResultListAdapter;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;
import com.example.ninefourone.nutritionmaster.bean.ClassifyResult;
import com.example.ninefourone.nutritionmaster.bean.Element;
import com.example.ninefourone.nutritionmaster.utils.MessageUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

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

        resultListAdapter = new ResultListAdapter(results, this);
        recyclerView.setAdapter(resultListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    /**
     * 能量根据选择的来变
     *
     * @param quantity
     */
    public void refreshData(int quantity, int positon) {
        float calorieSum = 0;
        float fatSum = 0;
        float sugarSum = 0;
        float proteinSum = 0;
        ClassifyResult temp = results.get(positon);
        temp.setQuantity(quantity);
        results.set(positon, temp);
        for (int i = 0; i < results.size(); i++) {
            calorieSum += results.get(i).getCalorie() * results.get(i).getQuantity() / 100;
            fatSum += results.get(i).getFoodMenu().getElements().getFat() * results.get(i).getQuantity() / 100;
            sugarSum += results.get(i).getFoodMenu().getElements().getCarbohydrate() * results.get(i).getQuantity() / 100;
            proteinSum += results.get(i).getFoodMenu().getElements().getProtein() * results.get(i).getQuantity() / 100;
        }
        calorie.setText((int) calorieSum + "");
        protein.setText((int) proteinSum + "");
        fat.setText((int) fatSum + "");
        suger.setText((int) sugarSum + "");
    }

    @OnClick(R.id.ok_button)
    public void onViewClicked() {
        MessageUtils.MakeToast("已将信息加入到已吃记录");
        for (int i = 0; i < results.size(); i++) {
            NutritionMaster.user.getEaten_elements().add(new Element(results.get(i).getFoodMenu().getElements()),
                    1.5f);
        }
        finish();
    }
}
