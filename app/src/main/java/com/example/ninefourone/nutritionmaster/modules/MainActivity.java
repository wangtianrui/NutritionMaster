package com.example.ninefourone.nutritionmaster.modules;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.cb.ratingbar.CBRatingBar;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.adapter.HomePagerAdapter;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;
import com.example.ninefourone.nutritionmaster.camera.FoodMaterialCamera;
import com.example.ninefourone.nutritionmaster.ui.NoScrollViewPager;
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
    @BindView(R.id.bar_cover)
    FrameLayout barCover;
    @BindView(R.id.cb_rating_bar)
    CBRatingBar cbRatingBar;
    @BindView(R.id.toolbar_user_avatar)
    CircularImageView toolbarUserAvatar;
    @BindView(R.id.drawer_user_avatar)
    CircularImageView drawerUserAvatar;
    //    @BindView(R.id.spiderWeb_mainActivity)
//    SpiderWebScoreView spiderWebMainActivity;
//    @BindView(R.id.layout_mainActivity_circular)
//    CircularLayout layoutMainActivityCircular;
    //    @BindView(R.id.search_button)
//    ImageView searchButton;
    @BindView(R.id.search_view)
    MaterialSearchView searchView;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.boom_menu_button)
    BoomMenuButton boomMenuButton;
    @BindView(R.id.spider_view)
    RadarChart spiderView;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onDrawerStateChange(int oldState, int newState) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
                    barCover.setVisibility(View.INVISIBLE);
                } else {
                    barCover.setVisibility(View.VISIBLE);
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
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager(), this);
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
        Logger.d("oncreate");
        setSupportActionBar(toolBar);
        askPermission();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Logger.d("oncreateMenu");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.id_action_search);
        searchView.setMenuItem(item);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Logger.d("prepareMenu");
        return super.onPrepareOptionsMenu(menu);
    }


    /**
     * 点击事件
     */
    @OnClick(R.id.navigation_layout)
    public void onViewClicked() {
        mDrawer.openMenu();
    }


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
                        Intent cameraIntent = new Intent(MainActivity.this, FoodMaterialCamera.class);
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
     * 请求权限
     */
    private void askPermission() {
        PermissionUtils.requestCameraPermission(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MessageUtils.MakeToast("权限赋予成功");
    }
}
