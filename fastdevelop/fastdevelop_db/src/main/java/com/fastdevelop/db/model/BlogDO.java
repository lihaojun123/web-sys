package com.fastdevelop.db.model;

import java.io.Serializable;
import java.util.Date;

public class BlogDO implements Serializable {
    /**
    * 博客id
    */
    private String id;

    /**
    * 博客标题
    */
    private String title;

    /**
    * 博客副标题
    */
    private String subTitle;

    /**
    * 博客封面图片
    */
    private String img;

    /**
    * 博客分类
    */
    private String categoryId;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}