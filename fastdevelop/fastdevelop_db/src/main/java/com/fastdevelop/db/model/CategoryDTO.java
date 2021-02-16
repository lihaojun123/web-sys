package com.fastdevelop.db.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class CategoryDTO implements Serializable {
    private String value;
    private String label;
    private List<CategoryDTO> children;
    private String pId;
    private String description;

}
