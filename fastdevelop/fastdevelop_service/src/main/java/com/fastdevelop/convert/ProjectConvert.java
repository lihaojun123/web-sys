package com.fastdevelop.convert;

import com.fastdevelop.db.model.ProjectDO;
import com.fastdevelop.dto.ProjectCreateDTO;
import com.fastdevelop.dto.ProjectDTO;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(ProjectDecorator.class)
public interface ProjectConvert {
    ProjectDTO projectDO2ProjectDTO(ProjectDO projectDO);
    ProjectDO projectDTO2ProjectDO(ProjectDTO projectDTO);
    ProjectDO projectCreateDTO2ProjectDO(ProjectCreateDTO projectCreateDTO);
}
