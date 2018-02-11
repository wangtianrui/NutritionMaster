package com.example.ninefourone.nutritionmaster.bean;

/**
 * Created by ScorpioMiku on 2018/9/3.
 */

public class DailyCard {
    /***
     * 每日卡片bean类
     */
    private String title;
    private String description;
    private int pictureId;

    public DailyCard(String title, String description, int pictureId) {
        this.title = title;
        this.description = description;
        this.pictureId = pictureId;
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

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
}
