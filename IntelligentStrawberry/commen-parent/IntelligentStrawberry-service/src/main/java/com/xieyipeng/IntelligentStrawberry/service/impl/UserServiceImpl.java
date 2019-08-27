package com.xieyipeng.IntelligentStrawberry.service.impl;

import com.xieyipeng.IntelligentStrawberry.mapper.UserMapper;
import com.xieyipeng.IntelligentStrawberry.model.User;
import com.xieyipeng.IntelligentStrawberry.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    public UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
