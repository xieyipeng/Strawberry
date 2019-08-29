package com.xieyipeng.IntelligentStrawberry.model;

import java.sql.Timestamp;

public class Monitor {
    Integer monitor_id;
    Integer monitor_StrawberryFram_id;
    String monitor_temperature;
    String monitor_humidity;
    String monitor_sensor_id;
    Timestamp monitor_time;

    public Monitor(Integer monitor_id, Integer monitor_StrawberryFram_id, String monitor_temperature, String monitor_humidity, String monitor_sensor_id, Timestamp monitor_time) {
        this.monitor_id = monitor_id;
        this.monitor_StrawberryFram_id = monitor_StrawberryFram_id;
        this.monitor_temperature = monitor_temperature;
        this.monitor_humidity = monitor_humidity;
        this.monitor_sensor_id = monitor_sensor_id;
        this.monitor_time = monitor_time;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "monitor_id=" + monitor_id +
                ", monitor_StrawberryFram_id=" + monitor_StrawberryFram_id +
                ", monitor_temperature='" + monitor_temperature + '\'' +
                ", monitor_humidity='" + monitor_humidity + '\'' +
                ", monitor_sensor_id='" + monitor_sensor_id + '\'' +
                ", monitor_time=" + monitor_time +
                '}';
    }

    public Integer getMonitor_id() {
        return monitor_id;
    }

    public void setMonitor_id(Integer monitor_id) {
        this.monitor_id = monitor_id;
    }

    public Integer getMonitor_StrawberryFram_id() {
        return monitor_StrawberryFram_id;
    }

    public void setMonitor_StrawberryFram_id(Integer monitor_StrawberryFram_id) {
        this.monitor_StrawberryFram_id = monitor_StrawberryFram_id;
    }

    public String getMonitor_temperature() {
        return monitor_temperature;
    }

    public void setMonitor_temperature(String monitor_temperature) {
        this.monitor_temperature = monitor_temperature;
    }

    public String getMonitor_humidity() {
        return monitor_humidity;
    }

    public void setMonitor_humidity(String monitor_humidity) {
        this.monitor_humidity = monitor_humidity;
    }

    public String getMonitor_sensor_id() {
        return monitor_sensor_id;
    }

    public void setMonitor_sensor_id(String monitor_sensor_id) {
        this.monitor_sensor_id = monitor_sensor_id;
    }

    public Timestamp getMonitor_time() {
        return monitor_time;
    }

    public void setMonitor_time(Timestamp monitor_time) {
        this.monitor_time = monitor_time;
    }
}
