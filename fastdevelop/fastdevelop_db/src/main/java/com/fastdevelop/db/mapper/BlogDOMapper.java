package com.fastdevelop.db.mapper;

import com.fastdevelop.db.model.BlogDO;
import com.fastdevelop.db.model.BlogDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BlogDOMapper {
    long countByExample(BlogDOExample example);

    int deleteByExample(BlogDOExample example);

    int deleteByPrimaryKey(String id);

    int insert(BlogDO record);

    int insertSelective(BlogDO record);

    List<BlogDO> selectByExample(BlogDOExample example);

    BlogDO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BlogDO record, @Param("example") BlogDOExample example);

    int updateByExample(@Param("record") BlogDO record, @Param("example") BlogDOExample example);

    int updateByPrimaryKeySelective(BlogDO record);

    int updateByPrimaryKey(BlogDO record);
}