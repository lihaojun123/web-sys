package com.fastdevelop.db.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class ChapterDTO implements Serializable {
    private String chapterId;
    private String chapterName;
    private List<ChapterDTO> children;
    private String pId;
    private String
            chapterType;
    private Long num;

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getChapterType() {
        return chapterType;
    }

    public void setChapterType(String chapterType) {
        this.chapterType = chapterType;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }
}
