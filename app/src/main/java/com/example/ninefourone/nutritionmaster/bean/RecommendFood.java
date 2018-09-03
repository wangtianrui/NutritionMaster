package com.example.ninefourone.nutritionmaster.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.orhanobut.logger.Logger;

/**
 * Created by ScorpioMiku on 2018/9/3.
 */

public class RecommendFood implements MultiItemEntity {

    public static final int TYPE_BIG = 0;
    public static final int TYPE_MIDDLE = 1;
    public static final int TYPE_DETAIL = 2;

    private int picture;
    private String title;
    private String description;
    private int type;

    public RecommendFood(int picture, String title, String description, int type) {
        this.picture = picture;
        this.title = title;
        this.description = description;
        this.type = type;
        if (type > 2) {
            Logger.e("混合recycler type不对");
        }
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
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
}
