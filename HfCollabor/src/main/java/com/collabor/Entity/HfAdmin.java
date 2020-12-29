package com.collabor.Entity;

//管理员类
public class HfAdmin {
    private int admin_id;      //MySql自动生成的主键
    private String admin_name;//管理员用户名
    private String admin_password; //管理员密码

    //下面的方法都是IDEA自动生成的，mybatis对它们的命名有要求。
    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    @Override
    public String toString() {
        return "HfAdmin{" +
                "admin_id=" + admin_id +
                ", admin_name='" + admin_name + '\'' +
                ", admin_password='" + admin_password + '\'' +
                '}';
    }
}
