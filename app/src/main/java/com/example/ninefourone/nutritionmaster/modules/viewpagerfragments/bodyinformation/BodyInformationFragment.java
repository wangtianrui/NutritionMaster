package com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.bodyinformation;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akexorcist.roundcornerprogressbar.IconRoundCornerProgressBar;
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.base.BaseFragment;
import com.gelitenight.waveview.library.WaveView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ScorpioMiku on 2018/8/26.
 */

public class BodyInformationFragment extends BaseFragment {

    @BindView(R.id.progress_1)
    RoundCornerProgressBar progress1;
    @BindView(R.id.progress_2)
    IconRoundCornerProgressBar progress2;
    Unbinder unbinder;
    @BindView(R.id.wave_view)
    WaveView waveView;

    @Override
    public int getLayoutResId() {
        return R.layout.body_information_fragment;
    }

    @Override
    public void initView(Bundle state) {
        progress1.setProgressColor(Color.parseColor("#ed3b27"));
        progress1.setProgressBackgroundColor(Color.parseColor("#808080"));
        progress1.setMax(70);
        progress1.setProgress(15);

        int progressColor1 = progress1.getProgressColor();
        int backgroundColor1 = progress1.getProgressBackgroundColor();
        int max1 = (int) progress1.getMax();
        int progress_1 = (int) progress1.getProgress();


        progress2.setProgressColor(Color.parseColor("#56d2c2"));
        progress2.setProgressBackgroundColor(Color.parseColor("#757575"));
        progress2.setIconBackgroundColor(Color.parseColor("#38c0ae"));
        progress2.setMax(550);
        progress2.setProgress(147);
        progress2.setIconImageResource(R.drawable.test_avatar);

        int progressColor2 = progress2.getProgressColor();
        int backgroundColor2 = progress2.getProgressBackgroundColor();
        int headerColor2 = progress2.getColorIconBackground();
        int max2 = (int) progress2.getMax();
        int progress_2 = (int) progress2.getProgress();

        waveView.setShapeType(WaveView.ShapeType.CIRCLE);
    }


    public static BaseFragment getInstance() {
        return new BodyInformationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
