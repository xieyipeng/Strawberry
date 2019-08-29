package com.xieyipeng.IntelligentStrawberry.service.impl;

import com.xieyipeng.IntelligentStrawberry.mapper.MonitorMapper;
import com.xieyipeng.IntelligentStrawberry.model.Monitor;
import com.xieyipeng.IntelligentStrawberry.service.IMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MonitorServiceImpl implements IMonitorService {

    @Autowired
    private MonitorMapper monitorMapper;

    @Override
    public void insertMonitor(Map map) {
        monitorMapper.insertMonitor(map);
    }

    @Override
    public List<Monitor> findAll() {
        return monitorMapper.findAll();
    }
}
