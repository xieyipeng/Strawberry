package com.xieyipeng.IntelligentStrawberry.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page-jump")
public class PageJumpController {
    @RequestMapping("to-admin-home")
    public String toAdmin() {
        return "/admin/admin-home";
    }

    @RequestMapping("to-farm-home")
    public String toFarm() {
        return "/farm/farm-home";
    }


    @RequestMapping("to-gallery1")
    public String toGallery1() {
        return "gallery/gallery1";
    }

    @RequestMapping("to-gallery2")
    public String toGallery2() {
        return "gallery/gallery2";
    }

    @RequestMapping("to-gallery3")
    public String toGallery3() {
        return "gallery/gallery3";
    }

    @RequestMapping("to-gallery4")
    public String toGallery4() {
        return "gallery/gallery4";
    }

    @RequestMapping("to-gallery5")
    public String toGallery5() {
        return "gallery/gallery5";
    }

    @RequestMapping("to-gallery6")
    public String toGallery6() {
        return "gallery/gallery6";
    }

    @RequestMapping("to-control")
    public String toControl() {
        return "control";
    }


}
