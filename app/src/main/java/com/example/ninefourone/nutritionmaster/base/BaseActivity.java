package com.example.ninefourone.nutritionmaster.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ninefourone.nutritionmaster.NutritionMaster;
import com.example.ninefourone.nutritionmaster.bean.MyUser;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ScorpioMiku on 2018/8/26.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initViews(savedInstanceState);
        initToolBar();
    }


    /**
     * 设置布局layout
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化views
     *
     * @param savedInstanceState
     */
    public abstract void initViews(Bundle savedInstanceState);

    /**
     * 初始化toolbar
     */
    public abstract void initToolBar();

    /**
     * 加载数据
     */
    public void loadData() {
    }

    /**
     * 显示进度条
     */
    public void showProgressBar() {
    }

    /**
     * 隐藏进度条
     */
    public void hideProgressBar() {
    }

    /**
     * 初始化recyclerView
     */
    public void initRecyclerView() {
    }

    /**
     * 初始化refreshLayout
     */
    public void initRefreshLayout() {
    }

    /**
     * 设置数据显示
     */
    public void finishTask() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    protected void upUser(MyUser user) {
        NutritionMaster.user = user;
    }
}
