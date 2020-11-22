package com.example.dating_app02.model;

public class Profile {
    private int profile_id;
    private String profile_firstname;
    private String profile_lastname;
    private String profile_desc;
    private String profile_img;
    private int profile_matches;
    private String profile_matchTag;
    private String profile_mail;

    public Profile(String profile_firstname, String profile_lastname, String profile_desc, String profile_img, int profile_matches, String profile_matchTag, String profile_mail) {
        this.profile_firstname = profile_firstname;
        this.profile_lastname = profile_lastname;
        this.profile_desc = profile_desc;
        this.profile_img = profile_img;
        this.profile_matches = profile_matches;
        this.profile_matchTag = profile_matchTag;
        this.profile_mail = profile_mail;
    }

    public Profile(){

    }

    public String getProfile_mail() {
        return profile_mail;
    }

    public void setProfile_mail(String profile_mail) {
        this.profile_mail = profile_mail;
    }

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public String getProfile_firstname() {
        return profile_firstname;
    }

    public void setProfile_firstname(String profile_firstname) {
        this.profile_firstname = profile_firstname;
    }

    public String getProfile_lastname() {
        return profile_lastname;
    }

    public void setProfile_lastname(String profile_lastname) {
        this.profile_lastname = profile_lastname;
    }

    public String getProfile_desc() {
        return profile_desc;
    }

    public void setProfile_desc(String profile_desc) {
        this.profile_desc = profile_desc;
    }

    public String getProfile_img() {
        return profile_img;
    }

    public void setProfile_img(String profile_img) {
        this.profile_img = profile_img;
    }

    public int getProfile_matches() {
        return profile_matches;
    }

    public void setProfile_matches(int profile_matches) {
        this.profile_matches = profile_matches;
    }

    public String getProfile_matchTag() {
        return profile_matchTag;
    }

    public void setProfile_matchTag(String profile_matchTag) {
        this.profile_matchTag = profile_matchTag;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "profile_id=" + profile_id +
                ", profile_firstname='" + profile_firstname + '\'' +
                ", profile_lastname='" + profile_lastname + '\'' +
                ", profile_desc='" + profile_desc + '\'' +
                ", profile_img='" + profile_img + '\'' +
                ", profile_matches=" + profile_matches +
                ", profile_matchTag='" + profile_matchTag + '\'' +
                ", profile_mail='" + profile_mail + '\'' +
                '}';
    }
}

