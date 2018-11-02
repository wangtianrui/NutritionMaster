package com.example.ninefourone.nutritionmaster.bean;

public class History {

    /**
     * id : 13 time : 2018-11-02T15:35:20.015542+08:00 user : 11 menu : 多味茄子泥
     */

    private int id;
    private String time;
    private int user;
    private String menu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "History{" + "id=" + id + ", time='" + time + '\'' + ", user=" + user + ", menu='" + menu + '\'' + '}';
    }
}
