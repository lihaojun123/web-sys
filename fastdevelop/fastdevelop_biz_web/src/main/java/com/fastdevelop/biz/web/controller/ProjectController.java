package com.fastdevelop.biz.web.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.fastdevelop.biz.web.util.UserUtil;
import com.fastdevelop.common.res.JsonResult;
import com.fastdevelop.db.mapper.CategoryDOMapper;
import com.fastdevelop.db.mapper.ChapterDOMapper;
import com.fastdevelop.db.mapper.ProjectDOMapper;
import com.fastdevelop.db.mapper.UserDOMapper;
import com.fastdevelop.db.model.*;
import com.fastdevelop.dto.ProjectCreateDTO;
import com.fastdevelop.dto.ProjectDTO;
import com.fastdevelop.service.ChapterService;
import com.fastdevelop.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/project")
public class ProjectController extends BaseController implements InitializingBean {

    @Autowired
    private ChapterDOMapper chapterDOMapper;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectDOMapper projectDOMapper;

    @Autowired
    private UserDOMapper userDOMapper;

    @Autowired
    private CategoryDOMapper categoryDOMapper;

    @Autowired
    private ChapterService chapterService;

    @Value("${fastdevelop.blog.detailMdPath}")
    private String blogDetailMdPath;

    @Value("${fastdevelop.album.detailMdPath}")
    private String albumDetailMdPath;

    @Value("${fastdevelop.album.chapterMdPath}")
    private String chapterMdPath;

    private Map<String, String> projectTypeMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        projectTypeMap.put("1", "博客");
        projectTypeMap.put("2", "专栏");
        projectTypeMap.put("3", "问答");

        File file = new File(blogDetailMdPath);
        try {
            Assert.isTrue(file.exists());
            Assert.isTrue(file.isDirectory());
        } finally {
            file.mkdirs();
        }
    }


    @PostMapping("/listProjects")
    public JsonResult<List<ProjectDTO>> projectDTOList(@RequestBody JSONObject jsonObject) {
        Integer pageNum = jsonObject.getInteger("pageNum");
        Integer pageSize = jsonObject.getInteger("pageSize");
        if (ObjectUtil.isEmpty(pageNum) || pageNum < 0) {
            pageNum = 0;
        }
        if (ObjectUtil.isEmpty(pageSize) || pageSize < 0) {
            pageSize = 10;
        }
        List<ProjectDTO> projectDTOList = projectService.listProjects(pageNum, pageSize);
        if (CollectionUtil.isNotEmpty(projectDTOList)) {
            for (ProjectDTO projectDTO : projectDTOList) {
                Long userId = projectDTO.getUserId();
                String projectType = projectDTO.getProjectType();
                if (userId != null) {
                    UserDO userDO = userDOMapper.selectByPrimaryKey(userId);
                    projectDTO.setUsername(userDO.getUsername());
                }
                if (StringUtils.isNotEmpty(projectType)) {
                    projectDTO.setProjectTypeName(projectTypeMap.get(projectType));
                }
                String categoryId = projectDTO.getCategoryId();
                if (categoryId != null) {
                    CategoryDO categoryDO = categoryDOMapper.selectByPrimaryKey(categoryId);
                    if (ObjectUtil.isNotEmpty(categoryDO)) {
                        projectDTO.setCategoryName(categoryDO.getName());
                    }
                }
            }
        }
        return JsonResult.<List<ProjectDTO>>builder().success(projectDTOList).build();
    }

    @PostMapping("/save")
    public JsonResult<Boolean> save(@RequestBody ProjectCreateDTO projectCreateDTO) {
        String id = UserUtil.getUserJwtFromHeader(request).getId();
        projectCreateDTO.setUserId(Long.valueOf(id));
        return JsonResult.<Boolean>builder().success(projectService.save(projectCreateDTO)).build();
    }


    @GetMapping("/detail")
    public JsonResult<ProjectDTO> detail(String id) {
        if (ObjectUtil.isEmpty(id)) {
            return JsonResult.<ProjectDTO>builder().failure("id为空").build();
        } else {
            ProjectDO projectDO = projectDOMapper.selectByPrimaryKey(String.valueOf(id));
            if (ObjectUtil.isEmpty(projectDO)) {
                return JsonResult.<ProjectDTO>builder().failure("非法请求").build();
            } else {
                ProjectDTO projectDTO = new ProjectDTO();
                projectDTO.setId(projectDO.getId());
                projectDTO.setTitle(projectDO.getTitle());
                projectDTO.setSubTitle(projectDO.getSubTitle());
                projectDTO.setImg(projectDO.getImg());
                projectDTO.setCategoryId(projectDO.getCategoryId());
                projectDTO.setUserId(projectDO.getUserId());
                projectDTO.setCreateTime(projectDO.getCreateTime());
                projectDTO.setUpdateTime(projectDO.getUpdateTime());
                projectDTO.setProjectType(projectDO.getProjectType());
                Long userId = projectDO.getUserId();

                String projectType = projectDO.getProjectType();

                if (userId != null) {
                    UserDO userDO = userDOMapper.selectByPrimaryKey(userId);
                    projectDTO.setUsername(userDO.getUsername());
                }

                if (StringUtils.isNotEmpty(projectType)) {
                    projectDTO.setProjectTypeName(projectTypeMap.get(projectType));
                    if ("2".equalsIgnoreCase(projectType)) {
                        List<ChapterDTO> chapterDTOList = chapterService.selectTree(id);
                        projectDTO.setChapterDTOList(chapterDTOList);
                    }
                }

                String categoryId = projectDO.getCategoryId();
                if (categoryId != null) {
                    CategoryDO categoryDO = categoryDOMapper.selectByPrimaryKey(categoryId);
                    if (ObjectUtil.isNotEmpty(categoryDO)) {
                        projectDTO.setCategoryName(categoryDO.getName());
                    }
                }
                return JsonResult.<ProjectDTO>builder().success(projectDTO).build();
            }
        }
    }

    @PostMapping("/contentSet")
    public JsonResult<Boolean> contentSet(@RequestBody Map<String, String> map) {
        String id = map.get("id");
        String content = map.get("content");
        String projectType = map.get("projectType");
        //博客
        String pathDir = null;
        if (StringUtils.isNotEmpty(projectType) && "1".equalsIgnoreCase(projectType)) {
            pathDir = blogDetailMdPath;
        } else if (StringUtils.isNotEmpty(projectType) && "2".equalsIgnoreCase(projectType)) {
            //专栏详情md
            pathDir = albumDetailMdPath;
        } else if (StringUtils.isNotEmpty(projectType) && "3".equalsIgnoreCase(projectType)) {
            //专栏章节
            pathDir = chapterMdPath;
        }

        try {
            File file = new File(pathDir, id + ".md");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileUtil.writeString(content, file, Charset.defaultCharset());
            return JsonResult.<Boolean>builder().success().build();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("博客详情保存出错:  {}", map);
            return JsonResult.<Boolean>builder().failure().build();
        }


    }

    @GetMapping("/blogContentGet")
    public JsonResult<String> blogContentGet(String projectId, String projectType) {
        if (StringUtils.isEmpty(projectId) || StringUtils.isEmpty(projectType)) {
            return JsonResult.<String>builder().failure("projectId 或者 projectType 非法").build();
        }
        //博客
        String pathDir = null;
        if (StringUtils.isNotEmpty(projectType) && "1".equalsIgnoreCase(projectType)) {
            pathDir = blogDetailMdPath;
        } else if (StringUtils.isNotEmpty(projectType) && "2".equalsIgnoreCase(projectType)) {
            //专栏详情md
            pathDir = albumDetailMdPath;
        } else if (StringUtils.isNotEmpty(projectType) && "3".equalsIgnoreCase(projectType)) {
            //专栏章节
            pathDir = chapterMdPath;
        }

        if (StringUtils.isEmpty(projectId)) {
            return JsonResult.<String>builder().failure(projectId + "未找到相关内容").build();
        } else {
            try {
                File file = new File(pathDir, projectId + ".md");
                if (!file.exists()) {
                    file.createNewFile();
                    FileUtil.writeString("# 暂无内容", file, Charset.defaultCharset());
                }
                return JsonResult.<String>builder().success(FileUtil.readString(file, Charset.defaultCharset())).build();
            } catch (Exception e) {
                e.printStackTrace();
                log.error("给博客初始化详情文件出错 , error msg is : {} ", e.getMessage());
                throw new RuntimeException(e.getMessage());
            }
        }
    }


}
