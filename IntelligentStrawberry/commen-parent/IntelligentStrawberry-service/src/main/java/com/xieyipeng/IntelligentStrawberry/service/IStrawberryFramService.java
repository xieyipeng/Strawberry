package com.xieyipeng.IntelligentStrawberry.service;

import com.xieyipeng.IntelligentStrawberry.model.StrawberryFram;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IStrawberryFramService {
    public void insertFarm(Map map);

    public List<StrawberryFram> select_i(Map map);

}
