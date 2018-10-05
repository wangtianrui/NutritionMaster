package com.example.ninefourone.nutritionmaster.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninefourone.nutritionmaster.NutritionMaster;
import com.example.ninefourone.nutritionmaster.bean.MyUser;
import com.example.ninefourone.nutritionmaster.utils.WebUtil;
import com.orhanobut.logger.Logger;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ScorpioMiku on 2018/8/26.
 */

public abstract class BaseFragment extends Fragment {
    private MyUser user;
    private View parentView;
    private FragmentActivity activity;
    protected boolean isPrepared;
    protected boolean isVisible;
    private Unbinder unbinder;
    private WebUtil webUtil;


    public abstract
    @LayoutRes
    int getLayoutResId();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        parentView = inflater.inflate(getLayoutResId(), container, false);
        activity = getSupportActivity();
        return parentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initView(savedInstanceState);
        webUtil = new WebUtil();
        this.user = NutritionMaster.user;
    }


    public WebUtil getWebUtil() {
        return webUtil;
    }

    /**
     * 初始化自己的ui
     *
     * @param state
     */
    public abstract void initView(Bundle state);


    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    public FragmentActivity getSupportActivity() {
        return super.getActivity();
    }


    public android.app.ActionBar getSupportActionBar() {
        return getSupportActivity().getActionBar();
    }


    public Context getApplicationContext() {
        return this.activity == null ? (getActivity() == null ?
                null : getActivity().getApplicationContext()) : this.activity.getApplicationContext();
    }


    /**
     * Fragment数据的懒加载
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * fragment显示时才加载数据
     */
    protected void onVisible() {
        lazyLoad();
    }

    /**
     * fragment懒加载方法
     */
    protected void lazyLoad() {
    }

    /**
     * fragment隐藏
     */
    protected void onInvisible() {
    }

    /**
     * 加载数据
     */
    protected void loadData() {
    }

    /**
     * 显示进度条
     */
    protected void showProgressBar() {
    }

    /**
     * 隐藏进度条
     */
    protected void hideProgressBar() {
    }

    /**
     * 初始化recyclerView
     */
    protected void initRecyclerView() {
    }

    /**
     * 初始化refreshLayout
     */
    protected void initRefreshLayout() {
    }

    /**
     * 设置数据显示
     */
    protected void finishTask() {
    }

    protected void upUser() {
        NutritionMaster.user = user;
        Logger.d("用户信息已改" + NutritionMaster.user.toString());
    }

}
