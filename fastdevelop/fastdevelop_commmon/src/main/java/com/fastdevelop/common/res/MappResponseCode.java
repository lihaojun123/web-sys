package com.fastdevelop.common.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 应用管理服务的响应码
 * @author bennett
 * @since 2020/12/4
 */

@Getter
@AllArgsConstructor
public enum MappResponseCode implements ResponseCode {

    /**
     * 应用创建失败
     */
    CREATE_FAIL(Boolean.FALSE, 4001, "应用创建失败！"),
    CREATE_RELA_FAIL(Boolean.FALSE, 4002, "权限添加失败！"),
    UPDATE_FAIL(Boolean.FALSE, 4003, "应用更新失败!"),
    UPDATE_RELA_FAIL(Boolean.FALSE, 4004, "权限更新失败!"),
    DELETE_FAIL(Boolean.FALSE, 4005, "应用删除失败!"),
    GET_UPLOAD_TOKEN_FAIL(Boolean.FALSE, 4006, "获取临时上传凭证失败!"),
    ILLEGAL_ROLE(Boolean.FALSE, 4007, "存在角色非法!!!"),
    ILLEGAL_APP(Boolean.FALSE, 4008, "不存在的非法应用!");

    private final Boolean success;
    private final Integer code;
    private final String msg;
}
