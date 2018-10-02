package com.example.ninefourone.nutritionmaster.bean;

import java.util.List;

public class Physique {
    /**
     * physical_name : 气虚质
     * cure_material : ["人参","人参须","去芯莲子","去芯莲子（3~4人份）","土茯苓","土茯苓（4~5个人量）","山药","山药(干)","山药（或淮山）","山药，薏米，芡实1：1：1","已经去芯的莲子","干莲子","怀山药","扁豆","新鲜人参","新鲜莲子","无心莲子","毛山药","淮山药片","清补凉（淮山、枸杞、莲子、百合、玉竹、薏米、红枣）","炒扁豆","炒白术","焦白术","白扁豆","白术","白茯苓","白莲子","福建建宁莲子（想安神效果莲子可多放）","芡实","芡实米","芡实米(鲜)","花旗参","花旗参(西洋参)","茯苓","茯苓（2人份）","莲子","莲子心","铁杆山药","铁棍山药","鲜莲子  \u2026\u2026","黄芪"]
     */

    private String physical_name;
    private List<String> cure_material;

    public String getPhysical_name() {
        return physical_name;
    }

    public void setPhysical_name(String physical_name) {
        this.physical_name = physical_name;
    }

    public List<String> getCure_material() {
        return cure_material;
    }

    public void setCure_material(List<String> cure_material) {
        this.cure_material = cure_material;
    }

    private String imageUrl;
    private String expression;
    private String characteristic;
    private String mentality;
    private String matters;


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getMentality() {
        return mentality;
    }

    public void setMentality(String mentality) {
        this.mentality = mentality;
    }

    public String getMatters() {
        return matters;
    }

    public void setMatters(String matters) {
        this.matters = matters;
    }

    @Override
    public String toString() {
        return "Physique{" +
                "physical_name='" + physical_name + '\'' +
                ", cure_material=" + cure_material +
                '}';
    }
}
