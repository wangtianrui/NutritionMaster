package com.example.ninefourone.nutritionmaster.bean;

import com.example.ninefourone.nutritionmaster.utils.MessageUtils;
import com.example.ninefourone.nutritionmaster.utils.WebUtil;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by ScorpioMiku on 2018/10/7.
 */

public class Material implements Serializable {
    FoodMaterial foodMaterial;
    ArrayList<FoodMenu> menus = new ArrayList<>();

    public FoodMaterial getFoodMaterial() {
        return foodMaterial;
    }

    public void setFoodMaterial(FoodMaterial foodMaterial) {
        this.foodMaterial = foodMaterial;
        try {
            int max = foodMaterial.getCook_quantity().size() > 30 ? 30 : foodMaterial.getCook_quantity().size();
            for (int i = 0; i < max; i++) {
                WebUtil webUtil = WebUtil.getInstance();
                FoodMaterial.CookQuantityBean temp = foodMaterial.getCook_quantity().get(i);
                String menuName = temp.getMenu();
                webUtil.getMenu(menuName, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String json = response.body().string();
                        try {
                            FoodMenu menu = new Gson().fromJson(json, FoodMenu.class);
                            if (!menu.getImage_url().equals("0")) {
                                menus.add(menu);
//                            Logger.d(menu);
                            }
                        }catch (Exception e){
//                        Logger.e(json);
                            e.printStackTrace();
                        }

                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
//            MessageUtils.MakeToast("您当前拍摄的食材没有录入服务器");
        }
    }

    public ArrayList<FoodMenu> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<FoodMenu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return foodMaterial.toString() + "\nsize:" + menus.size();
    }

    private void addMenu(final int index, final int max) {
        WebUtil webUtil = WebUtil.getInstance();
        FoodMaterial.CookQuantityBean temp = foodMaterial.getCook_quantity().get(index);
        String menuName = temp.getMenu();
        Logger.d(menuName);
        webUtil.getMenu(menuName, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Logger.d(response.body().string());
                FoodMenu menu = new Gson().fromJson(response.body().string(), FoodMenu.class);
                menus.add(menu);
                if (index < max) {
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            addMenu(index + 1, max);
                        }
                    });
                    thread.start();
                }
            }
        });
    }
}
