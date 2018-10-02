package com.example.ninefourone.nutritionmaster;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.example.ninefourone.nutritionmaster.bean.MyUser;

import com.example.ninefourone.nutritionmaster.bean.Occupation;
import com.example.ninefourone.nutritionmaster.utils.ConstantUtils;
import com.example.ninefourone.nutritionmaster.utils.WebUtils;
import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


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
        initOccupations();
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

    /**
     * 初始化职业常量
     */
    private void initOccupations() {

        WebUtils.getAllOccupations(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Occupation[] occupations = new Gson().fromJson(response.body().string(), Occupation[].class);
//                Logger.d(Arrays.toString(occupations));
                for (int i = 0; i < occupations.length; i++) {
                    ConstantUtils.occupationList.add(occupations[i].getOccupation_name());
                }
            }
        });

    }


}
