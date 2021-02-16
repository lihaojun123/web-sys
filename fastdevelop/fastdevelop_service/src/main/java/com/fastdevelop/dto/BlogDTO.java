package com.fastdevelop.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class BlogDTO implements Serializable {
    private String id;
    private String title;
    private String subTitle;
    private String img;
    private String categoryId;
    private String createTime;
    private String updateTime;
    private static final long serialVersionUID = 1L;
}
