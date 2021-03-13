package com.fastdevelop.biz.web.controller;

import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {
    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;
    //被@ModelAttribute注释的方法会在此controller每个方法执行前被执行
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {

        this.request = request;

        this.response = response;

        this.session = request.getSession();

    }


    public void response(Object data){
        try {
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(JSONUtil.toJsonStr(data));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
