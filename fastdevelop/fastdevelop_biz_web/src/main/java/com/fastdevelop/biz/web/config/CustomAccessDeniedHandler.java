package com.fastdevelop.biz.web.config;

import cn.hutool.json.JSONUtil;
import com.fastdevelop.biz.web.codes.CommonCode;
import com.fastdevelop.common.res.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("customAccessDeniedHandler")
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            response.getWriter().write(
                    JSONUtil.toJsonStr(JsonResult.<String>builder().failure(CommonCode.OAUTH_TOKEN_DENIED).build())
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
