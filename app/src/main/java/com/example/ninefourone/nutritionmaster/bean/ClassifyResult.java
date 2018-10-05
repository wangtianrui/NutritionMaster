package com.example.ninefourone.nutritionmaster.bean;

import java.io.Serializable;

/**
 * Created by ScorpioMiku on 2018/10/4.
 */

public class ClassifyResult implements Serializable {

    private String imgPath;
    private double probability;
    private String name;
    private double calorie;
    private Boolean has_calorie;
    private double quantity = -1;

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

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

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(double calorie) {
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
