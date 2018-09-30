package com.example.ninefourone.nutritionmaster.modules.viewpagerfragments.bodyinformation;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.base.BaseFragment;
import com.example.ninefourone.nutritionmaster.utils.ChartDrawer;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.today.step.lib.ISportStepInterface;
import com.today.step.lib.TodayStepManager;
import com.today.step.lib.TodayStepService;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.itangqi.waveloadingview.WaveLoadingView;

/**
 * Created by ScorpioMiku on 2018/8/26.
 */

public class BodyInformationFragment extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.step_text_view)
    TextView stepTextView;
    @BindView(R.id.waveLoadingView)
    WaveLoadingView waveLoadingView;
    @BindView(R.id.weight_line_chart)
    LineChart weightLineChart;
    @BindView(R.id.step_line_chart)
    LineChart stepLineChart;

    private int stepCount = 0;
    private static final int REFRESH_STEP_WHAT = 0;

    //循环取当前时刻的步数中间的间隔时间
    private long TIME_INTERVAL_REFRESH = 500;

    private Handler mDelayHandler = new Handler(new TodayStepCounterCall());

    private ISportStepInterface iSportStepInterface;

    private ServiceConnection coon;


    @Override
    public int getLayoutResId() {
        return R.layout.body_information_fragment;
    }

    @Override
    public void initView(Bundle state) {
        initStepCounter();
        initChart();
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

    /**
     * 计步器初始化
     */
    private void initStepCounter() {
        TodayStepManager.init(getActivity().getApplication());
        //开启计步
        Intent stepCounterStart = new Intent(getActivity(), TodayStepService.class);
        getActivity().startService(stepCounterStart);
        coon = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                iSportStepInterface = ISportStepInterface.Stub.asInterface(service);
                try {
                    stepCount = iSportStepInterface.getCurrentTimeSportStep();
                    updateStepCount();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                mDelayHandler.sendEmptyMessageDelayed(REFRESH_STEP_WHAT, TIME_INTERVAL_REFRESH);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
        getActivity().bindService(stepCounterStart, coon, Context.BIND_AUTO_CREATE);
    }

    /**
     * 改变记步UI中的数字
     */
    private void updateStepCount() {
        stepTextView.setText(stepCount + "");
    }


    /**
     * 定时器，修改UI
     */
    class TodayStepCounterCall implements Handler.Callback {

        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case REFRESH_STEP_WHAT: {
                    //每隔500毫秒获取一次计步数据刷新UI
                    if (null != iSportStepInterface) {
                        int step = 0;
                        try {
                            step = iSportStepInterface.getCurrentTimeSportStep();
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        if (stepCount != step) {
                            stepCount = step;
                            updateStepCount();
                        }
                    }
                    mDelayHandler.sendEmptyMessageDelayed(REFRESH_STEP_WHAT, TIME_INTERVAL_REFRESH);
                    break;
                }
            }
            return false;
        }
    }


    /**
     * 初始化表格
     */
    private void initChart() {
        ArrayList<Entry> weightPointValues = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            int y = (int) (Math.random() * 20);
            weightPointValues.add(new Entry(i, y));
        }
        ChartDrawer.initSingleLineChart(weightLineChart, weightPointValues, "体重");

        ArrayList<Entry> stepPointValues = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            int y = (int) (Math.random() * 20);
            stepPointValues.add(new Entry(i, y));
        }
        ChartDrawer.initSingleLineChart(stepLineChart, stepPointValues, "步数");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        getActivity().unbindService(coon);
    }
}
