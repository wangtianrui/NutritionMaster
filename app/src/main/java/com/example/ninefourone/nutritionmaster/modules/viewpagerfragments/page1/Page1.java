package com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.page1;

import android.os.Bundle;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.base.BaseFragment;

/**
 * Created by ScorpioMiku on 2018/8/26.
 */

public class Page1 extends BaseFragment {
    @Override
    public int getLayoutResId() {
        return R.layout.page_1;
    }

    @Override
    public void initView(Bundle state) {

    }


    public static BaseFragment getInstance() {
        return new Page1();
    }
}
