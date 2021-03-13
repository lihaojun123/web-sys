package com.fastdevelop.service;

import com.fastdevelop.convert.BlogConvert;
import com.fastdevelop.db.mapper.BlogDOMapper;
import com.fastdevelop.dto.BlogDTO;
import com.fastdevelop.dto.BlogReqDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BlogService {
    @Resource
    private BlogDOMapper blogDOMapper;
    @Resource
    private BlogConvert blogConvert;

    public List<BlogDTO> listBlogs(BlogReqDTO blogReqDTO){
        return blogConvert.blogDOList2BlogDTOList(blogDOMapper.selectByExample(null));
    }
}
