package com.lcr.applyhelper.entity;

import java.io.Serializable;

/**
 * remajor
 * @author 
 */
public class Remajor implements Serializable {
    private Integer majorID;

    private String majorName;

    private String majorImg;

    private String details;

    private static final long serialVersionUID = 1L;

    public Integer getMajorID() {
        return majorID;
    }

    public void setMajorID(Integer majorID) {
        this.majorID = majorID;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorImg() {
        return majorImg;
    }

    public void setMajorImg(String majorImg) {
        this.majorImg = majorImg;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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
        Remajor other = (Remajor) that;
        return (this.getMajorID() == null ? other.getMajorID() == null : this.getMajorID().equals(other.getMajorID()))
            && (this.getMajorName() == null ? other.getMajorName() == null : this.getMajorName().equals(other.getMajorName()))
            && (this.getMajorImg() == null ? other.getMajorImg() == null : this.getMajorImg().equals(other.getMajorImg()))
            && (this.getDetails() == null ? other.getDetails() == null : this.getDetails().equals(other.getDetails()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMajorID() == null) ? 0 : getMajorID().hashCode());
        result = prime * result + ((getMajorName() == null) ? 0 : getMajorName().hashCode());
        result = prime * result + ((getMajorImg() == null) ? 0 : getMajorImg().hashCode());
        result = prime * result + ((getDetails() == null) ? 0 : getDetails().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", majorID=").append(majorID);
        sb.append(", majorName=").append(majorName);
        sb.append(", majorImg=").append(majorImg);
        sb.append(", details=").append(details);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}