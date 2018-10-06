package com.example.ninefourone.nutritionmaster.bean;

public class FoodMenuLight {

    /**
     * name : 番茄虾仁
     * calorie : 20
     * elements : 2953
     */

    private String name;
    private double calorie;
    private int elements;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public double getElements() {
        return elements;
    }

    public void setElements(int elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "FoodMenuLight{" +
                "name='" + name + '\'' +
                ", calorie=" + calorie +
                ", elements=" + elements +
                '}';
    }
}
