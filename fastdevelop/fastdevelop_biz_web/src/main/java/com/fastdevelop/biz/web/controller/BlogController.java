package com.fastdevelop.biz.web.controller;

import com.fastdevelop.biz.web.util.UserUtil;
import com.fastdevelop.common.res.JsonResult;
import com.fastdevelop.dto.BlogDTO;
import com.fastdevelop.dto.BlogReqDTO;
import com.fastdevelop.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/blog")
public class BlogController extends BaseController {


    @Autowired
    private BlogService blogService;

    @GetMapping("/listBlog")
    public JsonResult<List<BlogDTO>> listBlogs(BlogReqDTO blogReqDTO) {

        String userId = UserUtil.getUserJwtFromHeader(request).getId();
        log.info("当前用户id是{}", userId);
        List<BlogDTO> blogDTOList = blogService.listBlogs(blogReqDTO);
        return JsonResult.<List<BlogDTO>>builder().success(blogDTOList).build();
    }

}
