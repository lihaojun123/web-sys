package com.fastdevelop.db.model;

import java.io.Serializable;
import java.util.Date;

public class UserDO implements Serializable {
    /**
    * 用户id
    */
    private Long id;

    /**
    * 用户名称
    */
    private String username;

    /**
    * 用户昵称
    */
    private String nickname;

    /**
    * 用户密码
    */
    private String password;

    /**
    * 手机号码
    */
    private String mobile;

    /**
    * 用户头像
    */
    private String userpic;

    /**
    * 用户邮箱
    */
    private String email;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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