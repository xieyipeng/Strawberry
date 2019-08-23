package com.xieyipeng.edu.mapper;


import com.xieyipeng.edu.mapper.base.BaseMapper;
import com.xieyipeng.edu.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {
    List<User> findAll();
}
