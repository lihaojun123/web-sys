package com.fastdevelop.db.model;

import java.io.Serializable;

public class ChapterDO implements Serializable {
    /**
     * 章节id
     */
    private String id;

    /**
     * 章节父id
     */
    private String pId;

    /**
     * 章节内容
     */
    private String title;

    /**
     * 章节类型，1代表章，2代表节
     */
    private String chapterType;

    /**
     * 顺序
     */
    private Long num;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChapterType() {
        return chapterType;
    }

    public void setChapterType(String chapterType) {
        this.chapterType = chapterType;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}