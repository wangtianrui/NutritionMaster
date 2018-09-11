package com.example.ninefourone.nutritionmaster.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ScorpioMiku on 2018/9/9.
 */

public class MakeStepHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.make_step_text_view)
    TextView makeStepTextView;

    public MakeStepHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindView(String text) {
        makeStepTextView.setText(text);
    }
}
