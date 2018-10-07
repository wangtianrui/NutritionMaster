package com.example.ninefourone.nutritionmaster.bean;

import java.io.Serializable;
import java.util.List;

public class FoodMenu implements Serializable {


    /**
     * flavor : 五香味
     * calorie : 157
     * name : 五香酥鱼
     * technology : 卤
     * image_url : http://s1.st.meishij.net/r/26/70/2392526/a2392526_144672974229833.jpg
     * cook_quantity : [{"menu":"五香酥鱼","quantity":"500","material":"鲫鱼"},{"menu":"五香酥鱼","quantity":"250","material":"大葱"},{"menu":"五香酥鱼","quantity":"50","material":"姜"},{"menu":"五香酥鱼","quantity":"50","material":"大蒜(白皮)"},{"menu":"五香酥鱼","quantity":"2","material":"桂皮"},{"menu":"五香酥鱼","quantity":"2","material":"茴香粉"},{"menu":"五香酥鱼","quantity":"3","material":"料酒"},{"menu":"五香酥鱼","quantity":"75","material":"酱油"},{"menu":"五香酥鱼","quantity":"75","material":"醋"},{"menu":"五香酥鱼","quantity":"75","material":"香油"},{"menu":"五香酥鱼","quantity":"100","material":"白砂糖"}]
     * practice : ['1. 将鲫鱼刮洗干净；', '2. 大葱洗净切段；姜、蒜洗净切片备用；', '3. 将锅底里垫上一层竹垫，先将鲫鱼放在竹垫上整齐排列（头朝外、肚朝上，侧放），把各种香料均匀地铺放一层在鱼身上，再放一层鱼，再放一层调料 ，就这样直至把鱼和调料放完；', '4. 加黄酒、酱油、米醋、白糖、鲜汤、然后盖上锅盖，使其尽量密封；', '5. 用大火烧沸后，转用小火焖烧五小时；', '6. 待鱼骨酥烂时，淋上麻油，用大火收稠卤汁，然后离火冷却，待结冻后再小心取出装盘。']
     * menuclassification_set : ["京菜","健脾开胃食谱","补虚养身食谱","产后调理食谱","肾炎食谱"]
     * elements : {"id":3940,"calorie":183,"carbohydrate":17.5,"fat":9.727272727272727,"protein":4.254545454545454,"cellulose":4.2272727272727275,"vitaminA":42,"vitaminB1":0,"vitaminB2":0.05454545454545456,"vitaminB6":0,"vitaminC":4.909090909090909,"vitaminE":0.9899999999999999,"carotene":242.72727272727272,"cholesterol":11.818181818181818,"Mg":31.181818181818183,"Ca":47.18181818181818,"Fe":1.9454545454545455,"Zn":0.6363636363636362,"Cu":0.12090909090909091,"Mn":1.7381818181818183,"K":185.45454545454547,"P":64.0909090909091,"Na":571.5363636363636,"Se":2.183636363636364,"niacin":0.7545454545454544,"thiamine":0.025454545454545455}
     */

    private String flavor;
    private float calorie;
    private String name;
    private int is_breakfast;
    private String technology;
    private String image_url;
    private String practice;
    private ElementsBean elements;
    private List<CookQuantityBean> cook_quantity;
    private List<String> menuclassification_set;

    @Override
    public String toString() {
        return "FoodMenu{" +
                "flavor='" + flavor + '\'' +
                ", calorie=" + calorie +
                ", name='" + name + '\'' +
                ", is_breakfast=" + is_breakfast +
                ", technology='" + technology + '\'' +
                ", image_url='" + image_url + '\'' +
                ", practice='" + practice + '\'' +
                ", elements=" + elements +
                ", cook_quantity=" + cook_quantity +
                ", menuclassification_set=" + menuclassification_set +
                '}';
    }

    public int getIs_breakfast() {
        return is_breakfast;
    }

    public void setIs_breakfast(int is_breakfast) {
        this.is_breakfast = is_breakfast;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public float getCalorie() {
        return calorie;
    }

    public void setCalorie(float calorie) {
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

    public List<String> getMenuclassification_set() {
        return menuclassification_set;
    }

    public void setMenuclassification_set(List<String> menuclassification_set) {
        this.menuclassification_set = menuclassification_set;
    }

    public static class ElementsBean implements Serializable {
        /**
         * id : 3940
         * calorie : 183
         * carbohydrate : 17.5
         * fat : 9.727272727272727
         * protein : 4.254545454545454
         * cellulose : 4.2272727272727275
         * vitaminA : 42
         * vitaminB1 : 0
         * vitaminB2 : 0.05454545454545456
         * vitaminB6 : 0
         * vitaminC : 4.909090909090909
         * vitaminE : 0.9899999999999999
         * carotene : 242.72727272727272
         * cholesterol : 11.818181818181818
         * Mg : 31.181818181818183
         * Ca : 47.18181818181818
         * Fe : 1.9454545454545455
         * Zn : 0.6363636363636362
         * Cu : 0.12090909090909091
         * Mn : 1.7381818181818183
         * K : 185.45454545454547
         * P : 64.0909090909091
         * Na : 571.5363636363636
         * Se : 2.183636363636364
         * niacin : 0.7545454545454544
         * thiamine : 0.025454545454545455
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
        private double vitaminC;
        private double vitaminE;
        private double carotene;
        private double cholesterol;
        private double Mg;
        private double Ca;
        private double Fe;
        private double Zn;
        private double Cu;
        private double Mn;
        private double K;
        private double P;
        private double Na;
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

        public double getVitaminC() {
            return vitaminC;
        }

        public void setVitaminC(double vitaminC) {
            this.vitaminC = vitaminC;
        }

        public double getVitaminE() {
            return vitaminE;
        }

        public void setVitaminE(double vitaminE) {
            this.vitaminE = vitaminE;
        }

        public double getCarotene() {
            return carotene;
        }

        public void setCarotene(double carotene) {
            this.carotene = carotene;
        }

        public double getCholesterol() {
            return cholesterol;
        }

        public void setCholesterol(double cholesterol) {
            this.cholesterol = cholesterol;
        }

        public double getMg() {
            return Mg;
        }

        public void setMg(double Mg) {
            this.Mg = Mg;
        }

        public double getCa() {
            return Ca;
        }

        public void setCa(double Ca) {
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

        public double getK() {
            return K;
        }

        public void setK(double K) {
            this.K = K;
        }

        public double getP() {
            return P;
        }

        public void setP(double P) {
            this.P = P;
        }

        public double getNa() {
            return Na;
        }

        public void setNa(double Na) {
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

    public static class CookQuantityBean implements Serializable{
        /**
         * menu : 五香酥鱼
         * quantity : 500
         * material : 鲫鱼
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
