package com.example.ninefourone.nutritionmaster.bean;

public class FoodMaterial {
    /**
     * menu : 西红柿鸡蛋汤
     * quantity : 适量
     * material : 西红柿
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

    @Override
    public String toString() {
        return "FoodMaterial{" +
                "menu='" + menu + '\'' +
                ", quantity='" + quantity + '\'' +
                ", material='" + material + '\'' +
                '}';
    }

    public void setMaterial(String material) {


        this.material = material;
    }
}
