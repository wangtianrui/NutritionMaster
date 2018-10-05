package com.example.ninefourone.nutritionmaster.utils;

import com.example.ninefourone.nutritionmaster.bean.ClassifyResult;
import com.example.ninefourone.nutritionmaster.bean.MyUser;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by ScorpioMiku on 2018/8/29.
 */

public class CalculateUtils {
    /**
     * 计算BMI值  BMI值計算公式:    BMI = 體重(公斤) / 身高2(公尺2)
     *
     * @param height
     * @param weight
     * @return
     */
    public static float BMI(float height, float weight) {
        if (height > 10) {
            height = height / 100.0f;
        }
//        Logger.d(height+"|"+weight / (height * height));
        return weight / (height * height);
    }

    /**
     * 通过身高获得健康的体重
     *
     * @param height
     * @return
     */
    public static float[] standardH2W(float height) {
        if (height > 10) {
            height = height / 100;
        }
        float min;
        float max;
        min = (float) 18.5 * height * height;
        max = (float) 14 * height * height;
        float[] re = {min, max};
        return re;
    }

    /**
     * 根据BMI得到体质情况
     *
     * @param BMI
     * @return
     */
    public static String bodyStatus(float BMI) {
        if (BMI < 18.5) {
            return "轻体重";
        } else if (BMI < 24) {
            return "健康体重";
        } else if (BMI < 27) {
            return "轻度肥胖";
        } else if (BMI < 30) {
            return "中度肥胖";
        } else {
            return "重度肥胖";
        }
    }

    /**
     * 获取星期几
     *
     * @return
     */
    public static int getWeek() {
        Calendar calendar = Calendar.getInstance();
//        Logger.d( calendar.get(Calendar.DAY_OF_WEEK));
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 性别转数字
     * @param sex
     * @return
     */
    public static int sex2int(String sex) {
        if (sex.equals("男")) {
            return 1;
        } else if (sex.equals("女")) {
            return 0;
        } else {
            Logger.e("不男不女");
            return 1;
        }
    }

    /**
     * 计算每个食物吃多少
     *
     * @param classifyResultArrayList
     * @param user
     * @return
     */

    public static ArrayList<ClassifyResult> getDishQuantity(
            ArrayList<ClassifyResult> classifyResultArrayList, MyUser user) {
        double calorieSum = 0;
        double[] calories = new double[classifyResultArrayList.size()];
        double[] quantitys = new double[classifyResultArrayList.size()];
        float baseQuantity = 600f;
        for (int i = 0; i < classifyResultArrayList.size(); i++) {
            calorieSum += classifyResultArrayList.get(i).getCalorie();
            calories[i] = classifyResultArrayList.get(i).getCalorie();
        }
        for (int i = 0; i < classifyResultArrayList.size(); i++) {
            classifyResultArrayList.get(i).setQuantity(calories[i] / calorieSum * baseQuantity);
        }
        return classifyResultArrayList;
    }
}
