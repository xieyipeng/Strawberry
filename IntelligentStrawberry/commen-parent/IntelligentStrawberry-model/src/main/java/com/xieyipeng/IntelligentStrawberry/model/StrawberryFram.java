package com.xieyipeng.IntelligentStrawberry.model;

import java.sql.Timestamp;

public class StrawberryFram {
    Integer StrawberryFram_id;
    Integer StrawberryFram_farm_id;
    String StrawberryFram_price;
    String StrawberryFram_address;
    String StrawberryFram_variety_of_strawberry;
    String StrawberryFram_picture;
    Timestamp StrawberryFram_time;

    @Override
    public String toString() {
        return "StrawberryFram{" +
                "StrawberryFram_id=" + StrawberryFram_id +
                ", StrawberryFram_farm_id=" + StrawberryFram_farm_id +
                ", StrawberryFram_price='" + StrawberryFram_price + '\'' +
                ", StrawberryFram_address='" + StrawberryFram_address + '\'' +
                ", StrawberryFram_variety_of_strawberry='" + StrawberryFram_variety_of_strawberry + '\'' +
                ", StrawberryFram_picture='" + StrawberryFram_picture + '\'' +
                ", StrawberryFram_time=" + StrawberryFram_time +
                '}';
    }

    public Integer getStrawberryFram_id() {
        return StrawberryFram_id;
    }

    public void setStrawberryFram_id(Integer strawberryFram_id) {
        StrawberryFram_id = strawberryFram_id;
    }

    public Integer getStrawberryFram_farm_id() {
        return StrawberryFram_farm_id;
    }

    public void setStrawberryFram_farm_id(Integer strawberryFram_farm_id) {
        StrawberryFram_farm_id = strawberryFram_farm_id;
    }

    public String getStrawberryFram_price() {
        return StrawberryFram_price;
    }

    public void setStrawberryFram_price(String strawberryFram_price) {
        StrawberryFram_price = strawberryFram_price;
    }

    public String getStrawberryFram_address() {
        return StrawberryFram_address;
    }

    public void setStrawberryFram_address(String strawberryFram_address) {
        StrawberryFram_address = strawberryFram_address;
    }

    public String getStrawberryFram_variety_of_strawberry() {
        return StrawberryFram_variety_of_strawberry;
    }

    public void setStrawberryFram_variety_of_strawberry(String strawberryFram_variety_of_strawberry) {
        StrawberryFram_variety_of_strawberry = strawberryFram_variety_of_strawberry;
    }

    public String getStrawberryFram_picture() {
        return StrawberryFram_picture;
    }

    public void setStrawberryFram_picture(String strawberryFram_picture) {
        StrawberryFram_picture = strawberryFram_picture;
    }

    public Timestamp getStrawberryFram_time() {
        return StrawberryFram_time;
    }

    public void setStrawberryFram_time(Timestamp strawberryFram_time) {
        StrawberryFram_time = strawberryFram_time;
    }

    public StrawberryFram(Integer strawberryFram_id, Integer strawberryFram_farm_id, String strawberryFram_price, String strawberryFram_address, String strawberryFram_variety_of_strawberry, String strawberryFram_picture, Timestamp strawberryFram_time) {
        StrawberryFram_id = strawberryFram_id;
        StrawberryFram_farm_id = strawberryFram_farm_id;
        StrawberryFram_price = strawberryFram_price;
        StrawberryFram_address = strawberryFram_address;
        StrawberryFram_variety_of_strawberry = strawberryFram_variety_of_strawberry;
        StrawberryFram_picture = strawberryFram_picture;
        StrawberryFram_time = strawberryFram_time;
    }
}
