package com.fastdevelop.db.mapper;

import com.fastdevelop.db.model.ChapterDO;
import com.fastdevelop.db.model.ChapterDOExample;
import java.util.List;
import com.fastdevelop.db.model.ChapterDTO;import org.apache.ibatis.annotations.Param;

public interface ChapterDOMapper {
    long countByExample(ChapterDOExample example);

    int deleteByExample(ChapterDOExample example);

    int insert(ChapterDO record);

    int insertSelective(ChapterDO record);

    List<ChapterDO> selectByExample(ChapterDOExample example);

    int updateByExampleSelective(@Param("record") ChapterDO record, @Param("example") ChapterDOExample example);

    int updateByExample(@Param("record") ChapterDO record, @Param("example") ChapterDOExample example);

    List<ChapterDTO> selectTree(String projectId);

    int deleteById(@Param("id")String id);


}