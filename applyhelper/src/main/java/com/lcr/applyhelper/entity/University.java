package com.lcr.applyhelper.entity;

import java.io.Serializable;

/**
 * university
 * @author 
 */
public class University implements Serializable {
    private Integer uniID;

    private String uniName;

    private String badge;

    private String level;

    private String province;

    private String city;

    private Integer rank;

    private String programNum;

    private String stuNum;

    private String introduction;

    private String dormitory;

    private String environment;

    private String fun;

    private String video;

    private String image;

    private static final long serialVersionUID = 1L;

    public Integer getUniID() {
        return uniID;
    }

    public void setUniID(Integer uniID) {
        this.uniID = uniID;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getProgramNum() {
        return programNum;
    }

    public void setProgramNum(String programNum) {
        this.programNum = programNum;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDormitory() {
        return dormitory;
    }

    public void setDormitory(String dormitory) {
        this.dormitory = dormitory;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getFun() {
        return fun;
    }

    public void setFun(String fun) {
        this.fun = fun;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        University other = (University) that;
        return (this.getUniID() == null ? other.getUniID() == null : this.getUniID().equals(other.getUniID()))
            && (this.getUniName() == null ? other.getUniName() == null : this.getUniName().equals(other.getUniName()))
            && (this.getBadge() == null ? other.getBadge() == null : this.getBadge().equals(other.getBadge()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getRank() == null ? other.getRank() == null : this.getRank().equals(other.getRank()))
            && (this.getProgramNum() == null ? other.getProgramNum() == null : this.getProgramNum().equals(other.getProgramNum()))
            && (this.getStuNum() == null ? other.getStuNum() == null : this.getStuNum().equals(other.getStuNum()))
            && (this.getIntroduction() == null ? other.getIntroduction() == null : this.getIntroduction().equals(other.getIntroduction()))
            && (this.getDormitory() == null ? other.getDormitory() == null : this.getDormitory().equals(other.getDormitory()))
            && (this.getEnvironment() == null ? other.getEnvironment() == null : this.getEnvironment().equals(other.getEnvironment()))
            && (this.getFun() == null ? other.getFun() == null : this.getFun().equals(other.getFun()))
            && (this.getVideo() == null ? other.getVideo() == null : this.getVideo().equals(other.getVideo()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUniID() == null) ? 0 : getUniID().hashCode());
        result = prime * result + ((getUniName() == null) ? 0 : getUniName().hashCode());
        result = prime * result + ((getBadge() == null) ? 0 : getBadge().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getRank() == null) ? 0 : getRank().hashCode());
        result = prime * result + ((getProgramNum() == null) ? 0 : getProgramNum().hashCode());
        result = prime * result + ((getStuNum() == null) ? 0 : getStuNum().hashCode());
        result = prime * result + ((getIntroduction() == null) ? 0 : getIntroduction().hashCode());
        result = prime * result + ((getDormitory() == null) ? 0 : getDormitory().hashCode());
        result = prime * result + ((getEnvironment() == null) ? 0 : getEnvironment().hashCode());
        result = prime * result + ((getFun() == null) ? 0 : getFun().hashCode());
        result = prime * result + ((getVideo() == null) ? 0 : getVideo().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uniID=").append(uniID);
        sb.append(", badge=").append(badge);
        sb.append(", level=").append(level);
        sb.append(", uniName=").append(uniName);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", rank=").append(rank);
        sb.append(", programNum=").append(programNum);
        sb.append(", stuNum=").append(stuNum);
        sb.append(", introduction=").append(introduction);
        sb.append(", dormitory=").append(dormitory);
        sb.append(", environment=").append(environment);
        sb.append(", fun=").append(fun);
        sb.append(", video=").append(video);
        sb.append(", image=").append(image);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}