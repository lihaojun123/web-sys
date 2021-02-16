package com.fastdevelop.convert;

import com.fastdevelop.db.model.UserDO;
import com.fastdevelop.dto.UserCreateDTO;
import com.fastdevelop.dto.UserDTO;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
@DecoratedWith(UserConvertDecorator.class)
public interface UserConvert {
    UserDTO userDO2UserDTO(UserDO userDO);
    UserDO userDTO2UserDO(UserDTO userDTO);
    UserDO userCreateDTO2UserDO(UserCreateDTO userCreateDTO);
}
