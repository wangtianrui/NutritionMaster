package com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.customization;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.NutritionMaster;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.adapter.CustomizationAdapter;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;
import com.example.ninefourone.nutritionmaster.bean.Element;
import com.example.ninefourone.nutritionmaster.bean.FoodMenu;
import com.example.ninefourone.nutritionmaster.bean.FoodMenuLight;
import com.example.ninefourone.nutritionmaster.utils.CalculateUtils;
import com.example.ninefourone.nutritionmaster.utils.WebUtil;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

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
    @BindView(R.id.tool_bar_title)
    TextView toolBarTitle;

    private ArrayList<FoodMenu> breakfastList = new ArrayList<>();
    private ArrayList<FoodMenu> lunchList = new ArrayList<>();
    private ArrayList<FoodMenu> dinnerList = new ArrayList<>();


    private CustomizationAdapter breakfastAdapter;
    private CustomizationAdapter lunchAdapter;
    private CustomizationAdapter dinnerAdapter;

    private int start;
    private String text;

    private int breakfastCalorie = 0;
    private int lunchCalorie = 0;
    private int dinnerCalorie = 0;

    private int suger = 0;
    private int protein = 0;
    private int fat = 0;
    private int calorie = 0;

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
        text = getIntent().getStringExtra("SEND_CODE");
        Logger.d(text);
        toolBarTitle.setText(text);

        breakfastAdapter = new CustomizationAdapter(breakfastList, this, 0);
        dinnerAdapter = new CustomizationAdapter(dinnerList, this, 1);
        lunchAdapter = new CustomizationAdapter(lunchList, this, 2);

        breakfastRecyclerView.setAdapter(breakfastAdapter);
        dinnerRecyclerView.setAdapter(dinnerAdapter);
        lunchRecyclerView.setAdapter(lunchAdapter);

        breakfastRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dinnerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        lunchRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadData();
        refreshUI();
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
        final WebUtil webUtil = WebUtil.getInstance();
        webUtil.getMenusByElements(getElementLimit(), new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                FoodMenuLight[] foodMenus = new Gson().fromJson(json, FoodMenuLight[].class);
                Logger.d(foodMenus.length);
                Random random = new Random(NutritionMaster.randomSeed + CalculateUtils.title2Int(text));
                start = random.nextInt(foodMenus.length - 50);
                for (int i = start; i < start + 50; i++) {
                    webUtil.getMenu(foodMenus[i].getName(), new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String json = response.body().string();
                            FoodMenu foodMenu = new Gson().fromJson(json, FoodMenu.class);
                            if (foodMenu.getIs_breakfast() == 1) {
                                if (breakfastList.size() < 1) {
                                    breakfastList.add(foodMenu);
                                }
                            } else {
                                if (foodMenu.getName().contains("汤") || foodMenu.getName().contains("糕")
                                        || foodMenu.getImage_url().equals("0") || foodMenu.getName().contains("汁")
                                        || foodMenu.getName().contains("茶")) {

                                } else {
                                    if (lunchList.size() == 0) {
                                        lunchList.add(foodMenu);
                                    } else if (dinnerList.size() == 0) {
                                        dinnerList.add(foodMenu);
                                    } else if (lunchList.size() < 3) {
                                        lunchList.add(foodMenu);
                                    } else if (dinnerList.size() < 3) {
                                        dinnerList.add(foodMenu);
                                    }
                                }
                            }
                            Thread thread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    lunchRecyclerView.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            breakfastAdapter.notifyDataSetChanged();
                                            dinnerAdapter.notifyDataSetChanged();
                                            lunchAdapter.notifyDataSetChanged();
                                        }
                                    });
                                }
                            });
                            thread.start();
                        }
                    });
                }
            }
        });

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

    private Map<String, Double> getElementLimit() {
        Map<String, Double> params = new HashMap<>();
        try {
            Element calculated = NutritionMaster.element.calculateData(NutritionMaster.user);
            params.put("calorie", (calculated.getCalorie() - NutritionMaster.user.getEaten_elements().getCalorie()) / 8);
            params.put("fat", (calculated.getFat() - NutritionMaster.user.getEaten_elements().getFat()) / 8);


            Logger.d((calculated.getCalorie() - NutritionMaster.user.getEaten_elements().getCalorie()));
            Logger.d(calculated.getFat() - NutritionMaster.user.getEaten_elements().getFat());
            Logger.d((calculated.getCarbohydrate() - NutritionMaster.user.getEaten_elements().getCarbohydrate()));
            Logger.d(calculated.getProtein() - NutritionMaster.user.getEaten_elements().getProtein());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return params;
    }

    /**
     * 加载元素总量
     */
    public void refreshUI() {
//        Logger.d(flag);
//        if (flag == 0) {
//            breakfastCalorie += calorie;
//            breakfastEnergyText.setText((int) breakfastCalorie + "千卡");
//        } else if (flag == 1) {
//            lunchCalorie += calorie;
//            lunchEnergyText.setText(lunchCalorie + "千卡");
//        } else {
//            dinnerCalorie += calorie;
//            dinnerEnergyText.setText(dinnerCalorie + "千卡");
//        }
//        calorieText.setText(breakfastCalorie + lunchCalorie + dinnerCalorie + "");
//        this.suger += suger;
//        this.fat += fat;
//        this.protein = protein;
//        sugerText.setText(this.suger + "");
//        fatText.setText(this.fat + "");
//        proteinText.setText(this.protein + "");
        try {
            Element element = NutritionMaster.element.calculateData(NutritionMaster.user);
            suger = (int) (element.getCarbohydrate() - NutritionMaster.user.getEaten_elements().getCarbohydrate());
            sugerText.setText(suger + "");
            fat = (int) (element.getFat() - NutritionMaster.user.getEaten_elements().getFat());
            fatText.setText(fat + "");
            calorie = (int) (element.getCalorie() - NutritionMaster.user.getEaten_elements().getCalorie());
            calorieText.setText(calorie + "");
            protein = (int) (element.getProtein() - NutritionMaster.user.getEaten_elements().getProtein());
            proteinText.setText(protein+"");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }


}
