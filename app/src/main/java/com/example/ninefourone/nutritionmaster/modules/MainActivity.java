package com.example.ninefourone.nutritionmaster.modules;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.drawerlayout)
    FlowingDrawer mDrawer;
    @BindView(R.id.navigation_layout)
    LinearLayout navigationLayout;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mDrawer.setTouchMode(ElasticDrawer.TOUCH_MODE_BEZEL);
        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
            @Override
            public void onDrawerStateChange(int oldState, int newState) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
//                    Logger.i("Drawer STATE_CLOSED");
                }
            }

            @Override
            public void onDrawerSlide(float openRatio, int offsetPixels) {
//                Logger.i("openRatio=" + openRatio + " ,offsetPixels=" + offsetPixels);
            }
        });
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    /**
     * 点击事件
     */
    @OnClick(R.id.navigation_layout)
    public void onViewClicked() {
        mDrawer.openMenu();
    }
}
