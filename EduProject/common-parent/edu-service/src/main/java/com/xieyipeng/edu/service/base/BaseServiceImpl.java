package com.xieyipeng.edu.service.base;

import com.xieyipeng.edu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<T> implements IBaseService<T>{
    //impl - 实现类
    //放所有的dao
    //统一管理dao

    @Autowired
    public UserMapper userMapper;
}
