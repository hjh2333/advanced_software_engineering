package com.collabor.Entity;

public class HfFactory {
    private int factory_id;
    private String factory_name;
    private String factory_password;
    private double score;

    public int getFactory_id() {
        return factory_id;
    }

    public void setFactory_id(int factory_id) {
        this.factory_id = factory_id;
    }

    public String getFactory_name() {
        return factory_name;
    }

    public void setFactory_name(String factory_name) {
        this.factory_name = factory_name;
    }

    public String getFactory_password() {
        return factory_password;
    }

    public void setFactory_password(String factory_password) {
        this.factory_password = factory_password;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "HfFactory{" +
                "factory_id=" + factory_id +
                ", factory_name='" + factory_name + '\'' +
                ", factory_password='" + factory_password + '\'' +
                ", score=" + score +
                '}';
    }
}
