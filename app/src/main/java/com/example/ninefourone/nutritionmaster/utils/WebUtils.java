package com.example.ninefourone.nutritionmaster.utils;


import android.support.annotation.Nullable;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WebUtils {
    /**
     * 获取菜谱信息
     * {
     * "flavor": "咸鲜味",
     * "calorie": 234,
     * "name": "雪丽对虾",
     * "technology": "炸",
     * "image_url": "http://s1.ig.meishij.net/p/20091012/fed63858e633540c8df73e62692520fb_150x150.jpg",
     * "cook_quantity": [
     * {
     * "menu": "雪丽对虾",
     * "quantity": "500",
     * "material": "对虾"
     * },
     * {
     * "menu": "雪丽对虾",
     * "quantity": "60",
     * "material": "鸡蛋清"
     * },
     * }
     */
    public static void getMenu(String menuName, Callback callback) {
        OkHttpClient mClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://120.77.182.38/menus/" + menuName + "/").build();
        mClient.newCall(request).enqueue(callback);
    }

    /**
     * 获取某食材可以做的菜
     * [
     * {
     * "menu": "西红柿鸡蛋汤",
     * "quantity": "适量",
     * "material": "西红柿"
     * },
     * {
     * "menu": "瘦身版红菜汤",
     * "quantity": "4-5片",
     * "material": "西红柿"
     * },
     * {
     * "menu": "西红柿炖豆腐",
     * "quantity": "三个",
     * "material": "西红柿"
     * },
     * ]
     *
     * @param materialName
     * @param callback
     */
    public static void getFoodMaterial(String materialName, Callback callback) {
        OkHttpClient mClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://120.77.182.38/foodmaterial/" + materialName + "/").build();
        mClient.newCall(request).enqueue(callback);
    }

    /**
     * 获取某菜谱分类对应的菜
     * {
     * "classification": "川菜",
     * "cure_occupation": [],
     * "menu_effect": [
     * "三色鲍脯",
     * "三色鸡酪",
     * "三菇冬瓜汤",
     * "三菌烩蛇段",
     * "三鲜乌鱼汤",
     * "三鲜参片汤",
     * "三鲜猪肝汤",
     * "下饭的素版麻婆豆腐",
     * "丝瓜鱼肚卷",
     * "五更豆酥鱼",
     * "元鱼烧鸡",
     * "冬苋菜豆腐汤",
     * "冬菜排骨汤",
     */
    public static void getMenuClassification(String classificationName, Callback callback) {
        OkHttpClient mClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://120.77.182.38/menuclassification/" + classificationName + "/").build();
        mClient.newCall(request).enqueue(callback);
    }

    /**
     * 获取职业需要的菜谱分类
     * {
     * "occupation_name": "电力工程师",
     * "menuclassification_set": [
     * "接触电离辐射人员食谱",
     * "防癌抗癌食谱",
     * "明目食谱",
     * "关节炎食谱",
     * "壮腰健肾食谱"
     * ]
     * }
     */
    public static void getOccupation(String occupationName, Callback callback) {
        OkHttpClient mClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://120.77.182.38/occupation/" + occupationName + "/").build();
        mClient.newCall(request).enqueue(callback);
    }

    /**
     * 获取体质需要的食材
     * {
     * "physical_name": "气虚质",
     * "cure_material": [
     * "人参",
     * "人参须",
     * "去芯莲子",
     * "去芯莲子（3~4人份）",
     * "土茯苓",
     * ...
     * ]
     * }
     */
    public static void getPhysique(String physiqueName, Callback callback) {
        OkHttpClient mClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://120.77.182.38/physique/" + physiqueName + "/").build();
        mClient.newCall(request).enqueue(callback);
    }

    public static void getUser(String username, Callback callback) {
        OkHttpClient mClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://120.77.182.38/myuser/" + username + "/").build();
        mClient.newCall(request).enqueue(callback);
    }

    /**
     * 注意在回调中处理username重复的情况
     */
    public static void postUser(String username, String password, String sex, @Nullable String occupationName, @Nullable String physicalName, Callback callback) {
        RequestBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .add("sex", sex)
                .add("occupation_name", occupationName == null ? "" : occupationName)
                .add("physical_name", physicalName == null ? "" : physicalName)
                .build();
        Request request = new Request.Builder()
                .url("http://120.77.182.38/myuser/")
                .post(formBody)
                .build();

        OkHttpClient mClient = new OkHttpClient();
        mClient.newCall(request).enqueue(callback);
    }

    public static void changeUserPassword(String username, String password, Callback callback) {
        String url = "http://120.77.182.38/myuser/" + username + "/";
        RequestBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .put(formBody)
                .build();

        OkHttpClient mClient = new OkHttpClient();
        mClient.newCall(request).enqueue(callback);
    }

    public static void changeUserOccupation(String username,String password, String occupation, Callback callback) {
        String url = "http://120.77.182.38/myuser/" + username + "/";
        RequestBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("password",password)
                .add("occupation", occupation)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .put(formBody)
                .build();

        OkHttpClient mClient = new OkHttpClient();
        mClient.newCall(request).enqueue(callback);
    }

    public static void changeUserPhysique(String username,String password, String physique, Callback callback) {
        String url = "http://120.77.182.38/myuser/" + username + "/";
        RequestBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("password",password)
                .add("physique", physique)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .put(formBody)
                .build();

        OkHttpClient mClient = new OkHttpClient();
        mClient.newCall(request).enqueue(callback);
    }


    public static void main(String[] args) {
        /*WebUtils.getMenu("雪丽对虾", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                FoodMenu menu = new Gson().fromJson(response.body().string(), FoodMenu.class);
                System.out.println(menu);
            }
        });*/

       /* WebUtils.getFoodMaterial("西红柿", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                FoodMaterial[] foodMaterialList = new Gson().fromJson(json, FoodMaterial[].class);
                System.out.println(Arrays.toString(foodMaterialList));
            }
        });*/

        /*WebUtils.getMenuClassification("川菜", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                MenuClassification classification = new Gson().fromJson(response.body().string(), MenuClassification.class);
                System.out.println(classification);
            }
        });*/

        /*WebUtils.getOccupation("程序员", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });*/

        /*WebUtils.getPhysique("气虚质", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(new Gson().fromJson(response.body().string(),Physique.class));
            }
        });*/

        /*WebUtils.getUser("okhttptest", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(new Gson().fromJson(response.body().string(),MyUser.class));
            }
        });*/

        WebUtils.changeUserOccupation("updatatest","1234" ,"气虚质", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });
    }
}

