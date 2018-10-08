package com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.customization;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.adapter.CardAdapter;
import com.example.ninefourone.nutritionmaster.adapter.CardHolder;
import com.example.ninefourone.nutritionmaster.base.BaseFragment;
import com.example.ninefourone.nutritionmaster.bean.DailyCard;
import com.example.ninefourone.nutritionmaster.cardconfig.CardConfig;
import com.example.ninefourone.nutritionmaster.cardconfig.CardItemTouchCallBack;
import com.example.ninefourone.nutritionmaster.cardconfig.SwipeCardLayoutManager;
import com.example.ninefourone.nutritionmaster.utils.CalculateUtils;
import com.example.ninefourone.nutritionmaster.utils.ConstantUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ScorpioMiku on 2018/8/26.
 */

public class CustomizationFragment extends BaseFragment {

    @BindView(R.id.card_recycler_view)
    RecyclerView cardRecyclerView;
    Unbinder unbinder;

    private CardAdapter cardAdapter;
    private ArrayList<DailyCard> mDataList = new ArrayList<>();

    private int[] picList = new int[]{
            R.drawable.monday,
            R.drawable.tuesday,
            R.drawable.wednesday,
            R.drawable.thursday,
            R.drawable.friday,
            R.drawable.saturday,
            R.drawable.sunday
    };


    @Override
    public int getLayoutResId() {
        return R.layout.customization;
    }

    @Override
    public void initView(Bundle state) {
        loadData();
        initCardRecyclerView();
    }


    public static BaseFragment getInstance() {
        return new CustomizationFragment();
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

    @Override
    protected void loadData() {
        super.loadData();
        for (int i = CalculateUtils.getWeek(); i <= 7; i++) {
//            Logger.d(CalculateUtils.getWeek());
//            mDataList.add("周" + ConstantUtils.arab2Chinese(i) + "美食普");
            DailyCard dailyCard = new DailyCard(
                    "周" + ConstantUtils.arab2Chinese(i) + "美食普",
                    ConstantUtils.dailyDescibes[i - 1],
                    picList[i - 1]
            );
            mDataList.add(dailyCard);
        }
        for (int i = 1; i < CalculateUtils.getWeek(); i++) {
//            mDataList.add("周" + ConstantUtils.arab2Chinese(i) + "美食普");
            DailyCard dailyCard = new DailyCard(
                    "周" + ConstantUtils.arab2Chinese(i) + "美食谱",
                    ConstantUtils.dailyDescibes[i - 1],
                    picList[i - 1]
            );
            mDataList.add(dailyCard);
        }
    }

    /**
     * 初始化card recyclerview
     */
    private void initCardRecyclerView() {
        CardConfig.initConfig(getContext());
        cardRecyclerView.setLayoutManager(new SwipeCardLayoutManager());
        cardAdapter = new CardAdapter(getContext(), mDataList);
        cardRecyclerView.setAdapter(cardAdapter);

        CardItemTouchCallBack callBack = new CardItemTouchCallBack(cardRecyclerView, cardAdapter, mDataList);
        //2.创建ItemTouchHelper并把callBack传进去
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callBack);
        //3.与RecyclerView关联起来
        itemTouchHelper.attachToRecyclerView(cardRecyclerView);
    }

}
