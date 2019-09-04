package com.xieyipeng.IntelligentStrawberry.web.controller;

import com.xieyipeng.IntelligentStrawberry.model.Admin;
import com.xieyipeng.IntelligentStrawberry.service.IAdminService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("insert-admin")
    @ResponseBody
    public String insertAdmin(@RequestParam("admin_username") String admin_username
            , @RequestParam("admin_password") String admin_password
            , @RequestParam("admin_telephone") String admin_telephone) {

        Map<String, Object> param = new HashMap<>();
        param.put("admin_username", admin_username);
        param.put("admin_password", admin_password);
        param.put("admin_telephone", admin_telephone);

        adminService.insertAdmin(param);
        return admin_username;
    }

    @RequestMapping("insert-admin-jsp")
    public String insertAdminJsp() {
        return "admin/add";
    }

    /**
     * 更新admin数据
     * @param admin_id id
     * @param filed 更改的数据列名称
     * @param value 更改后的值
     * @return success/failed
     */
    @RequestMapping("update-admin")
    @ResponseBody
    public String updateAdmin(@RequestParam("admin_id") Integer admin_id
            , @RequestParam("filed") String filed
            , @RequestParam("value") String value) {
        System.out.println(admin_id + " " + filed + " " + value);






        return "success";
    }

    @RequestMapping("delete-admin")
    @ResponseBody
    public String deleteAdmin(@RequestParam("admin_id") Integer admin_id) {
        try {
            Map<String, Object> param = new HashMap<>();
            param.put("admin_id", admin_id);
            adminService.deleteAdmin(param);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "failed";
    }


}
