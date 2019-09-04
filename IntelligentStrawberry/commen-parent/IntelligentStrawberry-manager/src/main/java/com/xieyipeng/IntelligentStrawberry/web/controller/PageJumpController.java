package com.xieyipeng.IntelligentStrawberry.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page-jump")
public class PageJumpController {
    @RequestMapping("to-admin-home")
    public String test() {
        return "/admin/admin-home";
    }



}
