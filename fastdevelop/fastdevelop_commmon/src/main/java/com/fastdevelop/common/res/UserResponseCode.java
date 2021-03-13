package com.fastdevelop.common.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户服务的响应码
 * @author zhang
 * @since 2020/12/8
 */

@Getter
@AllArgsConstructor
public enum UserResponseCode implements ResponseCode {

    /**
     * 失败
     */
    PARAMS_VALID_ERROR(Boolean.FALSE, -1, "参数校验异常"),
    ROLE_NOEXIST(Boolean.FALSE, 4001, "角色不一致"),
    CREATE_FAIL(Boolean.FALSE, 4001, "应用创建失败！"),
    CREATE_RELA_FAIL(Boolean.FALSE, 4002, "权限添加失败！"),
    UPDATE_FAIL(Boolean.FALSE, 4003, "应用更新失败!"),
    UPDATE_RELA_FAIL(Boolean.FALSE, 4004, "权限更新失败!"),
    DELETE_FAIL(Boolean.FALSE, 4005, "应用删除失败!"),

    /**
     * excel失败
     */
    EXCEL_NOT_EXISTS(Boolean.FALSE, 4007, "请选择EXCEL!"),
    EXCEL_ANALYSIS(Boolean.FALSE, 4006, "解析数据出错!"),
    EXCEL_EXPORT_PARAM(Boolean.FALSE, 4008, "导出参数错误!");


    private final Boolean success;
    private final Integer code;
    private final String msg;
}
