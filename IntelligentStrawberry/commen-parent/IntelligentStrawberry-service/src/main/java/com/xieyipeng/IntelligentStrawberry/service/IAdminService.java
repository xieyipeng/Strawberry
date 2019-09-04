package com.xieyipeng.IntelligentStrawberry.service;

import com.xieyipeng.IntelligentStrawberry.model.Admin;

import java.util.List;
import java.util.Map;

public interface IAdminService {
    public List<Admin> findAllAdmin();

    public void insertAdmin(Map map);

    public void deleteAdmin(Map map);
}
