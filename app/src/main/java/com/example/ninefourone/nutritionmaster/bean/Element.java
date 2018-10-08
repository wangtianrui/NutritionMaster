package com.example.ninefourone.nutritionmaster.bean;

import com.example.ninefourone.nutritionmaster.NutritionMaster;

/**
 * Created by ScorpioMiku on 2018/10/7.
 */

public class Element implements Cloneable {

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


    public Element calculateData(MyUser user) throws CloneNotSupportedException {
        double calorie = 655 + 9.6 * user.getWeight() + 1.9 * user.getHeight() - 4.7 * user.getAge();
        Element temp = (Element) this.clone();
        temp.setCalorie(calorie * this.calorie);
        temp.setCarbohydrate(user.getWeight() * this.carbohydrate);
        temp.setFat(user.getWeight() * this.fat);
        temp.setProtein(user.getWeight() * this.protein);
        return temp;
    }

    public Element(MyUser user) {
        if (user.getSex() == 0) {
            calorie = 0f;
            carbohydrate = 7.5f;
            fat = 1.2f;
            protein = 1f;
            cellulose = 25f;
            vitaminA = 700f;
            vitaminB1 = 1200f;
            vitaminB2 = 1200f;
            vitaminB6 = 1400f;
            vitaminC = 100f;
            vitaminE = 14f;
            carotene = 3600f;
            cholesterol = 200f;
            Mg = 315f;
            Ca = 1200f;
            Fe = 15f;
            Zn = 12f;
            Cu = 2.3f;
            Mn = 3.5f;
            K = 2000f;
            P = 1000f;
            Na = 1500f;
            Se = 0.05f;
            niacin = 0f;
            thiamine = 0f;
        } else {
            calorie = 0f;
            carbohydrate = 7.5f;
            fat = 1.2f;
            protein = 1f;
            cellulose = 25f;
            vitaminA = 800f;
            vitaminB1 = 1400f;
            vitaminB2 = 1400f;
            vitaminB6 = 2000f;
            vitaminC = 100f;
            vitaminE = 14f;
            carotene = 3400f;
            cholesterol = 200f;
            Mg = 360f;
            Ca = 1200f;
            Fe = 10f;
            Zn = 15f;
            Cu = 2.3f;
            Mn = 3.5f;
            K = 2000f;
            P = 1000f;
            Na = 1500f;
            Se = 0.05f;
            niacin = 0f;
            thiamine = 0f;
        }
    }

    public Element(Physique.ElementsBean elementsBean) {
        calorie = elementsBean.getCalorie();
        carbohydrate = elementsBean.getCarbohydrate();
        fat = elementsBean.getFat();
        protein = elementsBean.getProtein();
        cellulose = elementsBean.getCellulose();
        vitaminA = elementsBean.getVitaminA();
        vitaminB1 = elementsBean.getVitaminB1();
        vitaminB2 = elementsBean.getVitaminB2();
        vitaminB6 = elementsBean.getVitaminB6();
        vitaminC = elementsBean.getVitaminC();
        vitaminE = elementsBean.getVitaminE();
        carotene = elementsBean.getCarotene();
        cholesterol = elementsBean.getCholesterol();
        Mg = elementsBean.getMg();
        Ca = elementsBean.getCa();
        Fe = elementsBean.getFe();
        Zn = elementsBean.getZn();
        Cu = elementsBean.getCu();
        Mn = elementsBean.getMn();
        K = elementsBean.getK();
        P = elementsBean.getP();
        Na = elementsBean.getNa();
        Se = elementsBean.getSe();
        niacin = elementsBean.getNiacin();
        thiamine = elementsBean.getThiamine();
    }

    public Element(Occupation.ElementsBean elementsBean) {
        calorie = elementsBean.getCalorie();
        carbohydrate = elementsBean.getCarbohydrate();
        fat = elementsBean.getFat();
        protein = elementsBean.getProtein();
        cellulose = elementsBean.getCellulose();
        vitaminA = elementsBean.getVitaminA();
        vitaminB1 = elementsBean.getVitaminB1();
        vitaminB2 = elementsBean.getVitaminB2();
        vitaminB6 = elementsBean.getVitaminB6();
        vitaminC = elementsBean.getVitaminC();
        vitaminE = elementsBean.getVitaminE();
        carotene = elementsBean.getCarotene();
        cholesterol = elementsBean.getCholesterol();
        Mg = elementsBean.getMg();
        Ca = elementsBean.getCa();
        Fe = elementsBean.getFe();
        Zn = elementsBean.getZn();
        Cu = elementsBean.getCu();
        Mn = elementsBean.getMn();
        K = elementsBean.getK();
        P = elementsBean.getP();
        Na = elementsBean.getNa();
        Se = elementsBean.getSe();
        niacin = elementsBean.getNiacin();
        thiamine = elementsBean.getThiamine();
    }


    public Element(Illness.ElementsBean elementsBean) {
        calorie = elementsBean.getCalorie();
        carbohydrate = elementsBean.getCarbohydrate();
        fat = elementsBean.getFat();
        protein = elementsBean.getProtein();
        cellulose = elementsBean.getCellulose();
        vitaminA = elementsBean.getVitaminA();
        vitaminB1 = elementsBean.getVitaminB1();
        vitaminB2 = elementsBean.getVitaminB2();
        vitaminB6 = elementsBean.getVitaminB6();
        vitaminC = elementsBean.getVitaminC();
        vitaminE = elementsBean.getVitaminE();
        carotene = elementsBean.getCarotene();
        cholesterol = elementsBean.getCholesterol();
        Mg = elementsBean.getMg();
        Ca = elementsBean.getCa();
        Fe = elementsBean.getFe();
        Zn = elementsBean.getZn();
        Cu = elementsBean.getCu();
        Mn = elementsBean.getMn();
        K = elementsBean.getK();
        P = elementsBean.getP();
        Na = elementsBean.getNa();
        Se = elementsBean.getSe();
        niacin = elementsBean.getNiacin();
        thiamine = elementsBean.getThiamine();
    }


    @Override
    public String toString() {
        return "ElementsBean{" +
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

    public void add(Element elementsBean, float factor) {
        float divisor;
        if (factor == -1) {
            divisor = 1;
            factor = 1;
        } else {
            divisor = factor + 1.0f;
        }
        this.calorie = (factor * elementsBean.getCalorie() + this.calorie) / divisor;
        this.carbohydrate = (factor * elementsBean.getCarbohydrate() + this.carbohydrate) / divisor;
        this.fat = (factor * elementsBean.getFat() + this.fat) / divisor;
        this.protein = (factor * elementsBean.getProtein() + this.protein) / divisor;
        this.cellulose = (factor * elementsBean.getCellulose() + this.cellulose) / divisor;
        this.vitaminA = (factor * elementsBean.getVitaminA() + this.vitaminA) / divisor;
        this.vitaminB1 = (factor * elementsBean.getVitaminB1() + this.vitaminB1) / divisor;
        this.vitaminB2 = (factor * elementsBean.getVitaminB2() + this.vitaminB2) / divisor;
        this.vitaminB6 = (factor * elementsBean.getVitaminB6() + this.vitaminB6) / divisor;
        this.vitaminC = (factor * elementsBean.getVitaminC() + this.vitaminC) / divisor;
        this.vitaminE = (factor * elementsBean.getVitaminE() + this.vitaminE) / divisor;
        this.carotene = (factor * elementsBean.getCarotene() + this.carotene) / divisor;
        this.cholesterol = (factor * elementsBean.getMg() + this.Mg) / divisor;
        this.Mg = (factor * elementsBean.getCarbohydrate() + this.carbohydrate) / divisor;
        this.Ca = (factor * elementsBean.getCa() + this.Ca) / divisor;
        this.Fe = (factor * elementsBean.getFe() + this.Fe) / divisor;
        this.Zn = (factor * elementsBean.getZn() + this.Zn) / divisor;
        this.Cu = (factor * elementsBean.getCu() + this.Cu) / divisor;
        this.Mn = (factor * elementsBean.getMn() + this.Mn) / divisor;
        this.K = (factor * elementsBean.getK() + this.K) / divisor;
        this.P = (factor * elementsBean.getP() + this.P) / divisor;
        this.Na = (factor * elementsBean.getNa() + this.Na) / divisor;
        this.Se = (factor * elementsBean.getSe() + this.Se) / divisor;
        this.niacin = (factor * elementsBean.getNiacin() + this.niacin) / divisor;
        this.thiamine = (factor * elementsBean.getThiamine() + this.thiamine) / divisor;
    }

    public double getCalorie() {
        return calorie;
    }

    public float getCarbohydrate() {
        return carbohydrate;
    }

    public float getFat() {
        return fat;
    }

    public float getProtein() {
        return protein;
    }

    public float getCellulose() {
        return cellulose;
    }

    public float getVitaminA() {
        return vitaminA;
    }

    public float getVitaminB1() {
        return vitaminB1;
    }

    public float getVitaminB2() {
        return vitaminB2;
    }

    public float getVitaminB6() {
        return vitaminB6;
    }

    public float getVitaminC() {
        return vitaminC;
    }

    public float getVitaminE() {
        return vitaminE;
    }

    public float getCarotene() {
        return carotene;
    }

    public float getCholesterol() {
        return cholesterol;
    }

    public float getMg() {
        return Mg;
    }

    public float getCa() {
        return Ca;
    }

    public float getFe() {
        return Fe;
    }

    public float getZn() {
        return Zn;
    }

    public float getCu() {
        return Cu;
    }

    public float getMn() {
        return Mn;
    }

    public float getK() {
        return K;
    }

    public float getP() {
        return P;
    }

    public float getNa() {
        return Na;
    }

    public float getSe() {
        return Se;
    }

    public float getNiacin() {
        return niacin;
    }

    public float getThiamine() {
        return thiamine;
    }

    public void setCalorie(double calorie) {
        this.calorie = calorie;
    }

    public void setCarbohydrate(float carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }
}
