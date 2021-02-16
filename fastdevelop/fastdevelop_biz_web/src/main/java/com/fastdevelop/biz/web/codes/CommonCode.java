package com.fastdevelop.biz.web.codes;

import com.fastdevelop.common.res.ResponseCode;

/**
 * 通用响应code
 *
 * @author lfy bennett
 * @date 2020/12/4 9:22
 */

public enum CommonCode implements ResponseCode {
    NO_LOGIN(Boolean.FALSE, 40000, "未登录请登录"),
    INVALID_TOKEN(Boolean.FALSE, 40001, "无效token"),
    OAUTH_TOKEN_MISSING(Boolean.FALSE, 40002, "token缺失"),
    OAUTH_TOKEN_DENIED(Boolean.FALSE, 40003, "权限不足"),
    ;
    private Boolean success;
    private Integer code;
    private String msg;


    CommonCode(Boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
