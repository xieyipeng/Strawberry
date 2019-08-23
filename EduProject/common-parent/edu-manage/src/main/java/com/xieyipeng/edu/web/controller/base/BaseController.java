package com.xieyipeng.edu.web.controller.base;

import org.apache.log4j.Logger;

import java.lang.reflect.ParameterizedType;

public class BaseController<T> {
    public static String MANAGE_PAGE;
    public static String INFO_PAGE;
    public static String EDIT_PAGE;

    public static final String MANAGE = "manage";
    public static final String INFO = "info";
    public static final String EDIT = "edit";

    public Logger logger = Logger.getLogger(BaseController.class);

    public BaseController() {
        //1、获取泛型的真实类型
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        //2、获取泛型的模块类
        Class<?> model_class = (Class<?>) type.getActualTypeArguments()[0];
        //3、获取泛型的模块名
        String model_name = model_class.getSimpleName().toLowerCase();


        MANAGE_PAGE = model_name + "/" + MANAGE;
        INFO_PAGE = model_name + "/" + INFO;
        EDIT_PAGE = model_name + "/" + EDIT;
    }
}
