package com.example.ninefourone.nutritionmaster.bean;

import java.util.List;

public class FoodMenu {

    /**
     * flavor : 咸鲜味
     * calorie : 234
     * name : 雪丽对虾
     * technology : 炸
     * image_url : http://s1.ig.meishij.net/p/20091012/fed63858e633540c8df73e62692520fb_150x150.jpg
     * cook_quantity : [{"menu":"雪丽对虾","quantity":"500","material":"对虾"},{"menu":"雪丽对虾","quantity":"60","material":"鸡蛋清"},{"menu":"雪丽对虾","quantity":"100","material":"生菜(团叶)"},{"menu":"雪丽对虾","quantity":"80","material":"猪油(炼制)"},{"menu":"雪丽对虾","quantity":"30","material":"淀粉(玉米)"},{"menu":"雪丽对虾","quantity":"50","material":"小麦面粉"},{"menu":"雪丽对虾","quantity":"4","material":"盐"},{"menu":"雪丽对虾","quantity":"2","material":"胡椒粉"},{"menu":"雪丽对虾","quantity":"20","material":"料酒"},{"menu":"雪丽对虾","quantity":"35","material":"椒盐"},{"menu":"雪丽对虾","quantity":"35","material":"番茄酱"}]
     * practice : ['1. 将对虾洗净，剪去须、腿，去头、去壳(留尾段壳)，挑出沙肠后洗净；', '2. 从虾体内侧剞2～3刀，放在碗内，充分搅打，打至起雪白泡沫；', '3. 再加少许盐、淀粉、面粉拌匀，即成蛋清稠糊(又叫雪丽，高丽糊)；', '4. 将锅架在火上，放油烧至五六成热，将腌好的虾沥去水，轻轻扑上淀粉，放在雪丽蛋清糊碗中拖过，裹满糊料后放入温油锅用中；', '5. 小火炸，炸至膨松成熟(不可炸上色)捞出；', '6. 将虾尾朝着盘的中央，排在盘中，再在盘的周围放些焯烫断生的绿色蔬菜；', '7. 食用时蘸花椒盐、番茄酱。']
     * menuclassification_set : ["家常菜谱","补阳食谱","阳痿早泄食谱","不孕不育食谱","青少年食谱"]
     */

    private String flavor;
    private int calorie;
    private String name;
    private String technology;
    private String image_url;
    private String practice;
    private List<CookQuantityBean> cook_quantity;
    private List<String> menuclassification_set;

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getPractice() {
        return practice;
    }

    public void setPractice(String practice) {
        this.practice = practice;
    }

    public List<CookQuantityBean> getCook_quantity() {
        return cook_quantity;
    }

    public void setCook_quantity(List<CookQuantityBean> cook_quantity) {
        this.cook_quantity = cook_quantity;
    }

    public List<String> getMenuclassification_set() {
        return menuclassification_set;
    }

    public void setMenuclassification_set(List<String> menuclassification_set) {
        this.menuclassification_set = menuclassification_set;
    }

    public static class CookQuantityBean {
        /**
         * menu : 雪丽对虾
         * quantity : 500
         * material : 对虾
         */

        private String menu;
        private String quantity;
        private String material;

        public String getMenu() {
            return menu;
        }

        public void setMenu(String menu) {
            this.menu = menu;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        @Override
        public String toString() {
            return "CookQuantityBean{" +
                    "menu='" + menu + '\'' +
                    ", quantity='" + quantity + '\'' +
                    ", material='" + material + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "FoodMenu{" +
                "flavor='" + flavor + '\'' +
                ", calorie=" + calorie +
                ", name='" + name + '\'' +
                ", technology='" + technology + '\'' +
                ", image_url='" + image_url + '\'' +
                ", practice='" + practice + '\'' +
                ", cook_quantity=" + cook_quantity +
                ", menuclassification_set=" + menuclassification_set +
                '}';
    }
}
