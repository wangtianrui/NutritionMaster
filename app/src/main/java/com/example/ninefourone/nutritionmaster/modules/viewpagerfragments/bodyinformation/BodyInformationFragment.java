package com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.bodyinformation;

import android.os.Bundle;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.base.BaseFragment;

/**
 * Created by ScorpioMiku on 2018/8/26.
 */

public class BodyInformationFragment extends BaseFragment {
    @Override
    public int getLayoutResId() {
        return R.layout.body_information_fragment;
    }

    @Override
    public void initView(Bundle state) {

    }


    public static BaseFragment getInstance() {
        return new BodyInformationFragment();
    }
}
