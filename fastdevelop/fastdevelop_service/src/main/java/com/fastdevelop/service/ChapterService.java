package com.fastdevelop.service;

import com.fastdevelop.db.mapper.ChapterDOMapper;
import com.fastdevelop.db.model.ChapterDO;
import com.fastdevelop.db.model.ChapterDOExample;
import com.fastdevelop.db.model.ChapterDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ChapterService {


    @Resource
    ChapterDOMapper chapterDOMapper;

    public int insertSelective(ChapterDO record) {
        return chapterDOMapper.insertSelective(record);
    }

    public int updateSelective(ChapterDO chapterDO) {
        String id = chapterDO.getId();
        if (StringUtils.isEmpty(id)) {
            throw new RuntimeException("id为空");
        } else {
            ChapterDOExample example = new ChapterDOExample();
            ChapterDOExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            return chapterDOMapper.updateByExampleSelective(chapterDO, example);
        }
    }

    public List<ChapterDTO> selectTree(String projectId) {
        return chapterDOMapper.selectTree(projectId);
    }

}
