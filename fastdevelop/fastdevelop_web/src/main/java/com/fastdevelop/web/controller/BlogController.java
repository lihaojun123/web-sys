package com.fastdevelop.web.controller;


import com.fastdevelop.dto.BlogDTO;
import com.fastdevelop.dto.BlogReqDTO;
import com.fastdevelop.service.BlogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Resource
    private BlogService blogService;
    @PostMapping("/listBlog")
    public List<BlogDTO> listBlogs(@RequestBody BlogReqDTO blogReqDTO){
        List<BlogDTO> blogDTOList = blogService.listBlogs(blogReqDTO);
        return blogDTOList;
    }
}
