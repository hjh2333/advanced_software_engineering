package com.collabor.Entity.Dto;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class testDTO {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime day_time;
    private int num;

    public LocalDateTime getDay_time() {
        return day_time;
    }

    public void setDay_time(LocalDateTime day_time) {
        this.day_time = day_time;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "testDTO{" +
                "day_time=" + day_time +
                ", num=" + num +
                '}';
    }
}
