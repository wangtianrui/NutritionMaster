package com.example.ninefourone.nutritionmaster.utils;

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
        height = height / 100;
        return weight / (height * height);
    }

    /**
     * 根据BMI得到体质情况
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
