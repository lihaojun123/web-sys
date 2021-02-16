package com.fastdevelop.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class ProjectCreateDTO implements Serializable {
    private String id;
    private String title;
    private String subTitle;
    private Long userId;
    private String projectType;
    private String categoryId;
    private String img;
    private static final long serialVersionUID = 1L;
}