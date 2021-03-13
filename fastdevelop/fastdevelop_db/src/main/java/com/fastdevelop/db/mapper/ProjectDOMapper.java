package com.fastdevelop.db.mapper;

import com.fastdevelop.db.model.ProjectDO;
import com.fastdevelop.db.model.ProjectDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectDOMapper {
    long countByExample(ProjectDOExample example);

    int deleteByExample(ProjectDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProjectDO record);

    int insertSelective(ProjectDO record);

    List<ProjectDO> selectByExample(ProjectDOExample example);

    ProjectDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProjectDO record, @Param("example") ProjectDOExample example);

    int updateByExample(@Param("record") ProjectDO record, @Param("example") ProjectDOExample example);

    int updateByPrimaryKeySelective(ProjectDO record);

    int updateByPrimaryKey(ProjectDO record);
}