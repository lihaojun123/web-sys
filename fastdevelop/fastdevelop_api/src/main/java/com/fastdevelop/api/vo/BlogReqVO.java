package com.fastdevelop.api.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class BlogReqVO implements Serializable {
    private String id;
    private String title;
    private String subTitle;
    private String img;
    private String categoryId;
    private Date createTime;
    private Date updateTime;
    private static final long serialVersionUID = 1L;
}
