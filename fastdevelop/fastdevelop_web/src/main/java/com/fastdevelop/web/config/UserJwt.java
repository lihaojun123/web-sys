package com.fastdevelop.web.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class UserJwt extends User {
    private String id;
    private String name;
    private String username;
    private String userpic;
    private String utype;
    private String companyId;
    private Object commentEmailOn;
    private String email;
    private String mobile;
    private List<String> permissions;

    public UserJwt(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

}
