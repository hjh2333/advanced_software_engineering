package com.collabor.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class HfOrder {
    private int order_id;
    private int admin_id;
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deadline;//顾客定的期望交付时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime  create_time;	//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime predict_time;	//预测完成时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime  complete_time;	//实际完成时间

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public LocalDateTime getPredict_time() {
        return predict_time;
    }

    public void setPredict_time(LocalDateTime predict_time) {
        this.predict_time = predict_time;
    }

    public LocalDateTime getComplete_time() {
        return complete_time;
    }

    public void setComplete_time(LocalDateTime complete_time) {
        this.complete_time = complete_time;
    }

    @Override
    public String toString() {
        return "HfOrder{" +
                "order_id=" + order_id +
                ", admin_id=" + admin_id +
                ", status='" + status + '\'' +
                ", deadline=" + deadline +
                ", create_time=" + create_time +
                ", predict_time=" + predict_time +
                ", complete_time=" + complete_time +
                '}';
    }
}
