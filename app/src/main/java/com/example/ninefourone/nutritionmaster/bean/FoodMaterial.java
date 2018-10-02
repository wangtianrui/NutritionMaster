package com.example.ninefourone.nutritionmaster.bean;

import java.util.List;

public class FoodMaterial {

    /**
     * material_name : 西红柿
     * cook_quantity : [{"menu":"西红柿鸡蛋汤","quantity":"适量","material":"西红柿"},{"menu":"瘦身版红菜汤","quantity":"4-5片","material":"西红柿"},{"menu":"西红柿炖豆腐","quantity":"三个","material":"西红柿"},{"menu":"傣味凉拌黄瓜","quantity":"一个","material":"西红柿"},{"menu":"健康早餐竹炭三明治","quantity":"适量","material":"西红柿"},{"menu":"豆腐卤","quantity":"一粒","material":"西红柿"},{"menu":"减肥美食蕃薯芦笋鱼柳","quantity":"适量","material":"西红柿"},{"menu":"瘦身美食凤尾香梨番茄盅","quantity":"适量","material":"西红柿"},{"menu":"低脂美味快手的番茄烤大比目鱼","quantity":"900g","material":"西红柿"},{"menu":"田园蔬菜养生汤","quantity":"适量","material":"西红柿"},{"menu":"抗衰老的番茄鲜藕橙杯","quantity":"适量","material":"西红柿"},{"menu":"抗衰老美食菠菜三文鱼芥末堆","quantity":"适量","material":"西红柿"},{"menu":"凉拌莜面","quantity":"3g","material":"西红柿"},{"menu":"夏季护发防晒美食-苏子烤鸡腿配玉米奶酪西红柿","quantity":"适量","material":"西红柿"},{"menu":"美白防晒的番茄双笋银杏果","quantity":"适量","material":"西红柿"},{"menu":"家庭自制大西北风味羊肉粉汤","quantity":"两勺","material":"西红柿"}]
     * elements : {"id":1162,"calorie":20,"carbohydrate":3.5,"fat":0.2,"protein":0.9,"cellulose":0.5,"vitaminA":92,"vitaminB1":0,"vitaminB2":0.03,"vitaminB6":0,"vitaminC":19,"vitaminE":0.57,"carotene":550,"cholesterol":0,"Mg":9,"Ca":10,"Fe":0.4,"Zn":0.13,"Cu":0.06,"Mn":0.08,"K":163,"P":23,"Na":5,"Se":0.15,"niacin":0.6,"thiamine":0.03}
     */

    private String material_name;
    private ElementsBean elements;
    private List<CookQuantityBean> cook_quantity;

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public ElementsBean getElements() {
        return elements;
    }

    public void setElements(ElementsBean elements) {
        this.elements = elements;
    }

    public List<CookQuantityBean> getCook_quantity() {
        return cook_quantity;
    }

    public void setCook_quantity(List<CookQuantityBean> cook_quantity) {
        this.cook_quantity = cook_quantity;
    }

    @Override
    public String toString() {
        return "FoodMaterial{" +
                "material_name='" + material_name + '\'' +
                ", elements=" + elements +
                ", cook_quantity=" + cook_quantity +
                '}';
    }

    public static class ElementsBean {
        /**
         * id : 1162
         * calorie : 20
         * carbohydrate : 3.5
         * fat : 0.2
         * protein : 0.9
         * cellulose : 0.5
         * vitaminA : 92
         * vitaminB1 : 0
         * vitaminB2 : 0.03
         * vitaminB6 : 0
         * vitaminC : 19
         * vitaminE : 0.57
         * carotene : 550
         * cholesterol : 0
         * Mg : 9
         * Ca : 10
         * Fe : 0.4
         * Zn : 0.13
         * Cu : 0.06
         * Mn : 0.08
         * K : 163
         * P : 23
         * Na : 5
         * Se : 0.15
         * niacin : 0.6
         * thiamine : 0.03
         */

        private float id;
        private float calorie;
        private double carbohydrate;
        private double fat;
        private double protein;
        private double cellulose;
        private float vitaminA;
        private float vitaminB1;
        private double vitaminB2;
        private float vitaminB6;
        private float vitaminC;
        private double vitaminE;
        private float carotene;
        private float cholesterol;
        private float Mg;
        private float Ca;
        private double Fe;
        private double Zn;
        private double Cu;
        private double Mn;
        private float K;
        private float P;
        private float Na;
        private double Se;
        private double niacin;
        private double thiamine;

        @Override
        public String toString() {
            return "ElementsBean{" +
                    "id=" + id +
                    ", calorie=" + calorie +
                    ", carbohydrate=" + carbohydrate +
                    ", fat=" + fat +
                    ", protein=" + protein +
                    ", cellulose=" + cellulose +
                    ", vitaminA=" + vitaminA +
                    ", vitaminB1=" + vitaminB1 +
                    ", vitaminB2=" + vitaminB2 +
                    ", vitaminB6=" + vitaminB6 +
                    ", vitaminC=" + vitaminC +
                    ", vitaminE=" + vitaminE +
                    ", carotene=" + carotene +
                    ", cholesterol=" + cholesterol +
                    ", Mg=" + Mg +
                    ", Ca=" + Ca +
                    ", Fe=" + Fe +
                    ", Zn=" + Zn +
                    ", Cu=" + Cu +
                    ", Mn=" + Mn +
                    ", K=" + K +
                    ", P=" + P +
                    ", Na=" + Na +
                    ", Se=" + Se +
                    ", niacin=" + niacin +
                    ", thiamine=" + thiamine +
                    '}';
        }

        public float getId() {
            return id;
        }

        public void setId(float id) {
            this.id = id;
        }

        public float getCalorie() {
            return calorie;
        }

        public void setCalorie(float calorie) {
            this.calorie = calorie;
        }

        public double getCarbohydrate() {
            return carbohydrate;
        }

        public void setCarbohydrate(double carbohydrate) {
            this.carbohydrate = carbohydrate;
        }

        public double getFat() {
            return fat;
        }

        public void setFat(double fat) {
            this.fat = fat;
        }

        public double getProtein() {
            return protein;
        }

        public void setProtein(double protein) {
            this.protein = protein;
        }

        public double getCellulose() {
            return cellulose;
        }

        public void setCellulose(double cellulose) {
            this.cellulose = cellulose;
        }

        public float getVitaminA() {
            return vitaminA;
        }

        public void setVitaminA(float vitaminA) {
            this.vitaminA = vitaminA;
        }

        public float getVitaminB1() {
            return vitaminB1;
        }

        public void setVitaminB1(float vitaminB1) {
            this.vitaminB1 = vitaminB1;
        }

        public double getVitaminB2() {
            return vitaminB2;
        }

        public void setVitaminB2(double vitaminB2) {
            this.vitaminB2 = vitaminB2;
        }

        public float getVitaminB6() {
            return vitaminB6;
        }

        public void setVitaminB6(float vitaminB6) {
            this.vitaminB6 = vitaminB6;
        }

        public float getVitaminC() {
            return vitaminC;
        }

        public void setVitaminC(float vitaminC) {
            this.vitaminC = vitaminC;
        }

        public double getVitaminE() {
            return vitaminE;
        }

        public void setVitaminE(double vitaminE) {
            this.vitaminE = vitaminE;
        }

        public float getCarotene() {
            return carotene;
        }

        public void setCarotene(float carotene) {
            this.carotene = carotene;
        }

        public float getCholesterol() {
            return cholesterol;
        }

        public void setCholesterol(float cholesterol) {
            this.cholesterol = cholesterol;
        }

        public float getMg() {
            return Mg;
        }

        public void setMg(float Mg) {
            this.Mg = Mg;
        }

        public float getCa() {
            return Ca;
        }

        public void setCa(float Ca) {
            this.Ca = Ca;
        }

        public double getFe() {
            return Fe;
        }

        public void setFe(double Fe) {
            this.Fe = Fe;
        }

        public double getZn() {
            return Zn;
        }

        public void setZn(double Zn) {
            this.Zn = Zn;
        }

        public double getCu() {
            return Cu;
        }

        public void setCu(double Cu) {
            this.Cu = Cu;
        }

        public double getMn() {
            return Mn;
        }

        public void setMn(double Mn) {
            this.Mn = Mn;
        }

        public float getK() {
            return K;
        }

        public void setK(float K) {
            this.K = K;
        }

        public float getP() {
            return P;
        }

        public void setP(float P) {
            this.P = P;
        }

        public float getNa() {
            return Na;
        }

        public void setNa(float Na) {
            this.Na = Na;
        }

        public double getSe() {
            return Se;
        }

        public void setSe(double Se) {
            this.Se = Se;
        }

        public double getNiacin() {
            return niacin;
        }

        public void setNiacin(double niacin) {
            this.niacin = niacin;
        }

        public double getThiamine() {
            return thiamine;
        }

        public void setThiamine(double thiamine) {
            this.thiamine = thiamine;
        }
    }

    public static class CookQuantityBean {
        /**
         * menu : 西红柿鸡蛋汤
         * quantity : 适量
         * material : 西红柿
         */

        private String menu;
        private String quantity;
        private String material;

        @Override
        public String toString() {
            return "CookQuantityBean{" +
                    "menu='" + menu + '\'' +
                    ", quantity='" + quantity + '\'' +
                    ", material='" + material + '\'' +
                    '}';
        }

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
    }
}
