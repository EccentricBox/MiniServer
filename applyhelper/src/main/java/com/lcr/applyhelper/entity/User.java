package com.lcr.applyhelper.entity;

public class User {
    public Integer userID;
    public String wechatID;
    public String userCountry;


    public User(int usersID) {
        super();
        this.userID = usersID;
    }

    public User() {
        super();
    }

    public Integer getUsersID() {
        return userID;
    }

    public void setUsersID(Integer usersID) {
        this.userID = usersID;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }


    public String getWechatID() {
        return wechatID;
    }

    public void setWechatID(String wechatID) {
        this.wechatID = wechatID;
    }

    @Override
    public String toString() {
        return "Users [usersID=" + userID + ", wechatID=" + wechatID
                + ", userCountry=" + userCountry + "]";
    }
}
