package com.xieyipeng.IntelligentStrawberry.web.controller;

import com.alibaba.fastjson.JSON;
import com.xieyipeng.IntelligentStrawberry.model.LoadMonitor;
import com.xieyipeng.IntelligentStrawberry.model.Monitor;
import com.xieyipeng.IntelligentStrawberry.service.IMonitorService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
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
    public String insertMonitor() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String url = "file:///C:/Users/xieyipeng/Desktop/%E6%96%B0%E5%BB%BA%E6%96%87%E6%9C%AC%E6%96%87%E6%A1%A3.html";
//                        String url = "http://192.168.0.1/cgi-bin/node.cgi";
                        StringBuffer buffer = new StringBuffer();
                        URL mine_url = new URL(url);
                        URLConnection connection = mine_url.openConnection();
                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                        String input_line = null;
                        while ((input_line = in.readLine()) != null) {
                            buffer.append(input_line);
                        }
                        in.close();
                        System.out.println(buffer.toString());

                        Integer monitor_StrawberryFram_id = 1;
                        String monitor_temperature = "";
                        String monitor_humidity = "";
                        String monitor_sensor_id = "";

                        JSONArray jsonArray = new JSONArray(buffer.toString());

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            JSONArray tem_hum = jsonObject.getJSONArray("funcList");
                            if (tem_hum.length() == 2) {
                                monitor_sensor_id = jsonObject.getString("macAddr");
                                JSONObject tem = tem_hum.getJSONObject(0);
                                JSONObject hum = tem_hum.getJSONObject(1);

                                monitor_temperature = String.valueOf(tem.getDouble("data"));
                                monitor_humidity = String.valueOf(hum.getDouble("data"));
                            }
                        }

                        Map<String, Object> param = new HashMap<>();
                        param.put("monitor_StrawberryFram_id", monitor_StrawberryFram_id);
                        param.put("monitor_temperature", monitor_temperature);
                        param.put("monitor_humidity", monitor_humidity);
                        param.put("monitor_sensor_id", monitor_sensor_id);
//                        System.out.println("温度： "+monitor_temperature);
//                        monitorService.insertMonitor(params);
//                        System.out.println("success insert");
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        }).start();
        return "moniter_service";
    }

    @RequestMapping("findAll")
    @ResponseBody
    public String findAll() {
        List<Monitor> monitors = monitorService.findAll();
        List<LoadMonitor> loadMonitors = new ArrayList<>();
        StringBuilder res = new StringBuilder();

//        StringBuilder tem = new StringBuilder();
//        StringBuilder hum = new StringBuilder();
//        StringBuilder tim = new StringBuilder();
//
//
        if (monitors.size() != 0) {
//            List<LoadMonitor> loadMonitors = new ArrayList<>();
            DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//
//
//            for (int i = 0; i < monitors.size(); i++) {
//                Monitor temp = monitors.get(i);
//                tem.append(temp.getMonitor_temperature()).append(",");
//                hum.append(temp.getMonitor_humidity()).append(",");
//                tim.append("\""+sdf.format(temp.getMonitor_time())+"\"").append(",");
//            }
//            res.append("{\"tim\":[").append(tim).append("],")
//                    .append("\"tem\":[").append(tem).append("],")
//                    .append("\"hum\":[").append(hum).append("]}");

            for (int i = 0; i < monitors.size(); i++) {
                Monitor temp = monitors.get(i);
                LoadMonitor loadMonitor = new LoadMonitor(Double.valueOf(temp.getMonitor_temperature())
                        , Double.valueOf(temp.getMonitor_humidity())
                        , sdf.format(temp.getMonitor_time()));
                loadMonitors.add(loadMonitor);
            }
            String json = JSON.toJSONString(loadMonitors);
//            return res.toString();
            return json.toString();
        }
        return null;
    }
}
