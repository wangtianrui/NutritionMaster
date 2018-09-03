package com.example.ninefourone.nutritionmaster.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.RecommendFood;

import java.util.List;

/**
 * Created by ScorpioMiku on 2018/9/3.
 */

public class RecommendAdapter extends BaseMultiItemQuickAdapter<RecommendFood, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public RecommendAdapter(List<RecommendFood> data) {
        super(data);
        addItemType(RecommendFood.TYPE_BIG, R.layout.recommend_item_big);
        addItemType(RecommendFood.TYPE_DETAIL, R.layout.recommend_item_detail);
        addItemType(RecommendFood.TYPE_MIDDLE, R.layout.recommend_item_middle);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendFood item) {
        switch (item.getItemType()) {
            case RecommendFood.TYPE_BIG:
                helper.setImageResource(R.id.recommend_item_imageview, R.drawable.food_test);
                helper.setText(R.id.recommend_item_title, "红烧肉");
                break;
            case RecommendFood.TYPE_DETAIL:
                helper.setImageResource(R.id.recommend_item_imageview, R.drawable.food_test);
                helper.setText(R.id.recommend_item_title, item.getTitle());
                helper.setText(R.id.recommend_item_description, item.getDescription());
                break;
            case RecommendFood.TYPE_MIDDLE:
                helper.setImageResource(R.id.recommend_item_imageview, R.drawable.food_test);
                helper.setText(R.id.recommend_item_title, "红烧");
                break;
        }
    }
}
