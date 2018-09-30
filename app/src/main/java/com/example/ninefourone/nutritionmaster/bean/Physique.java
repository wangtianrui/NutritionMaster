package com.example.ninefourone.nutritionmaster.bean;

import java.util.List;

public class Physique {

    /**
     * physical_name : 气虚质
     * cure_material : ["人参","人参须","去芯莲子","去芯莲子（3~4人份）","土茯苓","土茯苓（4~5个人量）","山药","山药(干)","山药（或淮山）","山药，薏米，芡实1：1：1","已经去芯的莲子","干莲子","怀山药","扁豆","新鲜人参","新鲜莲子","无心莲子","毛山药","淮山药片","清补凉（淮山、枸杞、莲子、百合、玉竹、薏米、红枣）","炒扁豆","炒白术","焦白术","白扁豆","白术","白茯苓","白莲子","福建建宁莲子（想安神效果莲子可多放）","芡实","芡实米","芡实米(鲜)","花旗参","花旗参(西洋参)","茯苓","茯苓（2人份）","莲子","莲子心","铁杆山药","铁棍山药","鲜莲子  \u2026\u2026","黄芪"]
     * elements : {"id":81,"calorie":1.2,"carbohydrate":0,"fat":0,"protein":0,"cellulose":0,"vitaminA":500,"vitaminB1":0,"vitaminB2":0,"vitaminB6":1500,"vitaminC":100,"vitaminE":0,"carotene":1500,"cholesterol":0,"Mg":0,"Ca":0,"Fe":0,"Zn":0,"Cu":0,"Mn":0,"K":0,"P":500,"Na":1000,"Se":0,"niacin":0,"thiamine":0}
     */

    private String physical_name;
    private ElementsBean elements;
    private List<String> cure_material;

    @Override
    public String toString() {
        return "Physique{" +
                "physical_name='" + physical_name + '\'' +
                ", elements=" + elements +
                ", cure_material=" + cure_material +
                '}';
    }

    public String getPhysical_name() {
        return physical_name;
    }

    public void setPhysical_name(String physical_name) {
        this.physical_name = physical_name;
    }

    public ElementsBean getElements() {
        return elements;
    }

    public void setElements(ElementsBean elements) {
        this.elements = elements;
    }

    public List<String> getCure_material() {
        return cure_material;
    }

    public void setCure_material(List<String> cure_material) {
        this.cure_material = cure_material;
    }

    public static class ElementsBean {
        /**
         * id : 81
         * calorie : 1.2
         * carbohydrate : 0
         * fat : 0
         * protein : 0
         * cellulose : 0
         * vitaminA : 500
         * vitaminB1 : 0
         * vitaminB2 : 0
         * vitaminB6 : 1500
         * vitaminC : 100
         * vitaminE : 0
         * carotene : 1500
         * cholesterol : 0
         * Mg : 0
         * Ca : 0
         * Fe : 0
         * Zn : 0
         * Cu : 0
         * Mn : 0
         * K : 0
         * P : 500
         * Na : 1000
         * Se : 0
         * niacin : 0
         * thiamine : 0
         */

        private float id;
        private double calorie;
        private float carbohydrate;
        private float fat;
        private float protein;
        private float cellulose;
        private float vitaminA;
        private float vitaminB1;
        private float vitaminB2;
        private float vitaminB6;
        private float vitaminC;
        private float vitaminE;
        private float carotene;
        private float cholesterol;
        private float Mg;
        private float Ca;
        private float Fe;
        private float Zn;
        private float Cu;
        private float Mn;
        private float K;
        private float P;
        private float Na;
        private float Se;
        private float niacin;
        private float thiamine;

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

        public double getCalorie() {
            return calorie;
        }

        public void setCalorie(double calorie) {
            this.calorie = calorie;
        }

        public float getCarbohydrate() {
            return carbohydrate;
        }

        public void setCarbohydrate(float carbohydrate) {
            this.carbohydrate = carbohydrate;
        }

        public float getFat() {
            return fat;
        }

        public void setFat(float fat) {
            this.fat = fat;
        }

        public float getProtein() {
            return protein;
        }

        public void setProtein(float protein) {
            this.protein = protein;
        }

        public float getCellulose() {
            return cellulose;
        }

        public void setCellulose(float cellulose) {
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

        public float getVitaminB2() {
            return vitaminB2;
        }

        public void setVitaminB2(float vitaminB2) {
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

        public float getVitaminE() {
            return vitaminE;
        }

        public void setVitaminE(float vitaminE) {
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

        public float getFe() {
            return Fe;
        }

        public void setFe(float Fe) {
            this.Fe = Fe;
        }

        public float getZn() {
            return Zn;
        }

        public void setZn(float Zn) {
            this.Zn = Zn;
        }

        public float getCu() {
            return Cu;
        }

        public void setCu(float Cu) {
            this.Cu = Cu;
        }

        public float getMn() {
            return Mn;
        }

        public void setMn(float Mn) {
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

        public float getSe() {
            return Se;
        }

        public void setSe(float Se) {
            this.Se = Se;
        }

        public float getNiacin() {
            return niacin;
        }

        public void setNiacin(float niacin) {
            this.niacin = niacin;
        }

        public float getThiamine() {
            return thiamine;
        }

        public void setThiamine(float thiamine) {
            this.thiamine = thiamine;
        }
    }
}
