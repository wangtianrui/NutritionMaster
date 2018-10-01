package com.example.ninefourone.nutritionmaster.utils;

import com.orhanobut.logger.Logger;

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
}
