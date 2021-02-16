package com.fastdevelop.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CustomUserAuthenticationConverter extends DefaultUserAuthenticationConverter {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    MyClientDetailsService myClientDetailsService;


    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {

        Map response  = new LinkedHashMap();
        String name = authentication.getName();
        response.put("username", name);


        Object principal = authentication.getPrincipal();
        UserJwt userJwt = null;
        if(principal instanceof  UserJwt){
            //这里应该是，如果采用用户名密码登录，封装jwt负载内容
            userJwt = (UserJwt) principal;
            response.put("name", userJwt.getName());
            response.put("id", userJwt.getId());
            response.put("utype",userJwt.getUtype());
            response.put("userpic",userJwt.getUserpic());
            response.put("companyId",userJwt.getCompanyId());
            response.put("mobile",userJwt.getMobile());
            if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
                response.put("authorities", AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
            }
        }else{
            ClientDetails clientDetails = myClientDetailsService.loadClientByClientId(name);
            Collection<GrantedAuthority> authorities = clientDetails.getAuthorities();
            if (authorities != null && !authorities.isEmpty()) {
                response.put("authorities", AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
            }
        }
        return response;
    }
}
