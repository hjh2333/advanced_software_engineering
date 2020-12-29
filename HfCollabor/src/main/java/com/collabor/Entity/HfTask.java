package com.collabor.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;


/*
@JsonFormat注解是一个时间格式化注解，比如我们存储在mysql中的数据是date类型的，
当我们读取出来封装在实体类中的时候，就会变成英文时间格式，而不是yyyy-MM-dd HH:mm:ss这样的中文时间，
因此我们需要用到JsonFormat注解来格式化我们的时间。
要注意的是，它只会在类似@ResponseBody返回json数据的时候，才会返回格式化的yyyy-MM-dd HH:mm:ss时间，
你直接使用System.out.println()输出的话，仍然是类似“Fri Dec 01 21:05:20 CST 2017”这样的时间样式。
 */
public class HfTask {
    private  int task_id;	//主键
    private  String task_status;	//状态
    private  int factory_id;	//外键 家庭工厂
    private int order_id;	//外键 订单
    private int  product_id;	//外键 产品
    private int  num;	//产品数量
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime  create_time;	//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime predict_time;	//预测完成时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime  complete_time;	//实际完成时间
    private int completed_quantity;	//已完成数量

    /*
    注意： 当定义了其它构造函数，必须手工添加无参构造函数。
    spring boot 自动注入的时候使用的是无参构造函数。至少IDEA编译器必须如此，Eclipse没有试验过。
     */
    public HfTask()
    {

    }

    /*
    下面的构造函数是IDEA自动生成的，HfTaskController中，有这样一个构造函数，可简化代码。
    在此类的文档上，右键点击，选择菜单Generator=>Constructor,......。
    */
    public HfTask(int task_id, String task_status, int factory_id, int order_id, int product_id, int num,
                  LocalDateTime create_time, LocalDateTime predict_time, LocalDateTime complete_time,
                  int completed_quantity) {
        this.task_id = task_id;
        this.task_status = task_status;
        this.factory_id = factory_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.num = num;
        this.create_time = create_time;
        this.predict_time = predict_time;
        this.complete_time = complete_time;
        this.completed_quantity = completed_quantity;
    }

    /*
    下面的方法都是IDEA自动生成的，mybatis对它们的命名有要求。
    在此类的文档上，右键点击，选择菜单Generator=>Getter and Setter,所有属性选择后，再生成。
    */
    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_status() {
        return task_status;
    }

    public void setTask_status(String status) {
        this.task_status = status;
    }

    public int getFactory_id() {
        return factory_id;
    }

    public void setFactory_id(int factory_id) {
        this.factory_id = factory_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public int getCompleted_quantity() {
        return completed_quantity;
    }

    public void setCompleted_quantity(int completed_quantity) {
        this.completed_quantity = completed_quantity;
    }
}
