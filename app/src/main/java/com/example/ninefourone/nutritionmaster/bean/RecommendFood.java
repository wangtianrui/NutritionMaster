package com.example.ninefourone.nutritionmaster.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.orhanobut.logger.Logger;

import java.io.Serializable;

/**
 * Created by ScorpioMiku on 2018/9/3.
 */

public class RecommendFood implements MultiItemEntity, Serializable {

    //三种view
    public static final int TYPE_BIG = 0;
    public static final int TYPE_MIDDLE = 1;
    public static final int TYPE_DETAIL = 2;

    private String picture;
    private String title;
    private String description;
    private int type;
    private FoodMenu menu;

    public FoodMenu getMenu() {
        return menu;
    }

    public void setMenu(FoodMenu menu) {
        this.menu = menu;
    }

    public RecommendFood(FoodMenu foodMenu, int type) {
        menu = foodMenu;
        picture = foodMenu.getImage_url();
        title = foodMenu.getName();
        this.type = type;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getItemType() {
        return type;
    }

    @Override
    public String toString() {
        return menu.toString();

    }
}
