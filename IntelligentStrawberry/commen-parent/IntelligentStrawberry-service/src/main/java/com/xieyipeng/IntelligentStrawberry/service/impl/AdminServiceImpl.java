package com.xieyipeng.IntelligentStrawberry.service.impl;

import com.xieyipeng.IntelligentStrawberry.mapper.AdminMapper;
import com.xieyipeng.IntelligentStrawberry.model.Admin;
import com.xieyipeng.IntelligentStrawberry.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

    @Autowired
    public AdminMapper adminMapper;


    @Override
    public List<Admin> findAllAdmin() {
        return adminMapper.findAllAdmin();
    }

    @Override
    public void insertAdmin(Map map) {
        adminMapper.insertAdmin(map);
    }

    @Override
    public void deleteAdmin(Map map) {
        adminMapper.deleteAdmin(map);
    }

    @Override
    public void updateAdminName(Map map) {
        adminMapper.updateAdminName(map);
    }

    @Override
    public void updateAdminPassword(Map map) {
        adminMapper.updateAdminPassword(map);
    }

    @Override
    public void updateAdminTelephone(Map map) {
        adminMapper.updateAdminTelephone(map);
    }
}
