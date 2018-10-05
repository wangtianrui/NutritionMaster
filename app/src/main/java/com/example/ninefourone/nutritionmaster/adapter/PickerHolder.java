package com.example.ninefourone.nutritionmaster.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ScorpioMiku on 2018/10/5.
 */

public class PickerHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.picker_item)
    TextView pickerItem;

    public PickerHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(String text) {
        pickerItem.setText(text);
    }
}
