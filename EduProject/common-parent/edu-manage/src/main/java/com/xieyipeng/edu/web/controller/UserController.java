package com.xieyipeng.edu.web.controller;

import com.xieyipeng.edu.model.User;
import com.xieyipeng.edu.service.IUserService;
import com.xieyipeng.edu.web.controller.base.BaseController;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController extends BaseController<User> {

    @Autowired
    private IUserService userService;

    @RequestMapping("login")
    public String login() {
        System.out.println("nihao");
        return "/user/update";
    }

//    @RequestMapping("findById")
//    public User findById(Integer id) {
//        System.out.println("...");
//        List<User> users = userService.findAll();
//        return null;
//    }

    @RequestMapping("findAllUser")
    @ResponseBody
    public Object findAllUser() {
        List<User> users = userService.findAll();
        if (users != null) {
            /**
             for (int i = 0; i < users.size(); i++) {
             System.out.println(users.get(i));
             }
             **/
            JSONObject map = new JSONObject(true);
            map.put("count", users.size());
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", users);
//            logger.error(map.toString());
            return map.toString();
        } else {
            logger.error("size == null");
        }
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
