package com.example.ninefourone.nutritionmaster.bean;

import java.util.List;

public class MyUser {

    /**
     * id : 7
     * physical_name : 平和质
     * password : password
     * last_login : null
     * is_superuser : false
     * username : okhttptest
     * first_name :
     * last_name :
     * email :
     * is_staff : false
     * is_active : false
     * date_joined : 2018-09-24T15:13:09.298590+08:00
     * sex : 1
     * occupation_name : 程序员
     * groups : []
     * user_permissions : []
     */

    private int id;
    private String physical_name;
    private String password;
    private Object last_login;
    private boolean is_superuser;
    private String username;
    private String first_name;
    private String last_name;
    private String email;
    private boolean is_staff;
    private boolean is_active;
    private String date_joined;
    private int sex;
    private String occupation_name;
    private List<?> groups;
    private List<?> user_permissions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhysical_name() {
        return physical_name;
    }

    public void setPhysical_name(String physical_name) {
        this.physical_name = physical_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getLast_login() {
        return last_login;
    }

    public void setLast_login(Object last_login) {
        this.last_login = last_login;
    }

    public boolean isIs_superuser() {
        return is_superuser;
    }

    public void setIs_superuser(boolean is_superuser) {
        this.is_superuser = is_superuser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_staff() {
        return is_staff;
    }

    public void setIs_staff(boolean is_staff) {
        this.is_staff = is_staff;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getOccupation_name() {
        return occupation_name;
    }

    public void setOccupation_name(String occupation_name) {
        this.occupation_name = occupation_name;
    }

    public List<?> getGroups() {
        return groups;
    }

    public void setGroups(List<?> groups) {
        this.groups = groups;
    }

    public List<?> getUser_permissions() {
        return user_permissions;
    }

    public void setUser_permissions(List<?> user_permissions) {
        this.user_permissions = user_permissions;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id=" + id +
                ", physical_name='" + physical_name + '\'' +
                ", password='" + password + '\'' +
                ", last_login=" + last_login +
                ", is_superuser=" + is_superuser +
                ", username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", is_staff=" + is_staff +
                ", is_active=" + is_active +
                ", date_joined='" + date_joined + '\'' +
                ", sex=" + sex +
                ", occupation_name='" + occupation_name + '\'' +
                ", groups=" + groups +
                ", user_permissions=" + user_permissions +
                '}';
    }
}
