package com.lcr.applyhelper.entity;

import java.io.Serializable;

/**
 * jobapply
 * @author 
 */
public class JobApply extends JobapplyKey implements Serializable {
    private Integer applystatus;

    private String startdate;

    private String stopdate;

    private static final long serialVersionUID = 1L;

    public JobApply(String userID, Integer jobID) {
        super(userID, jobID);
    }

    public JobApply(String userID, Integer jobID, Integer applystatus, String startdate, String stopdate) {
        super(userID, jobID);
        this.applystatus = applystatus;
        this.startdate = startdate;
        this.stopdate = stopdate;
    }

    public Integer getApplystatus() {
        return applystatus;
    }

    public void setApplystatus(Integer applystatus) {
        this.applystatus = applystatus;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getStopdate() {
        return stopdate;
    }

    public void setStopdate(String stopdate) {
        this.stopdate = stopdate;
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
        JobApply other = (JobApply) that;
        return (this.getUserID() == null ? other.getUserID() == null : this.getUserID().equals(other.getUserID()))
            && (this.getJobID() == null ? other.getJobID() == null : this.getJobID().equals(other.getJobID()))
            && (this.getApplystatus() == null ? other.getApplystatus() == null : this.getApplystatus().equals(other.getApplystatus()))
            && (this.getStartdate() == null ? other.getStartdate() == null : this.getStartdate().equals(other.getStartdate()))
            && (this.getStopdate() == null ? other.getStopdate() == null : this.getStopdate().equals(other.getStopdate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserID() == null) ? 0 : getUserID().hashCode());
        result = prime * result + ((getJobID() == null) ? 0 : getJobID().hashCode());
        result = prime * result + ((getApplystatus() == null) ? 0 : getApplystatus().hashCode());
        result = prime * result + ((getStartdate() == null) ? 0 : getStartdate().hashCode());
        result = prime * result + ((getStopdate() == null) ? 0 : getStopdate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", applystatus=").append(applystatus);
        sb.append(", startdate=").append(startdate);
        sb.append(", stopdate=").append(stopdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}