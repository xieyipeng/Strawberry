package com.xieyipeng.IntelligentStrawberry.mapper;

import com.xieyipeng.IntelligentStrawberry.model.Monitor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MonitorMapper {
    void insertMonitor(@Param("param") Map map);
    List<Monitor> findAll();
}
