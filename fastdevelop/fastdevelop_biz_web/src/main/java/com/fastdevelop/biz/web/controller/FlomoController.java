package com.fastdevelop.biz.web.controller;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.fastdevelop.common.res.JsonResult;
import com.fastdevelop.util.MyRedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Struct;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@RestController
@RequestMapping("/flomo")
public class FlomoController {

    @Autowired
    private ThreadPoolExecutor executor;

    @Autowired(required = false)
    MyRedisUtil myRedisUtil;

    @PostMapping("/createFlomo")
    public JsonResult<Boolean> createFlomo(@RequestBody JSONObject jsonObject) {
        String content = jsonObject.getString("content");
        String lines[] = content.split("\\r?\\n");
        int corePoolSize = executor.getCorePoolSize();
        log.info("corePoolSize = {} ", corePoolSize);

        if (ArrayUtil.isNotEmpty(lines)) {
            for (int i = 0; i < lines.length; i++) {
                if (myRedisUtil != null) {
                    myRedisUtil.setString("line" + i, lines[i]);
                }
                log.info("line" + i + "= {} ", lines[i]);
            }
        }
        return JsonResult.<Boolean>builder().success().build();
    }

}
