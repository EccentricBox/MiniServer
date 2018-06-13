package com.lcr.applyhelper.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * users
 * @author 
 */
public class User implements Serializable {

    @JsonProperty(value = "wechatID")
    private String wechatID;
    @JsonProperty(value = "userID")
    private String userID;
    @JsonProperty(value = "userhead")
    private String userhead;
    @JsonProperty(value = "userCountry")
    private String userCountry;
    @JsonProperty(value = "userType")
    private Integer userType;
    @JsonProperty(value = "cerType")
    private Integer cerType;
    @JsonProperty(value = "certificate")
    private String certificate;
    @JsonProperty(value = "realName")
    private String realName;
    @JsonProperty(value = "university")
    private String university;
    @JsonProperty(value = "major")
    private String major;
    @JsonProperty(value = "stuType")
    private String stuType;
    @JsonProperty(value = "grade")
    private String grade;
    @JsonProperty(value = "sex")
    private String sex;
    @JsonProperty(value = "age")
    private String age;
    @JsonProperty(value = "fee")
    private String fee;

    private static final long serialVersionUID = 1L;

    public String getWechatID() {
        return wechatID;
    }

    public void setWechatID(String wechatID) {
        this.wechatID = wechatID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserhead() {
        return userhead;
    }

    public void setUserhead(String userhead) {
        this.userhead = userhead;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public void setUserCountry(String userCountry) {
        this.userCountry = userCountry;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getCerType() {
        return cerType;
    }

    public void setCerType(Integer cerType) {
        this.cerType = cerType;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStuType() {
        return stuType;
    }

    public void setStuType(String stuType) {
        this.stuType = stuType;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getWechatID() == null ? other.getWechatID() == null : this.getWechatID().equals(other.getWechatID()))
            && (this.getUserID() == null ? other.getUserID() == null : this.getUserID().equals(other.getUserID()))
            && (this.getUserhead() == null ? other.getUserhead() == null : this.getUserhead().equals(other.getUserhead()))
            && (this.getUserCountry() == null ? other.getUserCountry() == null : this.getUserCountry().equals(other.getUserCountry()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getCerType() == null ? other.getCerType() == null : this.getCerType().equals(other.getCerType()))
            && (this.getCertificate() == null ? other.getCertificate() == null : this.getCertificate().equals(other.getCertificate()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getUniversity() == null ? other.getUniversity() == null : this.getUniversity().equals(other.getUniversity()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getStuType() == null ? other.getStuType() == null : this.getStuType().equals(other.getStuType()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getFee() == null ? other.getFee() == null : this.getFee().equals(other.getFee()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWechatID() == null) ? 0 : getWechatID().hashCode());
        result = prime * result + ((getUserID() == null) ? 0 : getUserID().hashCode());
        result = prime * result + ((getUserhead() == null) ? 0 : getUserhead().hashCode());
        result = prime * result + ((getUserCountry() == null) ? 0 : getUserCountry().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getCerType() == null) ? 0 : getCerType().hashCode());
        result = prime * result + ((getCertificate() == null) ? 0 : getCertificate().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getUniversity() == null) ? 0 : getUniversity().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getStuType() == null) ? 0 : getStuType().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getFee() == null) ? 0 : getFee().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", wechatID=").append(wechatID);
        sb.append(", userID=").append(userID);
        sb.append(", userID=").append(userhead);
        sb.append(", userCountry=").append(userCountry);
        sb.append(", userType=").append(userType);
        sb.append(", cerType=").append(cerType);
        sb.append(", certificate=").append(certificate);
        sb.append(", realName=").append(realName);
        sb.append(", university=").append(university);
        sb.append(", major=").append(major);
        sb.append(", stuType=").append(stuType);
        sb.append(", grade=").append(grade);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", fee=").append(fee);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}