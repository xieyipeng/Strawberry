package com.xieyipeng.IntelligentStrawberry.web.controller;

import com.alibaba.fastjson.JSON;
import com.xieyipeng.IntelligentStrawberry.model.tools.LoadMonitor;
import com.xieyipeng.IntelligentStrawberry.model.Monitor;
import com.xieyipeng.IntelligentStrawberry.service.IMonitorService;
import com.xieyipeng.IntelligentStrawberry.web.controller.tools.GetPostUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("monitor")
public class MonitorController {

    //http://192.168.0.1/topo.html

    @Autowired
    private IMonitorService monitorService;

    @RequestMapping("insertMonitor")
    @ResponseBody
    public String insertMonitor() {
        try {
//            String url = "file:///C:/Users/xieyipeng/Desktop/%E6%96%B0%E5%BB%BA%E6%96%87%E6%9C%AC%E6%96%87%E6%A1%A3.html";
            String url = "http://192.168.0.1/cgi-bin/node.cgi";
            StringBuilder stringBuilder = new StringBuilder();
            URL mine_url = new URL(url);
            URLConnection connection = mine_url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String input_line = null;
            while ((input_line = in.readLine()) != null) {
                stringBuilder.append(input_line);
            }
            in.close();
//            System.out.println(stringBuilder.toString());
            Integer monitor_StrawberryFram_id = 2;
            String monitor_temperature = "";
            String monitor_humidity = "";
            String monitor_sensor_id = "";
            JSONArray jsonArray = new JSONArray(stringBuilder.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONArray tem_hum = jsonObject.getJSONArray("funcList");
                if (tem_hum.length() == 2) {
                    monitor_sensor_id = jsonObject.getString("macAddr");
                    JSONObject tem = tem_hum.getJSONObject(0);
                    JSONObject hum = tem_hum.getJSONObject(1);

                    monitor_temperature = String.valueOf(tem.getDouble("data"));
                    monitor_humidity = String.valueOf(hum.getDouble("data"));
                    break;
                }
            }
            Map<String, Object> param = new HashMap<>();
            param.put("monitor_StrawberryFram_id", monitor_StrawberryFram_id);
            param.put("monitor_temperature", monitor_temperature);
            param.put("monitor_humidity", monitor_humidity);
            param.put("monitor_sensor_id", monitor_sensor_id);
//            System.out.println("温度： " + monitor_temperature);
            monitorService.insertMonitor(param);
//            System.out.println("success insert");
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return "failed";
    }

    @RequestMapping("findAll")
    @ResponseBody
    public String findAll() {
        List<Monitor> monitors = monitorService.findAll();
        List<LoadMonitor> loadMonitors = new ArrayList<>();
        if (monitors.size() != 0) {
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            for (Monitor monitor : monitors) {
                LoadMonitor loadMonitor = new LoadMonitor(
                        monitor.getMonitor_id(),
                        monitor.getMonitor_StrawberryFram_id(),
                        monitor.getMonitor_temperature(),
                        monitor.getMonitor_humidity(),
                        monitor.getMonitor_sensor_id(),
                        sdf.format(monitor.getMonitor_time())
                );
                loadMonitors.add(loadMonitor);
            }
            return JSON.toJSONString(loadMonitors);
        }
        return null;
    }


    @RequestMapping("findRecently")
    @ResponseBody
    public String findRecently() {
        List<Monitor> monitors = monitorService.findRecently();
        List<LoadMonitor> loadMonitors = new ArrayList<>();
        if (monitors.size() != 0) {
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            for (Monitor monitor : monitors) {
                LoadMonitor loadMonitor = new LoadMonitor(
                        monitor.getMonitor_id(),
                        monitor.getMonitor_StrawberryFram_id(),
                        monitor.getMonitor_temperature(),
                        monitor.getMonitor_humidity(),
                        monitor.getMonitor_sensor_id(),
                        sdf.format(monitor.getMonitor_time())
                );
                loadMonitors.add(loadMonitor);
            }
            return JSON.toJSONString(loadMonitors);
        }
//        return JSON.toJSONString(monitors);
        return null;
    }

    @RequestMapping("findRecentlyOne")
    @ResponseBody
    public String findRecentlyOne() {
        List<Monitor> monitors = monitorService.findRecentlyOne();
        List<LoadMonitor> loadMonitors = new ArrayList<>();
        if (monitors.size() != 0) {
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            for (Monitor monitor : monitors) {
                LoadMonitor loadMonitor = new LoadMonitor(
                        monitor.getMonitor_id(),
                        monitor.getMonitor_StrawberryFram_id(),
                        monitor.getMonitor_temperature(),
                        monitor.getMonitor_humidity(),
                        monitor.getMonitor_sensor_id(),
                        sdf.format(monitor.getMonitor_time())

                );

                loadMonitors.add(loadMonitor);
            }
            return JSON.toJSONString(loadMonitors);
        }
//        return JSON.toJSONString(monitors);
        return null;
    }


    @RequestMapping("androidRecently")
    @ResponseBody
    public String androidRecently() {
        List<LoadMonitor> monitors = monitorService.androidRecently();
        return JSON.toJSONString(monitors);
    }

    @RequestMapping("get-v")
    @ResponseBody
    public String getV(@RequestParam("v")Integer v) {
        try {
            GetPostUtil.sendGetRequest("http://192.168.0.1/cgi-bin/send_node.cgi?=type=11%26data="+v);
        }catch (Exception e){
            e.printStackTrace();
            return "failed";
        }        return "success";
    }

//    /**
//     * 获取数据
//     *
//     * @param request request - 上传方式对应python工程下/ssm_post_data;
//     * @return success
//     */
//    @RequestMapping("uploadData")
//    @ResponseBody
//    public String uploadData(HttpServletRequest request,@RequestParam("app_id") String app_id) {
//        System.out.println("app_id: "+app_id);
//        return "success";
//    }


//    /**
//     * 接收文件（图片）
//     *
//     * @param request request
//     * @return if success
//     */
//    @RequestMapping("uploadFile")
//    @ResponseBody
//    public String uploadFiled(HttpServletRequest request, HttpServletResponse response
//            , @RequestParam("file") MultipartFile file, @RequestParam("app_id") String app_id) {
//        System.out.println(file.getName());
//        return "success";
//    }


//    /**
//     * 接收文件（图片）
//     *
//     * @param request request
//     * @return if success
//     */
//    @RequestMapping("uploadFile")
//    @ResponseBody
//    public String uploadFiled(HttpServletRequest request,@RequestParam("file") MultipartFile file) {
//        System.out.println(file.getOriginalFilename());
//
//        return "success";
//    }
}
