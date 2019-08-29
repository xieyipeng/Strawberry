package com.xieyipeng.IntelligentStrawberry.model;

public class Admin {
    Integer admin_id;
    String admin_username;
    String admin_password;
    String admin_telephone;

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id='" + admin_id + '\'' +
                ", admin_username='" + admin_username + '\'' +
                ", admin_password='" + admin_password + '\'' +
                ", admin_telephone='" + admin_telephone + '\'' +
                '}';
    }


    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_telephone() {
        return admin_telephone;
    }

    public void setAdmin_telephone(String admin_telephone) {
        this.admin_telephone = admin_telephone;
    }

    public Admin(Integer admin_id, String admin_username, String admin_password, String admin_telephone) {
        this.admin_id = admin_id;
        this.admin_username = admin_username;
        this.admin_password = admin_password;
        this.admin_telephone = admin_telephone;
    }
}
