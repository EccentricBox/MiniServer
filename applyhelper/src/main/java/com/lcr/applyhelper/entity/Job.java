package com.lcr.applyhelper.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * job
 * @author 
 */
public class Job implements Serializable {
    private Integer jobID;

    private String jobTitle;

    private String city;

    private String company;

    private String salary;

    private String worktime;

    private String requirement;

    private String address;

    private String publishTime;

    private String logoUrl;

    private String contacts;

    private Integer peopleNum;

    private String workcontent;

    private static final long serialVersionUID = 1L;

    public Integer getJobID() {
        return jobID;
    }

    public void setJobID(Integer jobID) {
        this.jobID = jobID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWorktime() {
        return worktime;
    }

    public void setWorktime(String worktime) {
        this.worktime = worktime;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getWorkcontent() {
        return workcontent;
    }

    public void setWorkcontent(String workcontent) {
        this.workcontent = workcontent;
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
        Job other = (Job) that;
        return (this.getJobID() == null ? other.getJobID() == null : this.getJobID().equals(other.getJobID()))
            && (this.getJobTitle() == null ? other.getJobTitle() == null : this.getJobTitle().equals(other.getJobTitle()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany()))
            && (this.getSalary() == null ? other.getSalary() == null : this.getSalary().equals(other.getSalary()))
            && (this.getWorktime() == null ? other.getWorktime() == null : this.getWorktime().equals(other.getWorktime()))
            && (this.getRequirement() == null ? other.getRequirement() == null : this.getRequirement().equals(other.getRequirement()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getContacts() == null ? other.getContacts() == null : this.getContacts().equals(other.getContacts()))
            && (this.getLogoUrl() == null ? other.getLogoUrl() == null : this.getLogoUrl().equals(other.getLogoUrl()))
            && (this.getPublishTime() == null ? other.getPublishTime() == null : this.getPublishTime().equals(other.getPublishTime()))
            && (this.getWorkcontent() == null ? other.getWorkcontent() == null : this.getWorkcontent().equals(other.getWorkcontent()))
            && (this.getPeopleNum() == null ? other.getPeopleNum() == null : this.getPeopleNum().equals(other.getPeopleNum()));
    }

    @Override
    public int hashCode() {

        return Objects.hash(jobID, jobTitle, city, company, salary, worktime, requirement, address, publishTime, logoUrl, contacts, peopleNum, workcontent);
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobID=" + jobID +
                ", jobTitle='" + jobTitle + '\'' +
                ", city='" + city + '\'' +
                ", company='" + company + '\'' +
                ", salary='" + salary + '\'' +
                ", worktime='" + worktime + '\'' +
                ", requirement='" + requirement + '\'' +
                ", address='" + address + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", contacts='" + contacts + '\'' +
                ", peopleNum=" + peopleNum +
                ", workcontent='" + workcontent + '\'' +
                '}';
    }
}