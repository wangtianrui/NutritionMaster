package com.example.ninefourone.nutritionmaster.utils;

import com.example.ninefourone.nutritionmaster.bean.ClassifyResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by ScorpioMiku on 2018/8/26.
 */

public class ConstantUtils {

    public static String[] dailyDescibes = {"快乐陪周一", "幸运伴周二", "轻松有周三", "温馨携周四",
            "愉悦同周五", "休闲找周六", "潇洒属周日"};


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
            "饮用水温度偏向",
            "揭晓结果"
    };

    public static String[][] answerList = new String[][]{
            {"开始吧"},
            {"深红", "偏白", "淡红"},
            {"暗紫", "细红", "不明显"},
            {"口舌干燥", "口黏苔腻", "还算正常"},
            {"沉寂易疲劳", "精力充沛"},
            {"多汗无力、易胖", "多愁善感", "都不"},
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
     * 全国平均身高  index 0 对应 3岁
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


    public static String[] physiquesImageUrls = {
            "https://ws1.sinaimg.cn/large/0067fcixly1fvtqro2rrhj30c90eydgu.jpg",
            "https://ws1.sinaimg.cn/large/0067fcixly1fvtqro060mj30c90go755.jpg",
            "https://ws1.sinaimg.cn/large/0067fcixly1fvtqrnxrnmj30c90go3zp.jpg",
            "https://ws1.sinaimg.cn/large/0067fcixly1fvtqwvxzwjj30c90goaav.jpg",
            "https://ws1.sinaimg.cn/large/0067fcixly1fvtqrnuqb3j30c90goaar.jpg",
            "https://ws1.sinaimg.cn/large/0067fcixly1fvtqrogotyj30c90goq3u.jpg",
            "https://ws1.sinaimg.cn/large/0067fcixly1fvtqrodvjij30b70cvdlq.jpg",
            "https://ws1.sinaimg.cn/large/0067fcixly1fvtqro7ij0j30970dpafy.jpg"
    };

    public static String[] physiquesExpressions = {
            "平素面色晦暗，皮肤偏暗或色素沉着，容易出现瘀斑，易患疼痛，口唇暗淡或紫，舌质暗有点、片状瘀斑，舌下静脉曲张。" +
                    "眼眶暗黑，鼻部暗滞，发易脱落，皮肤发干，或有出血倾向、吐血，女性多见痛经、闭经、或经血中多有血块，或经色紫黑有块。",
            "手足心热，平常容易口燥咽干，鼻微干，口渴喜冷饮，大便干燥，面色潮红、有烘热感，眼睛干涩视物昏花，唇红微干，" +
                    "皮肤偏干、易生皱纹，眩晕耳鸣，睡眠差，小便短涩。",
            "四季怕冷，手足不温，喜热饮食，精神不振，睡眠偏多。面色柔白，目周晦暗，口唇色淡，毛发易落，大便溏稀，小便清长。",
            "面部皮肤油脂较多，多汗且黏，胸闷，痰多，面色淡黄而暗，眼胞微浮，容易困倦，口黏腻或甜，身重不爽，喜食肥甘甜黏，大便正常或不实，小便不多或微混，平素舌体胖大。",
            "平素面垢油光，容易口苦口干，身重困倦,易生痤疮，体偏胖或苍瘦，心烦懈怠，眼目红赤，大便燥结或黏滞，小便短赤，男易阴囊潮湿，女易带下增多等。",
            "性格内向不稳定，忧郁脆弱，敏感多疑，对精神刺激适应能力较差，平常忧郁面貌，神情多烦闷不乐。胸胁胀满，或走窜疼痛，多伴善太息，或嗳气呃逆，或咽间有异物感，或乳房胀痛，睡眠较差，食欲减退，惊悸怔忡，健忘，痰多，大便多干，小便正常。",
            "平常说话语音低怯，气短懒言，容易疲乏，精神不振，易出汗。面色偏黄或晄白，目光少神，唇色少华，毛发不华，容易头晕，记忆力减退，大便不成形，或便后仍觉未尽，小便正常或偏多。",
            "面色、肤色润泽，头发稠密有光泽，目光有神，鼻色明润，嗅觉、味觉良好，唇色红润，不易疲劳，精力充沛，耐受寒热，睡眠良好，食欲好，二便正常。"
    };

    public static String[] physiquesCharacteristics = {
            "瘀血质的人，血行不畅，临床常呈现肤色晦暗、色素沉着、瘀斑、性格抑郁、健忘，舌质紫黯或有瘀点、舌下络脉紫黯或增粗，脉涩。易患痛证、血证、症瘕等。",
            "阴虚质的人，阴液亏少，耐冬不耐夏，临床常呈现口燥咽干、手足心热、喜冷饮、大便干燥，舌红少津，脉细数。一般体形偏瘦，易患虚劳、遗精、失眠等。",
            "阳虚质的人，阳气不足，临床常呈现畏寒怕冷、手足不暖、喜热饮食、精神不振，舌淡胖嫩，脉迟沉。一般性格内向，易患痰饮、肿胀、泄泻等。",
            "痰湿质的人，痰湿凝聚，临床常以形体肥胖、多汗无力、胸闷痰多、腹部肥满、口黏苔腻等痰湿表现为主要特征。",
            "湿热质的人，湿热内蕴，临床常呈现面垢油光、口苦、心烦急躁、口苦口干、身重困倦、大便粘滞不畅或燥结、小便短黄、男性易阴囊潮湿、女性带下增多，易生痤疮，舌质偏红、苔黄腻，脉滑数。",
            "气郁质的人，气机郁滞，临床常呈现精神抑郁、忧虑脆弱、多愁善感、易患脏燥、梅核气、百合病等病症。舌淡红、苔薄白，脉弦。",
            "气虚质的人，元气不足，临床常呈现疲乏气短、自汗懒言、语音低弱、精神不振、肌肉松软不实，舌淡红、边有齿痕，脉虚。易患感冒、内脏下垂、病后康复缓慢等。",
            "平和质的人，阴阳气血调和，体态适中、面色红润、精力充沛、体形匀称健壮、耐受寒热、睡眠良好、患病较少，对自然环境和社会环境适应能力较强。"
    };

    public static String[] physiquesMentalitys = {
            "性情急躁，心情易烦，健忘。",
            "性情急躁，外向好动，活泼。",
            "性格多沉静、内向。",
            "性格偏温和，稳重，恭谦，豁达，多善于忍耐。",
            "性情多急躁易怒。",
            "性格内向不稳定，忧郁脆弱，敏感多疑。",
            "情绪不稳定，胆小，不喜欢冒险。",
            "性格随和开朗。"
    };
    public static String[] physiquesMatters = {
            "瘀血质气机失调，血行不畅，应慎食雪糕、冰淇淋、冰冻饮料等寒凉之品，以免影响气血运行。保持心情舒畅，是淤血质调理的重要环节。",
            "阴虚质体内阴液不足，药膳应慎食辛辣刺激、煎炒爆炸以及羊肉、狗肉等温热之物，以免耗伤阴液。",
            "阳虚质阳气亏虚，药膳应忌生冷寒凉，即使盛夏，也不主张多吃诸如西瓜、梨、苦瓜等寒凉生冷之物，以免损伤阳气。",
            "痰湿质痰湿偏盛，药膳应慎食肥甘油腻、厚味滋补之物，以免助湿生痰。",
            "湿热质体内湿热偏盛，药膳应慎食牛肉、狗肉、鹿肉、辣椒、姜、葱及肥甘厚味之物，以免助湿生热。",
            "气郁质气机不畅，心情抑郁，，应慎食雪糕、冰淇淋、冰冻饮料等寒凉之品，以免影响气血运行。同淤血质一样，保持心情舒畅，也是气郁质调理的重要环节。",
            "气虚质中气不足，脾胃消化功能较弱，药膳应忌过于粘腻、寒凉或难以消化之物，以免食滞难化，影响脾胃功能。",
            "平和质人阴阳气血平衡，药膳调理不可偏补、贪补，以保持人体阴阳平衡状态最为紧要。所谓“不伤不扰，顺其自然”。"
    };

    public static String BD_API_KEY = "GQfoj7AUUhj67ocHuwvA8G5q";
    public static String BD_APP_ID = "14346167";
    public static String BD_SECRET_KEY = "EEXe6pG7QGVdrqDM8eR0S3RY2WPf4Gwn";
    public static String BD_ACCESS_TOKEN = "";

//    public static ArrayList<ClassifyResult> testData = new ArrayList<>();
//
//    static {
//        for (int i = 0; i < 7; i++) {
//            ClassifyResult classifyResult = new ClassifyResult();
//            classifyResult.setName("酱肉丝" + i);
//            classifyResult.setProbability(0.5 + i);
//            classifyResult.setCalorie(274 + i * 10);
//            testData.add(classifyResult);
//        }
//    }

    public static ArrayList<String> dishPicerData = new ArrayList<>();

    static {
        for (int i = 0; i <= 1000; i++) {
            if (i % 2 == 0) {
                dishPicerData.add(i + "");
            }
        }
    }

    public static HashMap<String, String> illnessMap = new HashMap<>();

    static {
        illnessMap.put("补肾", "肾调养食谱");
        illnessMap.put("糖尿病", "糖尿病食谱");
        illnessMap.put("结核病", "结核病食谱");
        illnessMap.put("骨质酥松症", "骨质疏松食谱");
        illnessMap.put("营养不良", "营养不良食谱");
        illnessMap.put("便秘", "便秘食谱");
        illnessMap.put("高血压", "高血压食谱");
        illnessMap.put("消化不良", "消化不良食谱");
        illnessMap.put("神经衰弱", "神经衰弱食谱");
        illnessMap.put("肾炎", "肾炎食谱");
        illnessMap.put("月经不调", "月经不调食谱");
        illnessMap.put("上火", "清热解毒食谱");
        illnessMap.put("贫血", "贫血食谱");
        illnessMap.put("多汗", "自汗盗汗食谱");
        illnessMap.put("咳嗽", "咳喘食谱");
        illnessMap.put("防暑", "防暑食谱");
        illnessMap.put("健忘", "健忘食谱");
        illnessMap.put("耳鸣", "耳鸣食谱");
        illnessMap.put("肺病", "肺调养食谱");
        illnessMap.put("冻疮", "冻疮食谱");
        illnessMap.put("利尿", "利尿食谱");
        illnessMap.put("头疼", "头痛食谱");
        illnessMap.put("口腔溃疡", "口腔溃疡食谱");
        illnessMap.put("祛痱", "祛痱食谱");
        illnessMap.put("感冒", "感冒食谱");
        illnessMap.put("前内腺疾病", "前列腺疾病食谱");
        illnessMap.put("鼻炎", "鼻炎食谱");
        illnessMap.put("跌打骨折", "跌打骨折食谱");
    }

    public static ArrayList<String> getIllness() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String key : illnessMap.keySet()) {
            arrayList.add(key);
        }
        return arrayList;
    }

    public static ArrayList<String> getFlavour() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("苦");
        arrayList.add("甜");
        arrayList.add("咸");
        arrayList.add("辣");
        arrayList.add("酸");
        return arrayList;
    }

    public static String YOUDAO_APPKEY = "3ea8061348a6bdd6";
}
