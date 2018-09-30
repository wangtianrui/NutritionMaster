package com.example.ninefourone.nutritionmaster.bean;

import java.util.List;

public class Occupation {
    /**
     * occupation_name : 电力工程师
     * menuclassification_set : ["接触电离辐射人员食谱","防癌抗癌食谱","明目食谱","关节炎食谱","壮腰健肾食谱"]
     * elements : {"id":35,"calorie":1.11,"carbohydrate":0,"fat":0,"protein":0,"cellulose":7,"vitaminA":0,"vitaminB1":0,"vitaminB2":0,"vitaminB6":200,"vitaminC":0,"vitaminE":2,"carotene":500,"cholesterol":0,"Mg":0,"Ca":0,"Fe":0,"Zn":0,"Cu":0,"Mn":0,"K":0,"P":0,"Na":0,"Se":0,"niacin":0,"thiamine":0}
     * bmi_classification : 2
     */

    private String occupation_name;
    private ElementsBean elements;
    private float bmi_classification;
    private List<String> menuclassification_set;

    public String getOccupation_name() {
        return occupation_name;
    }

    public void setOccupation_name(String occupation_name) {
        this.occupation_name = occupation_name;
    }

    public ElementsBean getElements() {
        return elements;
    }

    public void setElements(ElementsBean elements) {
        this.elements = elements;
    }

    public float getBmi_classification() {
        return bmi_classification;
    }

    public void setBmi_classification(float bmi_classification) {
        this.bmi_classification = bmi_classification;
    }

    public List<String> getMenuclassification_set() {
        return menuclassification_set;
    }

    public void setMenuclassification_set(List<String> menuclassification_set) {
        this.menuclassification_set = menuclassification_set;
    }

    public static class ElementsBean {
        /**
         * id : 35
         * calorie : 1.11
         * carbohydrate : 0
         * fat : 0
         * protein : 0
         * cellulose : 7
         * vitaminA : 0
         * vitaminB1 : 0
         * vitaminB2 : 0
         * vitaminB6 : 200
         * vitaminC : 0
         * vitaminE : 2
         * carotene : 500
         * cholesterol : 0
         * Mg : 0
         * Ca : 0
         * Fe : 0
         * Zn : 0
         * Cu : 0
         * Mn : 0
         * K : 0
         * P : 0
         * Na : 0
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

    @Override
    public String toString() {
        return "Occupation{" +
                "occupation_name='" + occupation_name + '\'' +
                ", elements=" + elements +
                ", bmi_classification=" + bmi_classification +
                ", menuclassification_set=" + menuclassification_set +
                '}';
    }
}