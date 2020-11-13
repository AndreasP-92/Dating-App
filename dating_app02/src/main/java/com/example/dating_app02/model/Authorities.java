package com.example.dating_app02.model;

public class Authorities {
    String usermail;
    String authority;

    public Authorities(String usermail, String authority) {
        this.usermail = usermail;
        this.authority = authority;
    }

    public Authorities() {
    }

    public String getUsermail() {
        return usermail;
    }

    public String getAuthority() {
        return authority;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Authorities{" +
                "usermail='" + usermail + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
