package com.example.ninefourone.nutritionmaster.utils;

import java.util.ArrayList;

/**
 * Created by ScorpioMiku on 2018/8/26.
 */

public class ConstantUtils {
    public static String arab2Chinese(int number) {
        switch (number) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "日";
            default:
                return "";
        }
    }


    public static String[] questionList = new String[]{
            "现在先去找个镜子吧" +
                    "\n下面会用到哦",
            "你舌苔的颜色",
            "舌底经络颜色",
            "口腔整体情况",
            "整体生活精神状况",
            "性格特点",
            "食物温度偏向",
            "揭晓结果"
    };

    public static String[][] answerList = new String[][]{
            {"开始吧"},
            {"偏暗红", "偏白", "淡红"},
            {"暗红", "细红", "不明显"},
            {"口舌干燥", "口黏苔腻", "还算正常"},
            {"沉寂易疲劳", "精力充沛"},
            {"内向", "开朗"},
            {"烫的", "冷的", "没有特别喜欢的"},
            {"查看"}
    };
}
