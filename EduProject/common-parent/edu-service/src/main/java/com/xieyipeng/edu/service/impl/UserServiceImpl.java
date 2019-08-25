package com.xieyipeng.edu.service.impl;

import com.xieyipeng.edu.model.User;
import com.xieyipeng.edu.service.IUserService;
import com.xieyipeng.edu.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void insertUser(Integer id, String username, String password) {
        Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        param.put("username", username);
        param.put("password", password);
        userMapper.insertUser(param);
    }

    @Override
    public void deleteUser(Integer id) {
        Map<String, Object> param = new HashMap<>();
        param.put("id",id);
        userMapper.deleteUser(param);
    }

    @Override
    public User login(String username, String password) {
        return null;
    }


    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByUUID(String uuid) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByUUID(String uuid) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void insert(User user) {

    }


}
