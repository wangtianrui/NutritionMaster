package com.example.ninefourone.nutritionmaster.bean;

public class History {
    /**
     * id : 13
     * menu : {"name":"多味茄子泥","calorie":105,"elements":6383,"image_url":"http://s1.ig.meishij.net/p/20121204/3fde157430b268b189a913983fdda3e6_150x150.jpg"}
     * time : 2018-11-02T15:34:27.050541+08:00
     * user : 11
     */

    private int id;
    private MenuBean menu;
    private String time;
    private int user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MenuBean getMenu() {
        return menu;
    }

    public void setMenu(MenuBean menu) {
        this.menu = menu;
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

    public static class MenuBean {
        /**
         * name : 多味茄子泥
         * calorie : 105
         * elements : 6383
         * image_url : http://s1.ig.meishij.net/p/20121204/3fde157430b268b189a913983fdda3e6_150x150.jpg
         */

        private String name;
        private int calorie;
        private int elements;
        private String image_url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCalorie() {
            return calorie;
        }

        public void setCalorie(int calorie) {
            this.calorie = calorie;
        }

        public int getElements() {
            return elements;
        }

        public void setElements(int elements) {
            this.elements = elements;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        @Override
        public String toString() {
            return "MenuBean{" +
                    "name='" + name + '\'' +
                    ", calorie=" + calorie +
                    ", elements=" + elements +
                    ", image_url='" + image_url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", menu=" + menu +
                ", time='" + time + '\'' +
                ", user=" + user +
                '}' + '\n';
    }
}
