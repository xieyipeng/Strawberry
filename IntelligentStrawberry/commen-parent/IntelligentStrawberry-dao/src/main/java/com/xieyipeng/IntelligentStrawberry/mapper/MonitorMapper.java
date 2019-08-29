package com.xieyipeng.IntelligentStrawberry.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface MonitorMapper {
    void insertMonitor(@Param("param") Map map);
}
