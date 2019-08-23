package com.xieyipeng.edu.service;

import com.xieyipeng.edu.model.User;
import com.xieyipeng.edu.service.base.BaseServiceImpl;
import com.xieyipeng.edu.service.base.IBaseService;

import java.util.List;

public interface IUserService extends IBaseService<User> {
    //特有的方法
    public User login(String username,String password);

}
