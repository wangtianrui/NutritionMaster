package com.example.ninefourone.nutritionmaster.bean;

/**
 * Created by ScorpioMiku on 2018/10/4.
 */

public class ClassifyResult {

    private String imgPath ;
    private double probability;
    private String name;
    private int calorie;
    private Boolean has_calorie;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public Boolean getHas_calorie() {
        return has_calorie;
    }

    public void setHas_calorie(Boolean has_calorie) {
        this.has_calorie = has_calorie;
    }

    @Override
    public String toString() {
        return name + ";置信度" + probability + ";卡路里" + calorie;

    }
}
