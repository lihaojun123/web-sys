package com.fastdevelop.biz.web.config;

import cn.hutool.json.JSONUtil;
import com.fastdevelop.biz.web.codes.CommonCode;
import com.fastdevelop.common.res.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component("authExceptionEntryPoint")
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint
{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws ServletException {
        Map<String, Object> map = new HashMap<String, Object>();
        Throwable cause = authException.getCause();

        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            if(cause instanceof InvalidTokenException) {
                response.getWriter().write(
                        JSONUtil.toJsonStr(JsonResult.<String>builder().failure(CommonCode.INVALID_TOKEN).build())
                );
            }else{
                response.getWriter().write(
                        JSONUtil.toJsonStr(JsonResult.<String>builder().failure(CommonCode.OAUTH_TOKEN_MISSING).build())
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

