package com.fastdevelop.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fastdevelop.db.mapper.CategoryDOMapper;
import com.fastdevelop.db.model.CategoryDO;
import com.fastdevelop.db.model.CategoryDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {

    @Resource
    private CategoryDOMapper categoryDOMapper;

    public CategoryDO detail(String id) {
        return categoryDOMapper.selectByPrimaryKey(id);
    }

    public List<CategoryDO> listAll() {
        return categoryDOMapper.selectByExample(null);
    }

    public Boolean create(CategoryDO categoryDO) {
        categoryDO.setId(IdUtil.simpleUUID());
        return categoryDOMapper.insertSelective(categoryDO) > 0;
    }

    public Boolean update(CategoryDO categoryDO) {
        if (ObjectUtil.isEmpty(categoryDO.getId())) {
            throw new RuntimeException("更新分类时，id必须携带");
        } else {
            return categoryDOMapper.updateByPrimaryKeySelective(categoryDO) > 0;
        }
    }


    public List<CategoryDTO> selectTree(){
        return categoryDOMapper.selectTree();
    }

}
