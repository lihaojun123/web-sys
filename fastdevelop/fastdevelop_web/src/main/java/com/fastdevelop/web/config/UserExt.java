package com.fastdevelop.web.config;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


@Data
@ToString
public class UserExt implements Serializable {
    private String id;
    private String username;
    private String name;
    private String password;
    private String userpic;
    private String utype;
    private String mobile;
    private List<String> permissions;
}
