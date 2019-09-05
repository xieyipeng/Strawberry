package com.xieyipeng.IntelligentStrawberry.mapper;

import com.xieyipeng.IntelligentStrawberry.model.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    List<Admin> findAllAdmin();

    void insertAdmin(@Param("param") Map map);

    void deleteAdmin(@Param("param") Map map);

    void updateAdminName(@Param("param") Map map);

    void updateAdminPassword(@Param("param") Map map);

    void updateAdminTelephone(@Param("param") Map map);
}
