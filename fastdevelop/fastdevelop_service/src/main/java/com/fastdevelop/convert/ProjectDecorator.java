package com.fastdevelop.convert;

import cn.hutool.core.util.ObjectUtil;
import com.fastdevelop.db.mapper.UserDOMapper;
import com.fastdevelop.db.model.ProjectDO;
import com.fastdevelop.db.model.UserDO;
import com.fastdevelop.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class ProjectDecorator implements ProjectConvert{

    @Autowired
    @Qualifier("delegate")
    private ProjectConvert delegate;

    @Autowired
    private UserDOMapper userDOMapper;
}
