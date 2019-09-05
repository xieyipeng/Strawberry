package com.xieyipeng.IntelligentStrawberry.mapper;

import com.xieyipeng.IntelligentStrawberry.model.StrawberryFram;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StrawberryFramMapper {
    void insertFarm(@Param("param") Map map);

    List<StrawberryFram> select_i(@Param("param") Map map);

    List<StrawberryFram> findAll();
}
