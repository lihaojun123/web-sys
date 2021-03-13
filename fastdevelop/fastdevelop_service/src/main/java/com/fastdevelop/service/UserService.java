package com.fastdevelop.service;

import cn.hutool.core.collection.CollectionUtil;
import com.fastdevelop.convert.UserConvert;
import com.fastdevelop.db.mapper.UserDOMapper;
import com.fastdevelop.db.model.UserDO;
import com.fastdevelop.dto.UserCreateDTO;
import com.fastdevelop.dto.UserDTO;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Resource
    private UserDOMapper userDOMapper;
    @Resource
    private UserConvert userConvert;


    public Boolean createUser(UserCreateDTO createUserDTO){
        return userDOMapper.insertSelective(userConvert.userCreateDTO2UserDO(createUserDTO)) > 0;
    }
    public Boolean updateUser(UserCreateDTO createUserDTO){
        return userDOMapper.updateByPrimaryKeySelective(userConvert.userCreateDTO2UserDO(createUserDTO)) > 0;
    }
    public List<UserDTO> listUser() {
        List<UserDTO> userDTOList = Lists.newArrayList();
        List<UserDO> userDOList = userDOMapper.selectByExample(null);
        if (CollectionUtil.isNotEmpty(userDOList)) {
            userDTOList = userDOList.stream().map(userDO-> userConvert.userDO2UserDTO(userDO)).collect(Collectors.toList());
        }
        return userDTOList;
    }

    public UserDTO detail(String username){
        return userConvert.userDO2UserDTO(userDOMapper.selectOneByUsername(username));
    }
}
