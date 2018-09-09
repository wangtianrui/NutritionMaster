package com.example.ninefourone.nutritionmaster.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.R;

import butterknife.BindView;

/**
 * Created by ScorpioMiku on 2018/9/9.
 */

public class MenuHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.text)
    TextView textView;

    public MenuHolder(View itemView) {
        super(itemView);

    }

    public void bindView(String text) {
        textView.setText(text);
    }
}
