package com.fastdevelop.biz.web.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.fastdevelop.common.res.JsonResult;
import com.fastdevelop.db.mapper.ChapterDOMapper;
import com.fastdevelop.db.model.ChapterDO;
import com.fastdevelop.db.model.ChapterDOExample;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Resource
    ChapterDOMapper chapterDOMapper;

    @PostMapping("/insertSelective")
    public JsonResult<Boolean> insertSelective(@RequestBody ChapterDO chapterDO) {
        chapterDO.setId(IdUtil.simpleUUID());
        return chapterDOMapper.insertSelective(chapterDO) > 0 ? JsonResult.<Boolean>builder().success().build(): JsonResult.<Boolean>builder().failure().build();
    }

    /**
     * 更新章节，只允许更新名称标题和序号，且支持支单个更新
     * @param
     * @return
     */
    @PostMapping("/updateSelective")
    public JsonResult<String> updateSelective(@RequestBody JSONObject jsonObject){

        String id = jsonObject.getString("id");
        Long num = jsonObject.getLong("num");
        String title = jsonObject.getString("title");


        Assert.isTrue(ObjectUtil.isAllNotEmpty(id,num,title),"id || num || title 非法");

        ChapterDO chapterDO = new ChapterDO();
        chapterDO.setTitle(title);
        chapterDO.setNum(num);
        chapterDO.setId(id);
        ChapterDOExample example = new ChapterDOExample();
        ChapterDOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        int i = chapterDOMapper.updateByExampleSelective(chapterDO, example);
        return i > 0 ?
                JsonResult.<String>builder().success("跟新成功").build():
                JsonResult.<String>builder().failure("更新失败").build();
    }

    @PostMapping("/deleteChapter")
    public JsonResult<Boolean> deleteChapter(@RequestBody JSONObject jsonObject) {
        String chapterId = jsonObject.getString("chapterId");

        Optional<String> optional = Optional.ofNullable(chapterId);

        if (!optional.isPresent())
            return JsonResult.<Boolean>builder().failure("chapterId为空").build();

        ChapterDOExample example  = new ChapterDOExample();
        ChapterDOExample.Criteria criteria = example.createCriteria();
        criteria.andPIdEqualTo(chapterId);

        List<ChapterDO> chapterDOList = chapterDOMapper.selectByExample(example);

        if (!CollectionUtils.isEmpty(chapterDOList))
            return JsonResult.<Boolean>builder().failure("该章节下有子章节，不允许删除").build();

        int i = chapterDOMapper.deleteById(chapterId);

        return i > 0 ? JsonResult.<Boolean>builder().success(true).build(): JsonResult.<Boolean>builder().failure().build();
    }

}
