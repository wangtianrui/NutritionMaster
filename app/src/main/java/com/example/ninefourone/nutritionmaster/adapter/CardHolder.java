package com.example.ninefourone.nutritionmaster.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ScorpioMiku on 2018/9/2.
 */

public class CardHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_sign)
    TextView tvSign;



    public CardHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(String text) {
        tvName.setText(text);
    }
}
