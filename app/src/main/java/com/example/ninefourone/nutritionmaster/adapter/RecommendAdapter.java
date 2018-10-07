package com.example.ninefourone.nutritionmaster.adapter;


import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.RecommendFood;
import com.example.ninefourone.nutritionmaster.modules.RecipeActivity.RecipeActivity;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by ScorpioMiku on 2018/9/3.
 */

public class RecommendAdapter extends BaseMultiItemQuickAdapter<RecommendFood, BaseViewHolder> {
    private int[] indexs = new int[]{0, 1, 1, 2};
    private Intent intent;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public RecommendAdapter(List<RecommendFood> data) {
        super(data);
        addItemType(RecommendFood.TYPE_BIG, R.layout.recommend_item_middle);
        addItemType(RecommendFood.TYPE_DETAIL, R.layout.recommend_item_detail);
        addItemType(RecommendFood.TYPE_MIDDLE, R.layout.recommend_item_middle);
    }

    @Override
    protected void convert(BaseViewHolder helper, final RecommendFood item) {
        intent = new Intent(mContext, RecipeActivity.class);
        intent.putExtra("SEND_OBJECT", item);
        ImageView imageView = helper.getView(R.id.recommend_item_imageview);
        View view = helper.getView(R.id.whole_layout);
        Glide.with(mContext).load(item.getPicture()).into(imageView);


        switch (item.getItemType()) {
            case RecommendFood.TYPE_BIG:
                helper.setText(R.id.recommend_item_title, item.getTitle());
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(intent);
                    }
                });
                break;
            case RecommendFood.TYPE_DETAIL:
                helper.setText(R.id.recommend_item_title, item.getTitle());
                helper.setText(R.id.recommend_item_description, item.getDescription());
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(intent);
                    }
                });

                LinearLayout detailClick = helper.getView(R.id.detail_click);

                detailClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext).setTitle("小知识")
                                        .setMessage(item.getDescription()).setIcon(R.drawable.ic_add_recipe);
                        AlertDialog dialog = builder.create();
                        dialog.setCanceledOnTouchOutside(true);
                        dialog.setCancelable(true);
                        dialog.show();
                    }
                });
                break;
            case RecommendFood.TYPE_MIDDLE:
                helper.setText(R.id.recommend_item_title, item.getTitle());
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mContext.startActivity(intent);
                    }
                });
                break;
        }


    }

    @Override
    public void loadMoreComplete() {
        super.loadMoreComplete();

    }

    @Override
    public void loadMoreEnd() {
        super.loadMoreEnd();
    }

    @Override
    public void loadMoreFail() {
        super.loadMoreFail();
    }


}
