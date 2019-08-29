package com.xieyipeng.IntelligentStrawberry.web.controller;

import com.xieyipeng.IntelligentStrawberry.model.Admin;
import com.xieyipeng.IntelligentStrawberry.service.IAdminService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @ResponseBody
    @RequestMapping("findAllAdmin")
    public String findAllAdmin() {
        List<Admin> admins = adminService.findAllAdmin();
        if (admins.size() != 0) {
            /**
             for (int i = 0; i < users.size(); i++) {
             System.out.println(users.get(i));
             }
             **/
            JSONObject map = new JSONObject(true);
            map.put("count", admins.size());
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", admins);
            return map.toString();
        } else {
            System.out.println("user size == null!");
        }
        return null;
    }


}
