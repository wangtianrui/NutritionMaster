package com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.recommend;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.adapter.RecommendAdapter;
import com.example.ninefourone.nutritionmaster.base.BaseFragment;
import com.example.ninefourone.nutritionmaster.bean.RecommendFood;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ScorpioMiku on 2018/8/26.
 */

public class RecommendFragment extends BaseFragment {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    Unbinder unbinder;

    private RecommendAdapter adapter;
    private ArrayList<RecommendFood> datas = new ArrayList<>();
    private GridLayoutManager manager;
    private int[] indexs = new int[]{0, 1, 1, 2};

    @Override
    public int getLayoutResId() {
        return R.layout.normal_recommend_fragment_layout;
    }

    @Override
    public void initView(Bundle state) {
        loadData();
        initRecyclerView();
    }


    public static BaseFragment getInstance() {
        return new RecommendFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 初始化recyclerview
     */
    @Override
    protected void initRecyclerView() {
        adapter = new RecommendAdapter(datas);
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        adapter.isFirstOnly(false);
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(false);
        manager = new GridLayoutManager(getContext(), 2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (adapter.getItemViewType(position) == RecommendFood.TYPE_BIG ||
                        adapter.getItemViewType(position) == RecommendFood.TYPE_DETAIL) {
//                    Logger.d(manager.getSpanCount());
                    return manager.getSpanCount();
                } else {
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(manager);
    }

    /**
     * 加载数据
     */
    @Override
    protected void loadData() {
        super.loadData();
        for (int i = 0; i < 20; i++) {
            RecommendFood recommendFood = new RecommendFood(1, "烧肉", "好吃", indexs[i % 4]);
            datas.add(recommendFood);
        }
    }
}
