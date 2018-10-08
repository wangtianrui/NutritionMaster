package com.example.ninefourone.nutritionmaster;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.example.ninefourone.nutritionmaster.bean.Element;
import com.example.ninefourone.nutritionmaster.bean.FoodMenu;
import com.example.ninefourone.nutritionmaster.bean.Illness;
import com.example.ninefourone.nutritionmaster.bean.MyUser;

import com.example.ninefourone.nutritionmaster.bean.Occupation;
import com.example.ninefourone.nutritionmaster.bean.Physique;
import com.example.ninefourone.nutritionmaster.utils.CalculateUtils;
import com.example.ninefourone.nutritionmaster.utils.ConstantUtils;
import com.example.ninefourone.nutritionmaster.utils.WebUtil;
import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.youdao.sdk.app.YouDaoApplication;
import com.youdao.sdk.chdict.ChDictor;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * Created by ScorpioMiku on 2018/8/26.
 */

public class NutritionMaster extends Application {
    public static NutritionMaster mInstance;
    private int appCount = 0;

    public static MyUser user = null;
    public static Physique physique = null;
    public static Occupation occupation = null;
    public static Element element = null;
    public static Illness illness = null;

    public static Element calculatedElement = null;

    public static int randomSeed = CalculateUtils.getWeek();


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        init();
        initYouDao();
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
        initUser();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                initBD();
            }
        });
        thread.start();

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
        user.setUsername("ScorpioMiku");
    }

    /**
     * 初始化职业常量
     */
    private void initOccupations() {

        WebUtil webUtil = WebUtil.getInstance();
        webUtil.getAllOccupations(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Occupation[] occupations = new Gson().fromJson(response.body().string(), Occupation[].class);
                for (int i = 0; i < occupations.length; i++) {
                    ConstantUtils.occupationList.add(occupations[i].getOccupation_name());
                }
            }
        });

    }


    /**
     * BDAPI init
     */
    private void initBD() {
        ConstantUtils.BD_ACCESS_TOKEN = getAccessToken();
    }


    private String getAccessToken() {
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String ak = ConstantUtils.BD_API_KEY;
        String sk = ConstantUtils.BD_SECRET_KEY;
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.err.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * YD init
     */
    private void initYouDao() {
        YouDaoApplication.init(this, ConstantUtils.YOUDAO_APPKEY);

    }


}
