package com.fastdevelop.biz.web.controller;

import cn.hutool.core.util.ObjectUtil;
import com.fastdevelop.biz.web.util.UserUtil;
import com.fastdevelop.common.res.JsonResult;
import com.fastdevelop.dto.UserCreateDTO;
import com.fastdevelop.dto.UserDTO;
import com.fastdevelop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{


    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public JsonResult<Boolean> save(@RequestBody UserCreateDTO userCreateDTO) {
        Boolean aBoolean;
        if (ObjectUtil.isNotEmpty(userCreateDTO)) {
            aBoolean = userService.createUser(userCreateDTO);
        }else {
            aBoolean = userService.updateUser(userCreateDTO);
        }
        return aBoolean ? JsonResult.<Boolean>builder().success().build() : JsonResult.<Boolean>builder().failure().build();
    }


    @GetMapping("/listUser")
    public JsonResult<List<UserDTO>> listUsers(){

        String id = UserUtil.getUserJwtFromHeader(request).getId();
        log.info(id);
        List<UserDTO> userDTOList = userService.listUser();

        return JsonResult.<List<UserDTO>>builder().success(userDTOList).build();

    }

}
