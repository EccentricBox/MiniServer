package com.lcr.applyhelper.entity;

import java.io.Serializable;

/**
 * article
 * @author 
 */
public class Article implements Serializable {
    private Integer articleID;

    private Integer articletype;

    private String articleTitle;

    private String picUrl;

    private String publishedDate;

    private String contentUrl;

    private String readNum;

    private static final long serialVersionUID = 1L;

    public Integer getArticleID() {
        return articleID;
    }

    public void setArticleID(Integer articleID) {
        this.articleID = articleID;
    }

    public Integer getArticletype() {
        return articletype;
    }

    public void setArticletype(Integer articletype) {
        this.articletype = articletype;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getReadNum() {
        return readNum;
    }

    public void setReadNum(String readNum) {
        this.readNum = readNum;
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
        Article other = (Article) that;
        return (this.getArticleID() == null ? other.getArticleID() == null : this.getArticleID().equals(other.getArticleID()))
            && (this.getArticletype() == null ? other.getArticletype() == null : this.getArticletype().equals(other.getArticletype()))
            && (this.getArticleTitle() == null ? other.getArticleTitle() == null : this.getArticleTitle().equals(other.getArticleTitle()))
            && (this.getPicUrl() == null ? other.getPicUrl() == null : this.getPicUrl().equals(other.getPicUrl()))
            && (this.getPublishedDate() == null ? other.getPublishedDate() == null : this.getPublishedDate().equals(other.getPublishedDate()))
            && (this.getContentUrl() == null ? other.getContentUrl() == null : this.getContentUrl().equals(other.getContentUrl()))
            && (this.getReadNum() == null ? other.getReadNum() == null : this.getReadNum().equals(other.getReadNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getArticleID() == null) ? 0 : getArticleID().hashCode());
        result = prime * result + ((getArticletype() == null) ? 0 : getArticletype().hashCode());
        result = prime * result + ((getArticleTitle() == null) ? 0 : getArticleTitle().hashCode());
        result = prime * result + ((getPicUrl() == null) ? 0 : getPicUrl().hashCode());
        result = prime * result + ((getPublishedDate() == null) ? 0 : getPublishedDate().hashCode());
        result = prime * result + ((getContentUrl() == null) ? 0 : getContentUrl().hashCode());
        result = prime * result + ((getReadNum() == null) ? 0 : getReadNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", articleID=").append(articleID);
        sb.append(", articletype=").append(articletype);
        sb.append(", articleTitle=").append(articleTitle);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", publishedDate=").append(publishedDate);
        sb.append(", contentUrl=").append(contentUrl);
        sb.append(", readNum=").append(readNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}