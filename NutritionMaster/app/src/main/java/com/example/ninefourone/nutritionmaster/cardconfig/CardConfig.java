package com.example.ninefourone.nutritionmaster.cardconfig;

import android.content.Context;
import android.util.TypedValue;

/**
 * 初始化一些配置信息、固定数据
 */
public class CardConfig {
    //屏幕上最多同时显示几个Item
    public static int MAX_SHOW_COUNT;

    //每一级Scale相差0.05f，translationY相差15dp,translationZ相差0.5dp左右
    public static float SCALE_GAP;
    public static int TRANS_Y_GAP;
    public static int TRANS_Z_GAP;

    public static void initConfig(Context context) {
        MAX_SHOW_COUNT = 4;
        SCALE_GAP = 0.05f;
        //这里是把dp转换成px
        TRANS_Y_GAP = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15f, context.getResources().getDisplayMetrics());
        TRANS_Z_GAP = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0.5f, context.getResources().getDisplayMetrics());
    }
}
