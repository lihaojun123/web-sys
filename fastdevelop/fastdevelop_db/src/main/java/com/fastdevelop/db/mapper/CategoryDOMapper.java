package com.fastdevelop.db.mapper;

import com.fastdevelop.db.model.CategoryDO;
import com.fastdevelop.db.model.CategoryDOExample;
import java.util.List;

import com.fastdevelop.db.model.CategoryDTO;
import org.apache.ibatis.annotations.Param;

public interface CategoryDOMapper {
    long countByExample(CategoryDOExample example);

    int deleteByExample(CategoryDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(CategoryDO record);

    int insertSelective(CategoryDO record);

    List<CategoryDO> selectByExample(CategoryDOExample example);

    CategoryDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CategoryDO record, @Param("example") CategoryDOExample example);

    int updateByExample(@Param("record") CategoryDO record, @Param("example") CategoryDOExample example);

    int updateByPrimaryKeySelective(CategoryDO record);

    int updateByPrimaryKey(CategoryDO record);

    List<CategoryDTO> selectTree();
}