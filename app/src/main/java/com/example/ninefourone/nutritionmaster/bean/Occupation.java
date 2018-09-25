package com.example.ninefourone.nutritionmaster.bean;

import java.util.List;

public class Occupation {

    /**
     * occupation_name : 电力工程师
     * menuclassification_set : ["接触电离辐射人员食谱","防癌抗癌食谱","明目食谱","关节炎食谱","壮腰健肾食谱"]
     */

    private String occupation_name;
    private List<String> menuclassification_set;

    public String getOccupation_name() {
        return occupation_name;
    }

    public void setOccupation_name(String occupation_name) {
        this.occupation_name = occupation_name;
    }

    public List<String> getMenuclassification_set() {
        return menuclassification_set;
    }

    public void setMenuclassification_set(List<String> menuclassification_set) {
        this.menuclassification_set = menuclassification_set;
    }

    @Override
    public String toString() {
        return "Occupation{" +
                "occupation_name='" + occupation_name + '\'' +
                ", menuclassification_set=" + menuclassification_set +
                '}';
    }
}
