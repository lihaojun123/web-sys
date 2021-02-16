package com.fastdevelop.dto;

import com.fastdevelop.db.model.ChapterDTO;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
public class ProjectDTO implements Serializable {
    private String id;
    private Date createTime;
    private Date updateTime;
    private String title;
    private String subTitle;
    private Long userId;
    private String username;
    private String projectType;
    private String projectTypeName;
    private String categoryId;
    private String categoryName;
    private String img;
    private List<String> categoryList;
    private List<ChapterDTO> chapterDTOList;
    private static final long serialVersionUID = 1L;
}