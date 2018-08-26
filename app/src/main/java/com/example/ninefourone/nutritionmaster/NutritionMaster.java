package com.example.ninefourone.nutritionmaster;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


/**
 * Created by ScorpioMiku on 2018/8/26.
 */

public class NutritionMaster extends Application {
    public static NutritionMaster mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        init();
    }

    /**
     * 初始化所有基础的东西
     */
    private void init() {
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("Logger初始化成功");
    }

    public static NutritionMaster getInstance() {
        return mInstance;
    }
}
