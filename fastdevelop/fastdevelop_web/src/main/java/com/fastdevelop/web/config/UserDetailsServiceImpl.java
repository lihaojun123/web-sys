package com.fastdevelop.web.config;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.fastdevelop.dto.UserDTO;
import com.fastdevelop.service.UserService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    MyClientDetailsService myClientDetailsService;

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //取出身份，如果身份为空说明没有认证
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //没有认证统一采用httpbasic认证，httpbasic中存储了client_id和client_secret，开始认证client_id和client_secret
        if(authentication==null){
            ClientDetails clientDetails = myClientDetailsService.loadClientByClientId(username);
            if(clientDetails!=null){
                //密码
                Collection<GrantedAuthority> grantedAuthorities = clientDetails.getAuthorities();
                System.out.println(JSONUtil.toJsonPrettyStr(grantedAuthorities));
                String clientSecret = clientDetails.getClientSecret();
                return new User(username,clientSecret, AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.join(grantedAuthorities.toArray(), ",")));
            }
        }

        if (StringUtils.isEmpty(username)) {
            return null;
        }

        UserDTO userDTO = userService.detail(username);

        if (ObjectUtil.isEmpty(userDTO)) {
            return null;
        }
        List<String> permissions = Lists.newArrayList("user");
        List<String> user_permission = new ArrayList<>();
        permissions.forEach(item-> user_permission.add(item));
        String user_permission_string  = StringUtils.join(user_permission.toArray(), ",");
        UserJwt userDetails = new UserJwt(username,
                userDTO.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(user_permission_string));
        userDetails.setId(userDTO.getId()+"");
        userDetails.setName(userDTO.getNickname());//用户名称
        userDetails.setUserpic(userDTO.getUserpic());//用户头像
        userDetails.setMobile(userDTO.getMobile());
        return userDetails;
    }
}
