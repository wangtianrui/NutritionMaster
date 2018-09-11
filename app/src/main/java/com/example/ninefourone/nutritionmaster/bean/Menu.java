package com.example.ninefourone.nutritionmaster.bean;

import java.util.ArrayList;

/**
 * Created by ScorpioMiku on 2018/9/9.
 */

public class Menu {
    private String menuName;
    private ArrayList<Material> materialArrayList;
    private ArrayList<String> makeSteps;


    public Menu(String menuName, ArrayList<Material> materialArrayList, ArrayList<String> makeSteps) {
        this.menuName = menuName;
        this.materialArrayList = materialArrayList;
        this.makeSteps = makeSteps;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public ArrayList<Material> getMaterialArrayList() {
        return materialArrayList;
    }

    public void setMaterialArrayList(ArrayList<Material> materialArrayList) {
        this.materialArrayList = materialArrayList;
    }

    public ArrayList<String> getMakeSteps() {
        return makeSteps;
    }

    public void setMakeSteps(ArrayList<String> makeSteps) {
        this.makeSteps = makeSteps;
    }
}
