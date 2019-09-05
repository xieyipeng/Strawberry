package com.xieyipeng.IntelligentStrawberry.service.impl;

import com.xieyipeng.IntelligentStrawberry.mapper.StrawberryFramMapper;
import com.xieyipeng.IntelligentStrawberry.model.StrawberryFram;
import com.xieyipeng.IntelligentStrawberry.service.IStrawberryFramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class StrawberryFramServiceImpl implements IStrawberryFramService {

    @Autowired
    StrawberryFramMapper strawberryFramMapper;


    @Override
    public void insertFarm(Map map) {
        strawberryFramMapper.insertFarm(map);
    }

    @Override
    public List<StrawberryFram> select_i(Map map) {
        return strawberryFramMapper.select_i(map);
    }

    @Override
    public List<StrawberryFram> findAll() {
        return strawberryFramMapper.findAll();
    }
}
