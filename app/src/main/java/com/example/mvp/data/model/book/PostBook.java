package com.example.mvp.data.model.book;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostBook {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("PageCount")
    @Expose
    private Integer pageCount;
    @SerializedName("Excerpt")
    @Expose
    private String excerpt;
    @SerializedName("PublishDate")
    @Expose
    private String publishDate;

    public PostBook(int id, int pageCount, String title, String descripation, String excerpt, String publishDate) {
        this.iD = id;
        this.pageCount = pageCount;
        this.title = title;
        this.description = descripation;
        this.excerpt = excerpt;
        this.publishDate = publishDate;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
