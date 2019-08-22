package com.xieyipeng.edu.web.controller;

import com.xieyipeng.edu.model.User;
import com.xieyipeng.edu.service.IUserService;
import com.xieyipeng.edu.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController extends BaseController<User> {

    @Autowired
    private IUserService userService;

    @RequestMapping("login")
    public String login() {
        System.out.println("...");
        return "Default";
    }

    @RequestMapping("find")
    public User find(Integer id) {
        System.out.println("...");
        User user = userService.findById(id);
        System.out.println(user);
        return null;
    }

    @RequestMapping(MANAGE)
    public String manage() {
        return MANAGE_PAGE;
    }

    @RequestMapping(INFO)
    public String info() {
        return INFO_PAGE;
    }

    @RequestMapping(EDIT)
    public String edit() {
        return EDIT_PAGE;
    }
}
