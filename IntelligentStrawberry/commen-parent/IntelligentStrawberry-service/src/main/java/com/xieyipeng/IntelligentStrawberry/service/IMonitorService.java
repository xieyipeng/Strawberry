package com.xieyipeng.IntelligentStrawberry.service;

import com.xieyipeng.IntelligentStrawberry.model.Monitor;

import java.util.List;
import java.util.Map;

public interface IMonitorService {
    public void insertMonitor(Map map);

    public List<Monitor> findAll();

    public List<Monitor> findRecently();

    public List<Monitor> findRecentlyOne();


}
