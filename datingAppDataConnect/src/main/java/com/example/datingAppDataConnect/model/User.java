package com.example.datingAppDataConnect.model;

public class User {
    private int     user_id;
    private String  user_mail;
    private String  user_password;
    private int     user_phone;
    private String  user_date;
    private int     active;

    public User(String user_mail, String user_password, int user_phone, String user_date, int active) {
        this.user_mail      = user_mail;
        this.user_password  = user_password;
        this.user_phone     = user_phone;
        this.user_date      = user_date;
        this.active         = active;
    }

    public User() {

    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_phone(int user_phone) {
        this.user_phone = user_phone;
    }

    public void setUser_date(String user_date) {
        this.user_date = user_date;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public String getUser_password() {
        return user_password;
    }

    public int getUser_phone() {
        return user_phone;
    }

    public String getUser_date() {
        return user_date;
    }

    public int getActive() {
        return active;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_mail='" + user_mail + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_phone=" + user_phone +
                ", user_date='" + user_date + '\'' +
                ", active=" + active +
                '}';
    }
}
