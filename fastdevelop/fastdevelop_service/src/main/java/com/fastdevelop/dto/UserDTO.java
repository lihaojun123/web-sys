package com.fastdevelop.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class UserDTO implements Serializable {
    private Long id;
    private String username;
    private String nickname;
    private String password;
    private String mobile;
    private String userpic;
    private String email;
    private Date createTime;
    private Date updateTime;
}
