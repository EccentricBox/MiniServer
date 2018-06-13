package com.lcr.applyhelper.entity;

import java.io.Serializable;

/**
 * jobapply
 * @author 
 */
public class JobapplyKey implements Serializable {
    private String userID;

    private Integer jobID;

    private static final long serialVersionUID = 1L;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Integer getJobID() {
        return jobID;
    }

    public void setJobID(Integer jobID) {
        this.jobID = jobID;
    }

    public JobapplyKey(String userID, Integer jobID) {
        this.userID = userID;
        this.jobID = jobID;
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
        JobapplyKey other = (JobapplyKey) that;
        return (this.getUserID() == null ? other.getUserID() == null : this.getUserID().equals(other.getUserID()))
            && (this.getJobID() == null ? other.getJobID() == null : this.getJobID().equals(other.getJobID()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserID() == null) ? 0 : getUserID().hashCode());
        result = prime * result + ((getJobID() == null) ? 0 : getJobID().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userID=").append(userID);
        sb.append(", jobID=").append(jobID);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}