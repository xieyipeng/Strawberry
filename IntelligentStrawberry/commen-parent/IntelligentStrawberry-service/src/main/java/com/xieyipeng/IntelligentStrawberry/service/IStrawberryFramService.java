package com.xieyipeng.IntelligentStrawberry.service;

import com.xieyipeng.IntelligentStrawberry.model.StrawberryFram;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IStrawberryFramService {
    void insertFarm(Map map);

    List<StrawberryFram> select_i(Map map);

    List<StrawberryFram> findAll();

}
