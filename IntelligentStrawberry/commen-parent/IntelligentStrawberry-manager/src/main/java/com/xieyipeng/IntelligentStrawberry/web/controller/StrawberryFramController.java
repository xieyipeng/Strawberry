package com.xieyipeng.IntelligentStrawberry.web.controller;

import com.alibaba.fastjson.JSON;
import com.xieyipeng.IntelligentStrawberry.model.StrawberryFram;
import com.xieyipeng.IntelligentStrawberry.service.IStrawberryFramService;
import com.xieyipeng.IntelligentStrawberry.web.controller.tools.Constant;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("farm")
public class StrawberryFramController {

    @Autowired
    private IStrawberryFramService strawberryFramService;

    @RequestMapping("insert-farm")
    @ResponseBody
    public String insertFarm(HttpServletRequest request, @RequestParam("file") MultipartFile file
            , @RequestParam("StrawberryFram_farm_id") String StrawberryFram_farm_id
            , @RequestParam("StrawberryFram_price") String StrawberryFram_price
            , @RequestParam("StrawberryFram_address") String StrawberryFram_address
            , @RequestParam("StrawberryFram_variety_of_strawberry") String StrawberryFram_variety_of_strawberry) {
        Map<String, Object> param = new HashMap<>();
        param.put("StrawberryFram_farm_id", Integer.valueOf(StrawberryFram_farm_id));
        param.put("StrawberryFram_price", StrawberryFram_price);
        param.put("StrawberryFram_address", StrawberryFram_address);
        param.put("StrawberryFram_variety_of_strawberry", StrawberryFram_variety_of_strawberry);
        File new_file = null;

        if (!file.isEmpty()) {
            try {
                String filepath = Constant.UPLOAD_PATH + StrawberryFram_farm_id + "\\" + file.getOriginalFilename();
                new_file = new File(filepath);
                if (!new_file.getParentFile().exists()) {
                    new_file.getParentFile().mkdirs();
                }
                file.transferTo(new_file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        param.put("StrawberryFram_picture", new_file.getPath());
        strawberryFramService.insertFarm(param);
        return "success";
    }


    @RequestMapping(value = "select_i", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String select_i(@RequestParam("StrawberryFram_farm_id") Integer StrawberryFram_farm_id) {
        Map<String, Object> param = new HashMap<>();
        param.put("StrawberryFram_farm_id", StrawberryFram_farm_id);
        List<StrawberryFram> strawberryFrams = strawberryFramService.select_i(param);
        for (StrawberryFram strawberryFram : strawberryFrams) {
            strawberryFram.setStrawberryFram_picture(strawberryFram.getStrawberryFram_picture().substring(98));
        }
        System.out.println(JSON.toJSONString(strawberryFrams));
        return JSON.toJSONString(strawberryFrams);
    }


    @ResponseBody
    @RequestMapping(value = "findAll", produces = "text/html;charset=UTF-8")
    public String findAll(){
        List<StrawberryFram> strawberryFrams=strawberryFramService.findAll();
        System.out.println(JSON.toJSONString(strawberryFrams));
        if (strawberryFrams.size() != 0) {
            /**
             for (int i = 0; i < users.size(); i++) {
             System.out.println(users.get(i));
             }
             **/
            JSONObject map = new JSONObject(true);
            map.put("count", strawberryFrams.size());
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", strawberryFrams);
            return map.toString();
        } else {
            System.out.println("user size == null!");
        }
        return null;
    }
}
