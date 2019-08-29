package com.xieyipeng.IntelligentStrawberry.web.controller;

import com.xieyipeng.IntelligentStrawberry.model.User;
import com.xieyipeng.IntelligentStrawberry.service.IUserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("findAll")
    @ResponseBody
    public String findAll() {
        List<User> users = userService.findAll();
        if (users.size() != 0) {
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
            return map.toString();
        } else {
            System.out.println("user size == null!");
        }
        return null;
    }
}
