package com.fastdevelop.db.model;

import java.io.Serializable;
import java.util.Date;

public class CategoryDO implements Serializable {
    /**
    * 分类id
    */
    private String id;

    /**
    * 分类名称
    */
    private String name;

    /**
    * 父分类id
    */
    private String pId;

    /**
    * 分类描述
    */
    private String description;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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