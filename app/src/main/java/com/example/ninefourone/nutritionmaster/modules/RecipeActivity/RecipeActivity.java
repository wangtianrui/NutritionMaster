package com.example.ninefourone.nutritionmaster.modules.RecipeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.adapter.MakeStepAdapter;
import com.example.ninefourone.nutritionmaster.adapter.MaterialAdapter;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;
import com.example.ninefourone.nutritionmaster.bean.RecommendFood;
import com.example.ninefourone.nutritionmaster.utils.CalculateUtils;
import com.example.ninefourone.nutritionmaster.utils.MessageUtils;
import com.github.lzyzsd.circleprogress.ArcProgress;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
import com.orhanobut.logger.Logger;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

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
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.back_button)
    ImageView backButton;
    @BindView(R.id.protein_text)
    TextView proteinText;
    @BindView(R.id.fat_text)
    TextView fatText;
    @BindView(R.id.suger_text)
    TextView sugerText;
    @BindView(R.id.boom_menu_button)
    BoomMenuButton boomMenuButton;
    private RecommendFood recommendFood;


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
        Glide.with(RecipeActivity.this).load(recommendFood.getPicture()).into(image);
        name.setText(recommendFood.getMenu().getName());
        HashMap map = CalculateUtils.elementsProportion(recommendFood.getMenu().getElements());
        proteinCircle.setProgress((int) map.get("protein"));
        fatCircle.setProgress((int) map.get("fat"));
        carbohydrateCircle.setProgress((int) map.get("suger"));
        proteinText.setText(new Double(recommendFood.getMenu().getElements().getProtein()).intValue() + "克");
        fatText.setText(new Double(recommendFood.getMenu().getElements().getFat()).intValue() + "克");
        sugerText.setText(new Double(recommendFood.getMenu().getElements().getCarbohydrate()).intValue() + "克");
        Logger.d(recommendFood.getMenu().getPractice());
        initList();
        initBMB();
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void initList() {
        materialAdapter = new MaterialAdapter(recommendFood.getMenu().getCook_quantity(), RecipeActivity.this);
        materialRecyclerView.setAdapter(materialAdapter);
        materialRecyclerView.setLayoutManager(new LinearLayoutManager(RecipeActivity.this));
        materialRecyclerView.setNestedScrollingEnabled(false);

        makeStepAdapter = new MakeStepAdapter(
                CalculateUtils.getStepArray(recommendFood.getMenu().getPractice()), RecipeActivity.this);
        detailWayRecyclerView.setLayoutManager(new LinearLayoutManager(RecipeActivity.this));
        detailWayRecyclerView.setAdapter(makeStepAdapter);
        detailWayRecyclerView.setNestedScrollingEnabled(false);
    }


    /**
     * 初始化悬浮按钮
     */
    private void initBMB() {
        HamButton.Builder builder = new HamButton.Builder()
                .normalImageRes(R.drawable.ic_add_recipe)
                .normalTextRes(R.string.recipe_add_string)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        MessageUtils.MakeToast("已添加到记录");
                    }
                });
        boomMenuButton.addBuilder(builder);
    }

    @OnClick(R.id.back_button)
    public void onViewClicked() {
        finish();
    }
}
