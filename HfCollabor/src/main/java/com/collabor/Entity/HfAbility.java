package com.collabor.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class HfAbility {
    private int product_ability_id;
    private int factory_id;
    private int product_id;
    private boolean ability_enable;
    private int willingness;
    private int stock;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime update_time;//工厂生产能力更新时间

    public int getProduct_ability_id() {
        return product_ability_id;
    }

    public void setProduct_ability_id(int product_ability_id) {
        this.product_ability_id = product_ability_id;
    }

    public int getFactory_id() {
        return factory_id;
    }

    public void setFactory_id(int factory_id) {
        this.factory_id = factory_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public boolean isAbility_enable() {
        return ability_enable;
    }

    public void setAbility_enable(boolean ability_enable) {
        this.ability_enable = ability_enable;
    }

    public int getWillingness() {
        return willingness;
    }

    public void setWillingness(int willingness) {
        this.willingness = willingness;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "HfAbility{" +
                "product_ability_id=" + product_ability_id +
                ", factory_id=" + factory_id +
                ", product_id=" + product_id +
                ", ability_enable=" + ability_enable +
                ", willingness=" + willingness +
                ", stock=" + stock +
                ", update_time=" + update_time +
                '}';
    }
}
