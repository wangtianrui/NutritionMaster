package com.example.ninefourone.nutritionmaster.modules;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.cb.ratingbar.CBRatingBar;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.adapter.HomePagerAdapter;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;
import com.example.ninefourone.nutritionmaster.ui.NoScrollViewPager;
import com.example.ninefourone.nutritionmaster.utils.MessageUtils;
import com.flyco.tablayout.SlidingTabLayout;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.panpf.swsv.CircularLayout;
import me.panpf.swsv.SpiderWebScoreView;

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
    @BindView(R.id.spiderWeb_mainActivity)
    SpiderWebScoreView spiderWebMainActivity;
    @BindView(R.id.layout_mainActivity_circular)
    CircularLayout layoutMainActivityCircular;
    //    @BindView(R.id.search_button)
//    ImageView searchButton;
    @BindView(R.id.search_view)
    MaterialSearchView searchView;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;


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
        spiderWebMainActivity.setScores(10f, scores);
        layoutMainActivityCircular.removeAllViews();
        for (String flag : flags) {
            TextView scoreTextView = (TextView) LayoutInflater.from(getBaseContext()).inflate(R.layout.score,
                    layoutMainActivityCircular, false);
            scoreTextView.setText(flag);
            layoutMainActivityCircular.addView(scoreTextView);
        }
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

}
