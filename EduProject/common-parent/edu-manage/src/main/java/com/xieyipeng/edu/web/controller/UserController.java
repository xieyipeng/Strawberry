package com.xieyipeng.edu.web.controller;

import com.sun.deploy.net.HttpResponse;
import com.xieyipeng.edu.model.User;
import com.xieyipeng.edu.service.IUserService;
import com.xieyipeng.edu.web.controller.base.BaseController;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController extends BaseController<User> {

    @Autowired
    private IUserService userService;


    @RequestMapping("insertUser")
    public String insertUser(HttpServletRequest request, HttpServletResponse response) {
        if (!request.getParameter("id").equals("")
                && request.getParameter("username") != null
                && request.getParameter("password") != null) {

            Integer id = Integer.valueOf(request.getParameter("id"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            userService.insertUser(id, username, password);

            response.setCharacterEncoding("utf-8");
            PrintWriter printWriter = null;
            try {
                printWriter = response.getWriter();
                printWriter.print("<script>alert('添加成功'); window.location='http://localhost:8080/user/insertUserJSP.do'</script>");
            } catch (Exception e) {
                e.printStackTrace();
            }

            printWriter.flush();
            printWriter.close();


        }
        System.out.println("nihoaaaaaaa");
        return "/user/insert_user";
    }

    @RequestMapping("insertUserJSP")
    public String insertUserJSP() {
        return "/user/insert_user";
    }

    @RequestMapping("deleteUser")
    public String deleteUser(HttpServletRequest request) {
        if (request.getParameter("id") != null) {
            Integer id = Integer.valueOf(request.getParameter("id"));
            userService.deleteUser(id);
        }
        return "/user/insert_user";
    }


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
            return map.toString();
        } else {
            logger.error("size == null");
        }
        return null;
    }


//    @RequestMapping("login")
//    public String login() {
//        System.out.println("nihao");
//        return "/user/update";
//    }


//    @RequestMapping("findById")
//    public User findById(Integer id) {
//        System.out.println("...");
//        List<User> users = userService.findAll();
//        return null;
//    }


//    @RequestMapping(MANAGE)
//    public String manage() {
//        return MANAGE_PAGE;
//    }
//
//    @RequestMapping(INFO)
//    public String info() {
//        return INFO_PAGE;
//    }
//
//    @RequestMapping(EDIT)
//    public String edit() {
//        return EDIT_PAGE;
//    }
}
