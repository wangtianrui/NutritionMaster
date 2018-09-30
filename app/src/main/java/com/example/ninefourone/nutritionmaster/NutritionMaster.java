package com.example.ninefourone.nutritionmaster;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.example.ninefourone.nutritionmaster.bean.MyUser;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;



/**
 * Created by ScorpioMiku on 2018/8/26.
 */

public class NutritionMaster extends Application {
    public static NutritionMaster mInstance;
    private int appCount = 0;

    public static MyUser user;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        init();
        initUser();
    }

    /**
     * 初始化所有基础的东西
     */
    private void init() {
        Logger.addLogAdapter(new AndroidLogAdapter());
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {
                appCount++;
            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {
                appCount--;
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    public static NutritionMaster getInstance() {
        return mInstance;
    }

    /**
     * app是否在前台
     *
     * @return true前台，false后台
     */
    public boolean isForeground() {
        return appCount > 0;
    }


    /**
     * 初始化用户信息
     */
    private void initUser() {
        user = new MyUser();
        user.setNickName("ScorpioMiku");
    }



}
