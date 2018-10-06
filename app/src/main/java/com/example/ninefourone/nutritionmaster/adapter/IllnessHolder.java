package com.example.ninefourone.nutritionmaster.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ScorpioMiku on 2018/10/6.
 */

public class IllnessHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text)
    TextView text;

    public IllnessHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
