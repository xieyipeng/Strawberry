package com.xieyipeng.edu.service.base;

import java.util.List;

public interface IBaseService<T> {
    public T findById(Integer id);

    public T findByUUID(String uuid);

    public void deleteById(Integer id);

    public void deleteByUUID(String uuid);

    public void update(T t);

    public void insert(T t);

    public List<T> findAll();
}
