package com.fastdevelop.common.res;

/**
 * 通用响应code
 *
 * @author lfy bennett
 * @date 2020/12/4 9:22
 */

public enum CommonResponseCode implements ResponseCode {
    /**
     * 成功
     */
    SUCCESS(Boolean.TRUE, 0, "成功"),
    /**
     * 失败
     */
    FAILURE(Boolean.FALSE, 1, "失败"),
    /**
     * 请求超时
     */
    REQ_TIMEOUT(Boolean.FALSE, -100, "请求超时"),
    /**
     * 鉴权失败
     */
    AUTH_FAILED(Boolean.FALSE, -200, "鉴权失败"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR(Boolean.FALSE, 99999, "系统异常"),
    /**
     * 参数校验异常
     */
    PARAMS_VALID_ERROR(Boolean.FALSE, -1, "参数校验异常"),
    COOKIE_UID_IS_EMPTY(Boolean.FALSE, 400010, "认证信息获取失败(COOKIE_UID_IS_EMPTY ),请重新登录"),
    ;
    private Boolean success;
    private Integer code;
    private String msg;


    CommonResponseCode(Boolean success, Integer code, String msg) {
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
