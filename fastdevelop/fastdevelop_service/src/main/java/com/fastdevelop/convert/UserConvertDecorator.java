package com.fastdevelop.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class UserConvertDecorator  implements UserConvert{
    @Autowired
    @Qualifier("delegate")
    private UserConvert delegate;

}
