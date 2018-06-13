package com.lcr.applyhelper.entity;

import java.io.Serializable;

/**
 * recommend
 * @author 
 */
public class Recommend implements Serializable {
    private Integer uniID;

    private String remImg;

    private static final long serialVersionUID = 1L;

    public Integer getUniID() {
        return uniID;
    }

    public void setUniID(Integer uniID) {
        this.uniID = uniID;
    }

    public String getRemImg() {
        return remImg;
    }

    public void setRemImg(String remImg) {
        this.remImg = remImg;
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
        Recommend other = (Recommend) that;
        return (this.getUniID() == null ? other.getUniID() == null : this.getUniID().equals(other.getUniID()))
            && (this.getRemImg() == null ? other.getRemImg() == null : this.getRemImg().equals(other.getRemImg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUniID() == null) ? 0 : getUniID().hashCode());
        result = prime * result + ((getRemImg() == null) ? 0 : getRemImg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uniID=").append(uniID);
        sb.append(", remImg=").append(remImg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}