package com.fastdevelop.biz.web.util;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class UserUtil {

    public static UserJwt getUserJwtFromHeader(HttpServletRequest request){
        Map<String, String> jwtClaims = Oauth2Util.getJwtClaimsFromHeader(request);
        if(jwtClaims == null || StringUtils.isEmpty(jwtClaims.get("id"))){
            return null;
        }
        UserJwt userJwt = new UserJwt();
        userJwt.setId(jwtClaims.get("id"));
        userJwt.setName(jwtClaims.get("name"));
        userJwt.setCompanyId(jwtClaims.get("companyId"));
        userJwt.setUtype(jwtClaims.get("utype"));
        userJwt.setUserpic(jwtClaims.get("userpic"));
        userJwt.setUsername(jwtClaims.get("username"));
        userJwt.setCommentEmailOn(jwtClaims.get("userExtCommentEmailOn"));
        userJwt.setEmail(jwtClaims.get("email"));
        return userJwt;
    }

    @Data
    public static class UserJwt{
        private String id;
        private String name;
        private String userpic;
        private String utype;
        private String companyId;
        private String username;
        private Object commentEmailOn;
        private String email;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Object getCommentEmailOn() {
            return commentEmailOn;
        }

        public void setCommentEmailOn(Object commentEmailOn) {
            this.commentEmailOn = commentEmailOn;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUserpic() {
            return userpic;
        }

        public void setUserpic(String userpic) {
            this.userpic = userpic;
        }

        public String getUtype() {
            return utype;
        }

        public void setUtype(String utype) {
            this.utype = utype;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }
    }

}
