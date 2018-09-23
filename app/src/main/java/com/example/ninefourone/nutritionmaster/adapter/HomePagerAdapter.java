package com.example.ninefourone.nutritionmaster.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.customization.CustomizationFragment;
import com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.bodyinformation.BodyInformationFragment;
import com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.recommend.RecommendFragment;


/**
 * Created by Wangtianrui on 2018/5/1.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {
    private final String[] TITLES;
    private Fragment[] fragments;

    public HomePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        TITLES = context.getResources().getStringArray(R.array.sections);
        fragments = new Fragment[TITLES.length];
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments[position] == null) {
            switch (position) {
                case 0:
                    fragments[position] = CustomizationFragment.getInstance();
                    break;
                case 1:
                    fragments[position] = BodyInformationFragment.getInstance();
                    break;
                case 2:
                    fragments[position] = RecommendFragment.getInstance();
                    break;
                default:
                    break;
            }
        }
        return fragments[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}
