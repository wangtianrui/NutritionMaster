package com.example.ninefourone.nutritionmaster.adapter;

import android.content.Context;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.bean.ClassifyResult;
import com.example.ninefourone.nutritionmaster.modules.classifyresult.DishResultActivity;
import com.example.ninefourone.nutritionmaster.utils.ConstantUtils;
import com.example.ninefourone.nutritionmaster.utils.MessageUtils;
import com.github.siyamed.shapeimageview.CircularImageView;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import travel.ithaka.android.horizontalpickerlib.PickerLayoutManager;

/**
 * Created by ScorpioMiku on 2018/10/5.
 */

public class ResultListHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.picker)
    RecyclerView picker;

    private PickerAdapter pickerAdapter;
    private Context context;

    public ResultListHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        context = itemView.getContext();
    }

    public void bindView(ClassifyResult classifyResult, PickerLayoutManager pickerLayoutManager,
                         final DishResultActivity dishResultActivity, final int position) {
        int index = (int) classifyResult.getQuantity() / 2 - 2;
        pickerLayoutManager.setChangeAlpha(true);
        pickerLayoutManager.setScaleDownBy(0.99f);
        pickerLayoutManager.setScaleDownDistance(0.8f);
        picker.setLayoutManager(pickerLayoutManager);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(picker);
        pickerAdapter = new PickerAdapter(ConstantUtils.dishPicerData, context);
        picker.setAdapter(pickerAdapter);
        picker.setNestedScrollingEnabled(false);
        picker.scrollToPosition(index);
        picker.smoothScrollBy(10, 0);

        pickerLayoutManager.setOnScrollStopListener(new PickerLayoutManager.onScrollStopListener() {
            @Override
            public void selectedView(View view) {
                String text = ((TextView) view).getText().toString();
//                MessageUtils.MakeToast(text);
                dishResultActivity.refreshData(Integer.valueOf(text), position);
            }
        });


        name.setText(classifyResult.getName());
        Glide.with(context).load("http://s2.boohee.cn/house/food_big/big_photo20155149534910631.jpg").into(image);
    }
}
