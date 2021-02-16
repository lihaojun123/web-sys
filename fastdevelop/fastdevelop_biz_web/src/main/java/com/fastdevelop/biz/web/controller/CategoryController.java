package com.fastdevelop.biz.web.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fastdevelop.common.res.JsonResult;
import com.fastdevelop.db.model.CategoryDO;
import com.fastdevelop.db.model.CategoryDTO;
import com.fastdevelop.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/listAll")
    public JsonResult<List<CategoryDO>> listAll() {
        return JsonResult.<List<CategoryDO>>builder().success(categoryService.listAll()).build();
    }

    @GetMapping("/findByPid")
    public JsonResult<List<CategoryDO>> findById(){
        return null;
    }

    @PostMapping("/save")
    public JsonResult<Boolean> save(@RequestBody CategoryDO categoryDO){
        String id = categoryDO.getId();
        if (StringUtils.isEmpty(id)) {
            Boolean aBoolean = categoryService.create(categoryDO);
            if (ObjectUtil.isEmpty(categoryDO.getpId())) {
                categoryDO.setpId("0");
            }
            return aBoolean ? JsonResult.<Boolean>builder().success().build() : JsonResult.<Boolean>builder().failure("新增失败").build();
        }else {
            Boolean aBoolean = categoryService.update(categoryDO);
            return aBoolean ? JsonResult.<Boolean>builder().success().build() : JsonResult.<Boolean>builder().failure("更新失败").build();
        }
    }


    @GetMapping("/selectTree")
    public JsonResult<List<CategoryDTO>> selectTree(){
        List<CategoryDTO> categoryDTOList = categoryService.selectTree();
        categoryDTOList = clearNullItem(categoryDTOList);
        return JsonResult.<List<CategoryDTO>>builder().success(categoryDTOList).build();
    }

    public  List<CategoryDTO> clearNullItem(List<CategoryDTO> categoryDTOList){
        if (CollectionUtil.isNotEmpty(categoryDTOList)) {
            categoryDTOList.forEach(categoryDTO->{
                if (CollectionUtil.isEmpty(categoryDTO.getChildren())) {
                    categoryDTO.setChildren(null);
                } else {
                    this.clearNullItem(categoryDTO.getChildren());
                }
            });
        }
        return categoryDTOList;
    }
}
