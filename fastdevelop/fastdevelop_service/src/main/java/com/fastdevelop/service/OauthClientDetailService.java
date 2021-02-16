package com.fastdevelop.service;

import com.fastdevelop.db.mapper.OauthClientDetailDOMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OauthClientDetailService {
    @Resource
    private OauthClientDetailDOMapper clientDetailDOMapper;
}
