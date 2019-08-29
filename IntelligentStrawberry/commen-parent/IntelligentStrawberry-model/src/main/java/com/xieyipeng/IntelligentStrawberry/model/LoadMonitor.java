package com.xieyipeng.IntelligentStrawberry.model;

import java.sql.Timestamp;

public class LoadMonitor {
    Double monitor_temperature;
    Double monitor_humidity;
    String monitor_time;

    @Override
    public String toString() {
        return "LoadMonitor{" +
                "monitor_temperature=" + monitor_temperature +
                ", monitor_humidity=" + monitor_humidity +
                ", monitor_time='" + monitor_time + '\'' +
                '}';
    }

    public Double getMonitor_temperature() {
        return monitor_temperature;
    }

    public void setMonitor_temperature(Double monitor_temperature) {
        this.monitor_temperature = monitor_temperature;
    }

    public Double getMonitor_humidity() {
        return monitor_humidity;
    }

    public void setMonitor_humidity(Double monitor_humidity) {
        this.monitor_humidity = monitor_humidity;
    }

    public String getMonitor_time() {
        return monitor_time;
    }

    public void setMonitor_time(String monitor_time) {
        this.monitor_time = monitor_time;
    }

    public LoadMonitor(Double monitor_temperature, Double monitor_humidity, String monitor_time) {
        this.monitor_temperature = monitor_temperature;
        this.monitor_humidity = monitor_humidity;
        this.monitor_time = monitor_time;
    }
}
