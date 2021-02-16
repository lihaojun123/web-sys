package com.fastdevelop.convert;

import cn.hutool.core.date.DateUtil;
import com.fastdevelop.db.model.BlogDO;
import com.fastdevelop.dto.BlogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class BlogConvertDecorator implements BlogConvert {
    @Autowired
    @Qualifier("delegate")
    private BlogConvert delegate;

    @Override
    public BlogDO blogDTO2BlogDO(BlogDTO blogDTO) {
        BlogDO blogDO = new BlogDO();
        blogDO.setId(blogDTO.getId());
        blogDO.setTitle(blogDTO.getTitle());
        blogDO.setSubTitle(blogDTO.getSubTitle());
        blogDO.setCategoryId(blogDTO.getCategoryId());
        return blogDO;
    }

    @Override
    public BlogDTO blogDO2BlogDTO(BlogDO blogDO) {
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setId(blogDO.getId());
        blogDTO.setTitle(blogDO.getTitle());
        blogDTO.setSubTitle(blogDO.getSubTitle());
        blogDTO.setCategoryId(blogDO.getCategoryId());
        blogDTO.setUpdateTime(DateUtil.format(blogDO.getUpdateTime(),"yyyy-MM-dd HH:mm:ss"));
        blogDTO.setCreateTime(DateUtil.format(blogDO.getCreateTime(),"yyyy-MM-dd HH:mm:ss"));
        return blogDTO;
    }
}
