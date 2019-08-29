package com.xieyipeng.IntelligentStrawberry.service.impl;

import com.xieyipeng.IntelligentStrawberry.mapper.AdminMapper;
import com.xieyipeng.IntelligentStrawberry.model.Admin;
import com.xieyipeng.IntelligentStrawberry.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

    @Autowired
    public AdminMapper adminMapper;


    @Override
    public List<Admin> findAllAdmin() {
        return adminMapper.findAllAdmin();
    }
}
