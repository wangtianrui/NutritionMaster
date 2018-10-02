package com.example.ninefourone.nutritionmaster.modules;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.bumptech.glide.Glide;
import com.cb.ratingbar.CBRatingBar;
import com.example.ninefourone.nutritionmaster.NutritionMaster;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.adapter.HomePagerAdapter;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;
import com.example.ninefourone.nutritionmaster.camera.FoodMaterialCamera;
import com.example.ninefourone.nutritionmaster.modules.addinformation.AddInformationActivity;
import com.example.ninefourone.nutritionmaster.modules.addinformation.AddPhysiqueActivity;
import com.example.ninefourone.nutritionmaster.modules.information.InformationActivity;
import com.example.ninefourone.nutritionmaster.ui.NoScrollViewPager;
import com.example.ninefourone.nutritionmaster.utils.CalculateUtils;
import com.example.ninefourone.nutritionmaster.utils.ConstantUtils;
import com.example.ninefourone.nutritionmaster.utils.MessageUtils;
import com.example.ninefourone.nutritionmaster.utils.PermissionUtils;
import com.flyco.tablayout.SlidingTabLayout;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @BindView(R.id.drawerlayout)
    FlowingDrawer mDrawer;
    @BindView(R.id.navigation_layout)
    LinearLayout navigationLayout;
    @BindView(R.id.view_pager)
    NoScrollViewPager viewPager;
    @BindView(R.id.sliding_tab_layout)
    SlidingTabLayout slidingTabLayout;
    @BindView(R.id.score_bar)
    CBRatingBar scoreBar;
    @BindView(R.id.toolbar_user_avatar)
    CircularImageView toolbarUserAvatar;
    @BindView(R.id.drawer_user_avatar)
    CircularImageView drawerUserAvatar;

    @BindView(R.id.search_view)
    MaterialSearchView searchView;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.boom_menu_button)
    BoomMenuButton boomMenuButton;
    @BindView(R.id.spider_view)
    RadarChart spiderView;
    @BindView(R.id.add_information_button)
    ImageView addInformationButton;
    @BindView(R.id.information_layout)
    LinearLayout informationLayout;
    @BindView(R.id.title_layout)
    AppBarLayout titleLayout;
    @BindView(R.id.user_nick_name)
    TextView userNickName;
    @BindView(R.id.user_occupation_text)
    TextView userOccupationText;
    @BindView(R.id.container)
    RelativeLayout container;
    @BindView(R.id.adder_infor)
    TextView adderInfor;
    @BindView(R.id.add_infor_ll)
    LinearLayout addInforLl;
    @BindView(R.id.show_information)
    LinearLayout showInformation;
    @BindView(R.id.bmi_bar)
    RoundCornerProgressBar bmiBar;
    @BindView(R.id.height_bar)
    RoundCornerProgressBar heightBar;
    @BindView(R.id.weight_bar)
    RoundCornerProgressBar weightBar;
    @BindView(R.id.tool_bar_nickname)
    TextView toolBarNickname;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @SuppressLint("ResourceAsColor")
            @Override
            public void onDrawerStateChange(int oldState, int newState) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
                    titleLayout.setBackgroundColor(getColor(R.color.colorPrimary));
                } else {
                    titleLayout.setBackgroundColor(getColor(R.color.bar_open));
                }
            }

            @Override
            public void onDrawerSlide(float openRatio, int offsetPixels) {
//                Logger.i("openRatio=" + openRatio + " ,offsetPixels=" + offsetPixels);
            }
        });
        initSpiderView();
        initViewPager();
        initSearchView();
        initBMB();
    }

    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager(),
                this);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(homePagerAdapter);
        //CubeInTransformer 内旋
        //FlipHorizontalTransformer 像翻书一样
        //AccordionTransformer  风琴 拉压
        viewPager.setPageTransformer(true, new CubeOutTransformer());
        slidingTabLayout.setViewPager(viewPager);
        viewPager.setCurrentItem(1);
    }

    @Override
    public void initToolBar() {
        toolBarNickname.setText(user.getUsername());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
//        Logger.d("oncreate");
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        askPermission();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        Logger.d("oncreateMenu");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.id_action_search);
        searchView.setMenuItem(item);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
//        Logger.d("prepareMenu");
        return super.onPrepareOptionsMenu(menu);
    }


    //mDrawer.openMenu();

    /**
     * 点击事件
     */


    /**
     * 初始化蛛网图
     */
    private void initSpiderView() {
        float[] scores = {9.1f, 5.5f, 7.7f, 8.9f, 4.6f};
        String[] flags = {"糖分", "淡水", "蛋白质", "维生素", "矿物质"};

        List<RadarEntry> radarEntries = new ArrayList<>();
        for (int i = 0; i < flags.length; i++) {
            RadarEntry radarEntry = new RadarEntry(scores[i], flags[i]);
            radarEntries.add(radarEntry);
        }

        Description description = new Description();
        description.setText("");
        spiderView.setDescription(description);


        spiderView.setWebLineWidth(1.5f);
        // 内部线条宽度，外面的环状线条
        spiderView.setWebLineWidthInner(1.5f);
        // 所有线条WebLine透明度
        spiderView.setWebAlpha(300);


        Legend legend = spiderView.getLegend();
        legend.setEnabled(false);

        XAxis xAxis = spiderView.getXAxis();
        // X坐标值字体样式
        // xAxis.setTypeface(tf);
        // X坐标值字体大小
        xAxis.setTextSize(8f);
        ArrayList<String> xVals = new ArrayList<String>();
        for (String flag : flags) {
            xVals.add(flag);
        }
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));


        YAxis yAxis = spiderView.getYAxis();
        // Y坐标值字体样式
        // yAxis.setTypeface(tf);
        // Y坐标值字体大小
        yAxis.setTextSize(0f);
        // Y坐标值是否从0开始
        yAxis.setStartAtZero(true);
        // 是否显示y值在图表上
        yAxis.setDrawLabels(false);
        yAxis.setAxisLineWidth(2f);
        RadarDataSet set = new RadarDataSet(radarEntries, "体质情况");
//        set.setColor(R.color.bar_open);
        set.setLineWidth(0.5f);
        set.setDrawFilled(true);
//        set.setFillColor(R.color.spider_view_color);
//        set.resetColors();
        RadarData data = new RadarData(set);
        data.setDrawValues(false);
        spiderView.setData(data);
        spiderView.setTouchEnabled(false);
        spiderView.invalidate();


    }

    /**
     * 初始化SearchView
     */
    private void initSearchView() {
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                MessageUtils.MakeToast(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
//                MessageUtils.MakeToast(newText);
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
//                MessageUtils.MakeToast("Shown");
            }

            @Override
            public void onSearchViewClosed() {
//                MessageUtils.MakeToast("closed");
            }
        });

    }


    /**
     * 初始化悬浮按钮
     */
    private void initBMB() {
        HamButton.Builder builder = new HamButton.Builder()
                .normalImageRes(R.drawable.food_material)
                .normalTextRes(R.string.food_meterial_title)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        Intent cameraIntent = new Intent(MainActivity.this,
                                FoodMaterialCamera.class);
                        startActivity(cameraIntent);
                    }
                });
        boomMenuButton.addBuilder(builder);
        HamButton.Builder builder2 = new HamButton.Builder()
                .normalImageRes(R.drawable.foods)
                .normalTextRes(R.string.food_title);
        boomMenuButton.addBuilder(builder2);
    }


    /**
     * 初始化个人信息界面（UI）
     */
    private void initInforView() {
//        Logger.d(NutritionMaster.user.toString());
        adderInfor.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        if (NutritionMaster.user.getHeight() != 0) {
            showInformation.setVisibility(View.VISIBLE);
            adderInfor.setVisibility(View.INVISIBLE);
        } else {
            showInformation.setVisibility(View.INVISIBLE);
            adderInfor.setVisibility(View.VISIBLE);
        }

    }

    /**
     * 请求权限
     */
    private void askPermission() {
        PermissionUtils.requestCameraPermission(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MessageUtils.MakeToast("权限赋予成功");
    }


    /**
     * 点击事件
     *
     * @param view
     */

    @OnClick({R.id.navigation_layout, R.id.add_information_button, R.id.information_layout,
            R.id.user_occupation_text, R.id.adder_infor})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.navigation_layout:
                mDrawer.openMenu();
                break;
            case R.id.add_information_button:
                Intent intent = new Intent(MainActivity.this, AddPhysiqueActivity.class);
                startActivity(intent);
                break;
            case R.id.information_layout:
                Intent informationIntent = new Intent(MainActivity.this, InformationActivity.class);
                startActivity(informationIntent);
                break;
            case R.id.adder_infor:
                Intent i = new Intent(MainActivity.this, AddInformationActivity.class);
                startActivity(i);
                break;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void backChangeData() {
        super.backChangeData();
        initInforView();
        if (NutritionMaster.user.getOccupation_name().equals("")) {

        } else {
            userOccupationText.setText("职业: " + NutritionMaster.user.getOccupation_name());
        }
        initInformationBar();
    }

    /**
     * 初始化个人信息的条状bar还有状态星级的UI
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initInformationBar() {

        scoreBar.setCanTouch(false);
        if (NutritionMaster.user.getHeight() != 0 && NutritionMaster.user.getAge() != 0) {

            float maxBmi = 40.0f;
            float maxHeight = 250.0f;
            float maxWeight = 130.0f;

            float height = NutritionMaster.user.getHeight();
            float weight = NutritionMaster.user.getWeight();
            float age = NutritionMaster.user.getAge();
            float averageWeight = 0;
            float averageHeight = 0;
            float averageBmi = 0;
            int index = (int) (age >= 20 ? ((age - 20) / 5 + 17) : (age - 3));
            if (NutritionMaster.user.getSex() == 0) {
                //女性
                averageWeight = ConstantUtils.averageGirlWeight.get(index);
                averageHeight = ConstantUtils.averageGirlHeight.get(index);
                averageBmi = CalculateUtils.BMI(averageHeight, averageWeight);
            } else if (NutritionMaster.user.getSex() == 1) {
                averageWeight = ConstantUtils.averageBoyWeight.get(index);
                averageHeight = ConstantUtils.averageBoyHeight.get(index);
                averageBmi = CalculateUtils.BMI(averageHeight, averageWeight);
            } else {
                Logger.e("非男非女？");
                return;
            }
            float bmi = CalculateUtils.BMI(height, weight);

            float bmiAverage = averageBmi / maxBmi * 100.0f;
            float bmiSelf = bmi / maxBmi * 100.0f;

            if (bmiAverage > bmiSelf) {
                bmiBar.setMax(100);
                bmiBar.setSecondaryProgress(bmiAverage);
                bmiBar.setProgress(bmiSelf);
            } else {
                bmiBar.setMax(100);
                bmiBar.setSecondaryProgress(bmiSelf);
                bmiBar.setProgress(bmiAverage);
                bmiBar.setProgressColor(getColor(R.color.color_bar_deeper));
                bmiBar.setSecondaryProgressColor(getColor(R.color.color_bar_self));
            }


            float heightAverage = averageHeight / maxHeight * 100.0f;
            float heightSelf = height / maxHeight * 100.0f;
            if (heightAverage > heightSelf) {
                heightBar.setMax(100);
                heightBar.setSecondaryProgress(heightAverage);
                heightBar.setProgress(heightSelf);
            } else {
                heightBar.setMax(100);
                heightBar.setSecondaryProgress(heightSelf);
                heightBar.setProgress(heightAverage);
                heightBar.setProgressColor(getColor(R.color.color_bar_deeper));
                heightBar.setSecondaryProgressColor(getColor(R.color.color_bar_self));
            }


            float weightAverage = averageWeight / maxWeight * 100.0f;
            float weightSelf = weight / maxWeight * 100.0f;
            if (weightAverage > weightSelf) {
                weightBar.setMax(100);
                weightBar.setSecondaryProgress(weightAverage);
                weightBar.setProgress(weightSelf);
            } else {
                weightBar.setMax(100);
                weightBar.setSecondaryProgress(weightSelf);
                weightBar.setProgress(weightAverage);
                weightBar.setProgressColor(getColor(R.color.color_bar_deeper));
                weightBar.setSecondaryProgressColor(getColor(R.color.color_bar_self));
            }

            Logger.d("bmi:" + averageBmi / maxBmi * 100.0f + "|" + bmi / maxBmi * 100.0f + "\n" +
                    "height:" + averageHeight / maxHeight * 100.0f + "|" + height / maxHeight * 100.0f + "\n" +
                    "weight" + averageWeight / maxWeight * 100.0f + "|" + weight / maxWeight * 100.0f);


        }
    }
}
