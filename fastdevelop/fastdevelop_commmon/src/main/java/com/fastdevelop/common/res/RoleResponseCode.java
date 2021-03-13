package com.fastdevelop.common.res;

/**
 * @author zhy
 * @since 2020/12/3 9:28
 */
public enum RoleResponseCode implements ResponseCode {

    ROLE_ALREADY_EXIST(Boolean.FALSE, 3001, "角色已存在！");

    private Boolean success;
    private Integer code;
    private String msg;


    RoleResponseCode(Boolean success, Integer code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }



    @Override
    public Boolean getSuccess() {
        return success;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
