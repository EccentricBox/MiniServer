package com.lcr.applyhelper.entity;

import java.io.Serializable;

/**
 * unimajor
 * @author 
 */
public class UnimajorKey implements Serializable {
    private Integer majorID;

    private Integer uniID;

    private static final long serialVersionUID = 1L;

    public Integer getMajorID() {
        return majorID;
    }

    public void setMajorID(Integer majorID) {
        this.majorID = majorID;
    }

    public Integer getUniID() {
        return uniID;
    }

    public void setUniID(Integer uniID) {
        this.uniID = uniID;
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
        UnimajorKey other = (UnimajorKey) that;
        return (this.getMajorID() == null ? other.getMajorID() == null : this.getMajorID().equals(other.getMajorID()))
            && (this.getUniID() == null ? other.getUniID() == null : this.getUniID().equals(other.getUniID()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMajorID() == null) ? 0 : getMajorID().hashCode());
        result = prime * result + ((getUniID() == null) ? 0 : getUniID().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", majorID=").append(majorID);
        sb.append(", uniID=").append(uniID);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}