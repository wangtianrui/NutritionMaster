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
            "生活中的小问题",
            "食物温度偏向",
            "揭晓结果"
    };

    public static String[][] answerList = new String[][]{
            {"开始吧"},
            {"深红", "偏白", "淡红"},
            {"暗紫", "细红", "不明显"},
            {"口舌干燥", "口黏苔腻", "还算正常"},
            {"沉寂易疲劳", "精力充沛"},
            {"多汗无力", "多愁善感", "都不"},
            {"烫的", "冷的", "没有特别喜欢的"},
            {"查看"}
    };

    public static ArrayList<String> occupationList = new ArrayList<>();

    public static ArrayList<String> ageList = new ArrayList<>();

    public static ArrayList<String> sexList = new ArrayList<>();

    public static ArrayList<String> heightList = new ArrayList<>();

    public static ArrayList<String> weightList = new ArrayList<>();

    static {
        for (int i = 1; i <= 200; i++) {
            if (i < 100) {
                ageList.add(i + "岁");
            }
            heightList.add(i + 50 + "cm");
            if (i < 150) {
                weightList.add(i + "kg");
            }
        }
        sexList.add("男");
        sexList.add("女");
    }

    /**
     * 全国平均体重  index 0 对应 3岁
     */
    public static ArrayList<Float> averageBoyHeight = new ArrayList<>();

    public static ArrayList<Float> averageGirlHeight = new ArrayList<>();

    static {
        averageBoyHeight.add(new Float(102.2));
        averageBoyHeight.add(new Float(107.8));
        averageBoyHeight.add(new Float(114));
        averageBoyHeight.add(new Float(119.7));
        averageBoyHeight.add(new Float(126.6));
        averageBoyHeight.add(new Float(132));
        averageBoyHeight.add(new Float(137.2));
        averageBoyHeight.add(new Float(142.1));
        averageBoyHeight.add(new Float(148.1));
        averageBoyHeight.add(new Float(154.5));
        averageBoyHeight.add(new Float(161.4));
        averageBoyHeight.add(new Float(166.5));
        averageBoyHeight.add(new Float(169.8));
        averageBoyHeight.add(new Float(171.4));
        averageBoyHeight.add(new Float(172.1));
        averageBoyHeight.add(new Float(172));
        averageBoyHeight.add(new Float(172.4));  //index 16  age 19

        averageBoyHeight.add(new Float(171.9));
        averageBoyHeight.add(new Float(171.6));
        averageBoyHeight.add(new Float(170.8));
        averageBoyHeight.add(new Float(169.9));
        averageBoyHeight.add(new Float(169));
        averageBoyHeight.add(new Float(168.7));
        averageBoyHeight.add(new Float(168.3));
        averageBoyHeight.add(new Float(167.5));


        averageGirlHeight.add(new Float(100.9));
        averageGirlHeight.add(new Float(106.5));
        averageGirlHeight.add(new Float(112.7));
        averageGirlHeight.add(new Float(118.1));
        averageGirlHeight.add(new Float(125.1));
        averageGirlHeight.add(new Float(130.5));
        averageGirlHeight.add(new Float(136.3));
        averageGirlHeight.add(new Float(142.6));
        averageGirlHeight.add(new Float(149.3));
        averageGirlHeight.add(new Float(153.7));
        averageGirlHeight.add(new Float(157));
        averageGirlHeight.add(new Float(158.7));
        averageGirlHeight.add(new Float(159.4));
        averageGirlHeight.add(new Float(159.8));
        averageGirlHeight.add(new Float(159.9));
        averageGirlHeight.add(new Float(159.4));
        averageGirlHeight.add(new Float(160.4));//index 16  age 19


        averageGirlHeight.add(new Float(159.9));//index 17 age 24
        averageGirlHeight.add(new Float(159.6));
        averageGirlHeight.add(new Float(159.1));
        averageGirlHeight.add(new Float(158.5));
        averageGirlHeight.add(new Float(157.8));
        averageGirlHeight.add(new Float(157.7));
        averageGirlHeight.add(new Float(157.7));// index 23 age 54
        averageGirlHeight.add(new Float(156.8)); //index 24 age 59

    }

    /**
     * 全国平均体重
     */
    public static ArrayList<Float> averageBoyWeight = new ArrayList<>();
    public static ArrayList<Float> averageGirlWeight = new ArrayList<>();

    static {
        averageBoyWeight.add(new Float(16.6));
        averageBoyWeight.add(new Float(18.3));
        averageBoyWeight.add(new Float(20.6));
        averageBoyWeight.add(new Float(23));
        averageBoyWeight.add(new Float(26.6));
        averageBoyWeight.add(new Float(29.9));
        averageBoyWeight.add(new Float(33.6));
        averageBoyWeight.add(new Float(37.2));
        averageBoyWeight.add(new Float(41.9));
        averageBoyWeight.add(new Float(16.6));
        averageBoyWeight.add(new Float(52));
        averageBoyWeight.add(new Float(56.2));
        averageBoyWeight.add(new Float(59.5));
        averageBoyWeight.add(new Float(61.5));
        averageBoyWeight.add(new Float(63.3));
        averageBoyWeight.add(new Float(63.5));
        averageBoyWeight.add(new Float(63.5));

        averageBoyWeight.add(new Float(67.2));
        averageBoyWeight.add(new Float(70.4));
        averageBoyWeight.add(new Float(71.4));
        averageBoyWeight.add(new Float(71.5));
        averageBoyWeight.add(new Float(71.2));
        averageBoyWeight.add(new Float(71.2));
        averageBoyWeight.add(new Float(10.6));
        averageBoyWeight.add(new Float(69.1));


        averageGirlWeight.add(new Float(15.9));
        averageGirlWeight.add(new Float(17.5));
        averageGirlWeight.add(new Float(19.6));
        averageGirlWeight.add(new Float(21.6));
        averageGirlWeight.add(new Float(24.7));
        averageGirlWeight.add(new Float(27.6));
        averageGirlWeight.add(new Float(31.3));
        averageGirlWeight.add(new Float(35.5));
        averageGirlWeight.add(new Float(40.6));
        averageGirlWeight.add(new Float(44.5));
        averageGirlWeight.add(new Float(18));
        averageGirlWeight.add(new Float(50.4));
        averageGirlWeight.add(new Float(51.6));
        averageGirlWeight.add(new Float(52.7));
        averageGirlWeight.add(new Float(53));
        averageGirlWeight.add(new Float(52.6));
        averageGirlWeight.add(new Float(52.4));

        averageGirlWeight.add(new Float(53.8));
        averageGirlWeight.add(new Float(55.3));
        averageGirlWeight.add(new Float(56.8));
        averageGirlWeight.add(new Float(57.8));
        averageGirlWeight.add(new Float(59));
        averageGirlWeight.add(new Float(59.7));
        averageGirlWeight.add(new Float(60.4));
        averageGirlWeight.add(new Float(59.6));

    }

}
