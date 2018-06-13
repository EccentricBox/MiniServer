package com.lcr.applyhelper.entity;

import java.io.Serializable;

/**
 * order
 * @author 
 */
public class OrderKey implements Serializable {
    private String userID;

    private String helperID;

    private static final long serialVersionUID = 1L;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getHelperID() {
        return helperID;
    }

    public void setHelperID(String helperID) {
        this.helperID = helperID;
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
        OrderKey other = (OrderKey) that;
        return (this.getUserID() == null ? other.getUserID() == null : this.getUserID().equals(other.getUserID()))
            && (this.getHelperID() == null ? other.getHelperID() == null : this.getHelperID().equals(other.getHelperID()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserID() == null) ? 0 : getUserID().hashCode());
        result = prime * result + ((getHelperID() == null) ? 0 : getHelperID().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userID=").append(userID);
        sb.append(", helperID=").append(helperID);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}