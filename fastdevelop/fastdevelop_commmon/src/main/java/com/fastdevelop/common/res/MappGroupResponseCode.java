package com.fastdevelop.common.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 菜单管理服务的响应码
 */

@Getter
@AllArgsConstructor
public enum MappGroupResponseCode implements ResponseCode {

    /**
     * 菜单创建失败
     */
    CREATE_FAIL(Boolean.FALSE, 5001, "菜单创建失败！"),
    CREATE_RELA_FAIL(Boolean.FALSE, 5002, "权限添加失败！"),
    UPDATE_FAIL(Boolean.FALSE, 5003, "菜单更新失败!"),
    UPDATE_RELA_FAIL(Boolean.FALSE, 5004, "不能失败!"),
    DELETE_FAIL(Boolean.FALSE, 5005, "菜单删除失败!"),
    UPDATE_CANNOT(Boolean.FALSE, 5006, "此菜单不能编辑!"),
    MENU_NOT_EXIST(Boolean.FALSE, 5007, "菜单不存在！"),
    APP_EXCEEDS_MAXIMUM_LIMIT(Boolean.FALSE, 5008, "常用功能下的APP超过最大限制!"),
    CANNOT_CREATE_MENU(Boolean.FALSE, 5009, "一级菜单下不能关联应用!");

    private final Boolean success;
    private final Integer code;
    private final String msg;
}
