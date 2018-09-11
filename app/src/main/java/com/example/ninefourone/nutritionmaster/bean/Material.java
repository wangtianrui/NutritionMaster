package com.example.ninefourone.nutritionmaster.bean;

/**
 * Created by ScorpioMiku on 2018/9/11.
 */

public class Material {
    private String materialName;
    private float weight;

    public Material(String materialName, float weight) {
        this.materialName = materialName;
        this.weight = weight;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
