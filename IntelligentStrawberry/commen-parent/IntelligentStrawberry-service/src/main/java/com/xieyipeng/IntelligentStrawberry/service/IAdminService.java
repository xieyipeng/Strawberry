package com.xieyipeng.IntelligentStrawberry.service;

import com.xieyipeng.IntelligentStrawberry.model.Admin;

import java.util.List;
import java.util.Map;

public interface IAdminService {
    List<Admin> findAllAdmin();

    void insertAdmin(Map map);

    void deleteAdmin(Map map);

    void updateAdminName(Map map);

    void updateAdminPassword(Map map);

    void updateAdminTelephone(Map map);
}
