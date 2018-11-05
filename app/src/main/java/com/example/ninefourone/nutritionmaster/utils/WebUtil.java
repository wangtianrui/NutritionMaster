package com.example.ninefourone.nutritionmaster.utils;

import com.example.ninefourone.nutritionmaster.bean.FoodMenuLight;
import com.example.ninefourone.nutritionmaster.bean.MyUser;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WebUtil {
    private static WebUtil instance = new WebUtil();
    private OkHttpClient mClient = new OkHttpClient();

    private WebUtil() {
    }

    public static WebUtil getInstance() {
        return instance;
    }

    /**
     * 获取具体的菜谱信息
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
    public void getMenu(String menuName, Callback callback) {
        Request request = new Request.Builder().url("http://120.77.182.38/menus/" + menuName + "/").build();
        mClient.newCall(request).enqueue(callback);
    }


    /**
     * 获取count个随机菜谱,在回调中解析为一个Menu数组
     *
     * @param count
     * @param callback
     */
    public void getRandomMenus(int count, Callback callback) {
        Request request = new Request.Builder().url("http://120.77.182.38/menus/get_random_menus/?count=" + String.valueOf(count)).build();
        mClient.newCall(request).enqueue(callback);
    }

    /**
     * 随机获取一定数量的小知识
     *
     * @param count
     * @param callback
     */
    public void getRandomTricks(int count, Callback callback) {
        Request request = new Request.Builder().url("http://120.77.182.38/trick/get_random_tricks/?count=" + String.valueOf(count)).build();
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
    public void getFoodMaterial(String materialName, Callback callback) {
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
    public void getMenuClassification(String classificationName, Callback callback) {
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
    public void getOccupation(String occupationName, Callback callback) {
        Request request = new Request.Builder().url("http://120.77.182.38/occupation/" + occupationName + "/").build();
        mClient.newCall(request).enqueue(callback);
    }
    public static void getAllOccupations(Callback callback) {
        OkHttpClient mClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://120.77.182.38/occupation/").build();
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
    public void getPhysique(String physiqueName, Callback callback) {
        Request request = new Request.Builder().url("http://120.77.182.38/physique/" + physiqueName + "/").build();
        mClient.newCall(request).enqueue(callback);
    }

    /**
     * 获取病相关的菜谱和元素信息
     * 传入含有病的意义的菜谱分类名称,比如青少年食谱
     * <p>
     * {
     * "menu_classification": {
     * "classification": "青少年食谱",
     * "cure_occupation": [
     * "学生"
     * ],
     * "menu_effect": [
     * "三鲜鳝汤",
     * "上海糖醋小排骨",
     * ...
     * ]
     * },
     * "elements": {
     * "id": 84,
     * "calorie": 1.1,
     * ...
     * }
     * }
     */
    public void getIllness(String illnessClassification, Callback callback) {
        Request request = new Request.Builder().url("http://120.77.182.38/illness/" + illnessClassification + "/").build();
        mClient.newCall(request).enqueue(callback);
    }

    public void getUser(String username, Callback callback) {
        mClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://120.77.182.38/myuser/" + username + "/").build();
        mClient.newCall(request).enqueue(callback);
    }

    /**
     * 注意在回调中处理username重复的情况
     *//*
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
    }*/

    /*public static void changeUserPassword(String username, String password, Callback callback) {
        String url = "http://120.77.182.38/myuser/" + username + "/";
        RequestBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .patch(formBody)
                .build();

        OkHttpClient mClient = new OkHttpClient();
        mClient.newCall(request).enqueue(callback);
    }

    *//**
     * 修改职业
     * 传入职业名称参数
     *//*
    public static void changeUserOccupation(String username, String occupation, Callback callback) {
        String url = "http://120.77.182.38/myuser/" + username + "/";
        RequestBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("occupation", occupation)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .patch(formBody)
                .build();

        OkHttpClient mClient = new OkHttpClient();
        mClient.newCall(request).enqueue(callback);
    }

    *//**
     * 修改体质
     *
     * @param physique 体质名称
     *//*
    public static void changeUserPhysique(String username, String physique, Callback callback) {
        String url = "http://120.77.182.38/myuser/" + username + "/";
        RequestBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("physique", physique)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .patch(formBody)
                .build();

        OkHttpClient mClient = new OkHttpClient();
        mClient.newCall(request).enqueue(callback);
    }

    */

    /**
     * public static void changeUserIllness(String username, String[] illnesses, Callback callback) {
     * String url = "http://120.77.182.38/myuser/" + username + "/";
     * <p>
     * FormBody.Builder builder = new FormBody.Builder();
     * for (String illness : illnesses) {
     * builder.add("illness", illness);
     * }
     * RequestBody formBody = builder.build();
     * <p>
     * Request request = new Request.Builder()
     * .url(url)
     * .patch(formBody)
     * .build();
     * <p>
     * OkHttpClient mClient = new OkHttpClient();
     * mClient.newCall(request).enqueue(callback);
     * }
     */
    private static RequestBody buildUserRequestBody(MyUser user) {
        try {
            FormBody.Builder builder = new FormBody.Builder();

            Class<?> c = Class.forName("model.MyUser");
            Field[] fields = c.getDeclaredFields();
            for (Field f : fields) {
                String fieldName = f.toString().substring(f.toString().lastIndexOf(".") + 1);
                f.setAccessible(true);
                Object object = f.get(user);//获取属性的值
                if (object != null) {
                    //illness属性是一个list,需要加入每个list的值,而不是list对象
                    if (fieldName.equals("illness")) {
                        List<String> illnessList = (List<String>) object;
                        for (String ill : illnessList) {
                            builder.add("illness", ill);
                        }
                    } else {
                        builder.add(fieldName, String.valueOf(object));
                    }

                }
            }
            RequestBody formBody = builder.build();
//            for (int i = 0; i < ((FormBody) formBody).size(); i++) {
//                System.out.println(((FormBody) formBody).name(i) + " : " + ((FormBody) formBody).value(i));
//            }
            return formBody;


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 注册用户注意username必须要有
     *
     * @param user
     */
    public void createUser(MyUser user, Callback callback) {
        String url = "http://120.77.182.38/myuser/";
        RequestBody formBody = buildUserRequestBody(user);
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        mClient.newCall(request).enqueue(callback);
    }

    /**
     * 把user要更新的信息传入, 注意username必须要有
     *
     * @param user
     */
    public void changeUserInfo(MyUser user, Callback callback) {
        String url = "http://120.77.182.38/myuser/" + user.getUsername() + "/";
        RequestBody formBody = buildUserRequestBody(user);
        Request request = new Request.Builder()
                .url(url)
                .patch(formBody)
                .build();

        mClient.newCall(request).enqueue(callback);
    }

    /**
     * 用户吃了一个菜,更新用户本周已吃摄入的营养元素的量
     * 返回当前user的最新信息,用MyUser类解析json
     *
     * @param username
     * @param menuName
     */
    public void eatenMenu(String username, String menuName, Callback callback) {
        String url = "http://120.77.182.38/myuser/eaten_menu/";
        RequestBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("menu_name", menuName)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        mClient.newCall(request).enqueue(callback);
    }

    /**
     * 返回符合元素信息的menus
     *
     * @param elements
     */
    public void getMenusByElements(Map<String, Double> elements, Callback callback) {
        String url = "http://120.77.182.38/menus/get_menus_by_elements/";
        FormBody.Builder builder = new FormBody.Builder();
        //构造RequestBody参数
        for (Map.Entry<String, Double> entry : elements.entrySet()) {
            String key = entry.getKey();
            double value = entry.getValue();
            builder.add(key, String.valueOf(value));
        }
        RequestBody formBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        mClient.newCall(request).enqueue(callback);
    }
//
//    public static String HttpPost(String requestUrl, String accessToken, String params) throws Exception {
//        System.out.println(params);
//        String generalUrl = "";
//        generalUrl = requestUrl + "?access_token=" + accessToken;
//        System.out.println("发送的连接为:" + generalUrl);
//        URL url = new URL(generalUrl);
//        // 打开和URL之间的连接
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        System.out.println("打开链接，开始发送请求" + new Date().getTime() / 1000);
//        connection.setRequestMethod("POST");
//        // 设置通用的请求属性
//        connection.setRequestProperty("Content-Type", "application/json");
//        connection.setRequestProperty("Connection", "Keep-Alive");
//        connection.setUseCaches(false);
//        connection.setDoOutput(true);
//        connection.setDoInput(true);
//
//        // 得到请求的输出流对象
//        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
//        out.writeBytes(params);
//        out.flush();
//        out.close();
//
//        // 建立实际的连接
//        connection.connect();
//        // 获取所有响应头字段
//        Map<String, List<String>> headers = connection.getHeaderFields();
//        // 遍历所有的响应头字段
//        for (String key : headers.keySet()) {
//            System.out.println(key + "--->" + headers.get(key));
//        }
//        // 定义 BufferedReader输入流来读取URL的响应
//        BufferedReader in = null;
//        if (requestUrl.contains("nlp"))
//            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
//        else
//            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
//        String result = "";
//        String getLine;
//        while ((getLine = in.readLine()) != null) {
//            result += getLine;
//        }
//        in.close();
//        System.out.println("请求结束" + new Date().getTime() / 1000);
//        System.out.println("result:" + result);
//        return result;
//    }

    public static String HttpPost(String requestUrl, String accessToken, String params) throws Exception {
        System.out.println(params);
        String generalUrl = "";
        generalUrl = requestUrl + "?access_token=" + accessToken;
        System.out.println("发送的连接为:" + generalUrl);
        URL url = new URL(generalUrl);
        // 打开和URL之间的连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        System.out.println("打开链接，开始发送请求" + new Date().getTime() / 1000);
        connection.setRequestMethod("POST");
        // 设置通用的请求属性
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setUseCaches(false);
        connection.setDoOutput(true);
        connection.setDoInput(true);

        // 得到请求的输出流对象
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeBytes(params);
        out.flush();
        out.close();

        // 建立实际的连接
        connection.connect();
        // 获取所有响应头字段
        Map<String, List<String>> headers = connection.getHeaderFields();
        // 遍历所有的响应头字段
        for (String key : headers.keySet()) {
            System.out.println(key + "--->" + headers.get(key));
        }
        // 定义 BufferedReader输入流来读取URL的响应
        BufferedReader in = null;
        if (requestUrl.contains("nlp"))
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "GBK"));
        else
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String result = "";
        String getLine;
        while ((getLine = in.readLine()) != null) {
            result += getLine;
        }
        in.close();
        System.out.println("请求结束" + new Date().getTime() / 1000);
        System.out.println("result:" + result);
        return result;
    }
    public static void main(String[] args) {
        Map<String, Double> params = new HashMap<>();
        params.put("calorie", 100.0);
        params.put("fat", 10.0);
        WebUtil.getInstance().getMenusByElements(params, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                System.out.println(json);
                //轻量级的Menu,只有Menu的名字,卡路里,元素对象的主码id.想获取详细信息可以用getMenu方法获取
                //这样是为了查询更快
                FoodMenuLight[] foodMenuLights = new Gson().fromJson(json, FoodMenuLight[].class);
                System.out.println(Arrays.toString(foodMenuLights));
            }
        });


/*
        MyUser testUser = new MyUser();
        testUser.setUsername("test6");
        testUser.setPassword("66666");
        testUser.setAge(8);
        testUser.setHeight(175);
        testUser.setPhysical_name("平和质");
        List<String> ills = new ArrayList<>();
        ills.add("乌发食谱");
        ills.add("失眠食谱");
        testUser.setIllness(ills);

        //创建用户
        WebUtil.getInstance().createUser(testUser, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseJson = response.body().string();
                System.out.println(new Gson().fromJson(responseJson, MyUser.class));
            }
        });

        //修改用户信息
        WebUtil.getInstance().changeUserInfo(testUser, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(new Gson().fromJson(response.body().string(), MyUser.class));
            }
        });*/



       /*WebUtil.getInstance().eatenMenu("test5", "软熘虾片", new Callback() {
           @Override
           public void onFailure(Call call, IOException e) {

           }

           @Override
           public void onResponse(Call call, Response response) throws IOException {
               String responseJson = response.body().string();
               System.out.println(responseJson);
               MyUser testUser = new Gson().fromJson(responseJson, MyUser.class);
               System.out.println(testUser);
           }
       });*/

        /*WebUtil.getIllness("青少年食谱", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(new Gson().fromJson(response.body().string(),Illness.class));
            }
        });*/


       /* WebUtil.getMenu("雪丽对虾", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                FoodMenu menu = new Gson().fromJson(response.body().string(), FoodMenu.class);
                System.out.println(menu);
            }
        });*/

        /*WebUtil.getRandomMenus(10, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                FoodMenu[] menus = new Gson().fromJson(response.body().string(), FoodMenu[].class);
                System.out.println(Arrays.toString(menus));
                System.out.println(menus.length);

            }
        });*/

       /*WebUtil.getFoodMaterial("西红柿", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                FoodMaterial foodMaterial = new Gson().fromJson(json, FoodMaterial.class);
                System.out.println(foodMaterial);
            }
        });*/

        /*WebUtil.getMenuClassification("川菜", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                MenuClassification classification = new Gson().fromJson(response.body().string(), MenuClassification.class);
                System.out.println(classification);
            }
        });*/

        /*WebUtil.getOccupation("程序员", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                System.out.println(new Gson().fromJson(json, Occupation.class));

            }
        });*/

        /*WebUtil.getPhysique("气虚质", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(new Gson().fromJson(response.body().string(), Physique.class));
            }
        });*/

        /*WebUtil.instance.getUser("test5", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(new Gson().fromJson(response.body().string(), MyUser.class));
            }
        });
*/

       /* WebUtil.getRandomTricks(10, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.body().string());
            }
        });*/

        /*
         * MyUser testUser = new MyUser(); testUser.setUsername("test6");
         * testUser.setPassword("66666"); testUser.setAge(8); testUser.setHeight(175);
         * testUser.setPhysical_name("平和质"); List<String> ills = new ArrayList<>();
         * ills.add("乌发食谱"); ills.add("失眠食谱"); testUser.setIllness(ills);
         * 
         * //创建用户 WebUtil.getInstance().createUser(testUser, new Callback() {
         * 
         * @Override public void onFailure(Call call, IOException e) {
         * 
         * }
         * 
         * @Override public void onResponse(Call call, Response response) throws
         * IOException { String responseJson = response.body().string();
         * System.out.println(new Gson().fromJson(responseJson, MyUser.class)); } });
         * 
         * //修改用户信息 WebUtil.getInstance().changeUserInfo(testUser, new Callback() {
         * 
         * @Override public void onFailure(Call call, IOException e) {
         * 
         * }
         * 
         * @Override public void onResponse(Call call, Response response) throws
         * IOException { System.out.println(new
         * Gson().fromJson(response.body().string(), MyUser.class)); } });
         */

        /*
         * WebUtil.getInstance().eatenMenu("test5", "软熘虾片", new Callback() {
         * 
         * @Override public void onFailure(Call call, IOException e) {
         * 
         * }
         * 
         * @Override public void onResponse(Call call, Response response) throws
         * IOException { String responseJson = response.body().string();
         * System.out.println(responseJson); MyUser testUser = new
         * Gson().fromJson(responseJson, MyUser.class); System.out.println(testUser); }
         * });
         */

        /*
         * WebUtil.getIllness("青少年食谱", new Callback() {
         * 
         * @Override public void onFailure(Call call, IOException e) {
         * 
         * }
         * 
         * @Override public void onResponse(Call call, Response response) throws
         * IOException { System.out.println(new
         * Gson().fromJson(response.body().string(),Illness.class)); } });
         */

        /*
         * WebUtil.getMenu("雪丽对虾", new Callback() {
         * 
         * @Override public void onFailure(Call call, IOException e) {
         * 
         * }
         * 
         * @Override public void onResponse(Call call, Response response) throws
         * IOException { FoodMenu menu = new Gson().fromJson(response.body().string(),
         * FoodMenu.class); System.out.println(menu); } });
         */

        /*
         * WebUtil.getRandomMenus(10, new Callback() {
         * 
         * @Override public void onFailure(Call call, IOException e) {
         * 
         * }
         * 
         * @Override public void onResponse(Call call, Response response) throws
         * IOException { FoodMenu[] menus = new
         * Gson().fromJson(response.body().string(), FoodMenu[].class);
         * System.out.println(Arrays.toString(menus)); System.out.println(menus.length);
         * 
         * } });
         */


        /*
         * WebUtil.getFoodMaterial("西红柿", new Callback() {
         * 
         * @Override public void onFailure(Call call, IOException e) {
         * 
         * }
         * 
         * @Override public void onResponse(Call call, Response response) throws
         * IOException { String json = response.body().string(); FoodMaterial
         * foodMaterial = new Gson().fromJson(json, FoodMaterial.class);
         * System.out.println(foodMaterial); } });
         */

        /*
         * WebUtil.getMenuClassification("川菜", new Callback() {
         * 
         * @Override public void onFailure(Call call, IOException e) {
         * 
         * }
         * 
         * @Override public void onResponse(Call call, Response response) throws
         * IOException { MenuClassification classification = new
         * Gson().fromJson(response.body().string(), MenuClassification.class);
         * System.out.println(classification); } });
         */

        /*
         * WebUtil.getOccupation("程序员", new Callback() {
         * 
         * @Override public void onFailure(Call call, IOException e) {
         * 
         * }
         * 
         * @Override public void onResponse(Call call, Response response) throws
         * IOException { String json = response.body().string(); System.out.println(new
         * Gson().fromJson(json, Occupation.class));
         * 
         * } });
         */

        /*
         * WebUtil.getPhysique("气虚质", new Callback() {
         * 
         * @Override public void onFailure(Call call, IOException e) {
         * 
         * }
         * 
         * @Override public void onResponse(Call call, Response response) throws
         * IOException { System.out.println(new
         * Gson().fromJson(response.body().string(), Physique.class)); } });
         */

        /*
         * WebUtil.instance.getUser("test5", new Callback() {
         * 
         * @Override public void onFailure(Call call, IOException e) {
         * 
         * }
         * 
         * @Override public void onResponse(Call call, Response response) throws
         * IOException { System.out.println(new
         * Gson().fromJson(response.body().string(), MyUser.class)); } });
         */

        /*
         * WebUtil.getRandomTricks(10, new Callback() {
         * 
         * @Override public void onFailure(Call call, IOException e) {
         * 
         * }
         * 
         * @Override public void onResponse(Call call, Response response) throws
         * IOException { System.out.println(response.body().string()); } });
         */

    }
}
