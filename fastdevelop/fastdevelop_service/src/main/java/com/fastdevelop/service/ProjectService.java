package com.fastdevelop.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.IdUtil;
import com.fastdevelop.convert.ProjectConvert;
import com.fastdevelop.db.mapper.ChapterDOMapper;
import com.fastdevelop.db.mapper.ProjectDOMapper;
import com.fastdevelop.db.model.ChapterDO;
import com.fastdevelop.db.model.ProjectDO;
import com.fastdevelop.db.model.ProjectDOExample;
import com.fastdevelop.dto.ProjectCreateDTO;
import com.fastdevelop.dto.ProjectDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Resource
    private ProjectConvert projectConvert;

    @Resource
    private ProjectDOMapper projectDOMapper;

    @Resource
    private ChapterDOMapper chapterDOMapper;

    public List<ProjectDTO> listProjects(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProjectDTO> projectDTOList = Lists.newArrayList();
        ProjectDOExample example = new ProjectDOExample();
        ProjectDOExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("update_time desc");
        PageInfo<ProjectDO> pageInfo = new PageInfo<>(projectDOMapper.selectByExample(example));
        List<ProjectDO> projectDOS = pageInfo.getList();
        if (CollectionUtil.isNotEmpty(projectDOS)) {
            projectDTOList = projectDOS.stream().map(projectDO -> projectConvert.projectDO2ProjectDTO(projectDO)).collect(Collectors.toList());
        }
        return projectDTOList;
    }

    public Boolean save(ProjectCreateDTO projectCreateDTO) {
        int i = 0;
        ProjectDO projectDO = projectConvert.projectCreateDTO2ProjectDO(projectCreateDTO);
        if (StringUtils.isEmpty(projectDO.getId())) {
            String projectId = IdUtil.simpleUUID();
            projectDO.setId(projectId);
            i = projectDOMapper.insertSelective(projectDO);
            if (StringUtils.isNotEmpty(projectCreateDTO.getProjectType()) && "2".equalsIgnoreCase(projectCreateDTO.getProjectType())){
                //默认初始化一个章节
                ChapterDO chapterDO = new ChapterDO();
                chapterDO.setId(projectId);
                chapterDO.setChapterType("1");
                chapterDO.setpId("0");
                chapterDO.setTitle(projectCreateDTO.getTitle());
                chapterDOMapper.insertSelective(chapterDO);
            }
        }else {
            i = projectDOMapper.updateByPrimaryKeySelective(projectDO);
        }
        return i > 0;
    }

}
