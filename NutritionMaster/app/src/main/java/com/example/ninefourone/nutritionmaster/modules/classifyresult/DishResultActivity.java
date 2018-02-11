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


    private int flag = 0;
    private ArrayList<ClassifyResult> results;
    private ResultListAdapter resultListAdapter;
    private float wholesum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flag = 0;
        wholesum = 0 ;
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
        if (flag == 0) {
            calorieSum = checkData((int) calorieSum);
        } else if (flag == -1) {

        } else {
            calorieSum = calorieSum - flag * 300;
        }
        wholesum = calorieSum;
        calorie.setText((int) calorieSum + "");
        protein.setText((int) proteinSum + "");
        fat.setText((int) fatSum + "");
        suger.setText((int) sugarSum + "");
    }

    @OnClick(R.id.ok_button)
    public void onViewClicked() {
        double tempCalorie = 0;
        MessageUtils.MakeToast("已将信息加入到已吃记录");
        for (int i = 0; i < results.size(); i++) {
            tempCalorie += NutritionMaster.user.getEaten_elements().getCalorie();
            results.get(i).getFoodMenu().getElements().setCalorie(0);
            NutritionMaster.user.getEaten_elements().add(new Element(results.get(i).getFoodMenu().getElements()),
                    1.5f);
        }
        NutritionMaster.user.getEaten_elements().setCalorie(
                (int) (NutritionMaster.user.getEaten_elements().getCalorie() + wholesum));
        finish();
    }

    private int checkData(int data) {
        if (data < 1000) {
            if (flag == 0) {
                flag = -1;
            }
            return data;
        } else {
            flag++;
            return checkData(data - 300);
        }
    }
}
