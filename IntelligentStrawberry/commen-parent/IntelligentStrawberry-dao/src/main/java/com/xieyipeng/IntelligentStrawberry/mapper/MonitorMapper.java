package com.xieyipeng.IntelligentStrawberry.mapper;

import com.xieyipeng.IntelligentStrawberry.model.Monitor;
import com.xieyipeng.IntelligentStrawberry.model.tools.LoadMonitor;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MonitorMapper {
    void insertMonitor(@Param("param") Map map);

    List<Monitor> findAll();

    List<Monitor> findRecently();

    List<Monitor> findRecentlyOne();

    List<LoadMonitor> androidRecently();

}
