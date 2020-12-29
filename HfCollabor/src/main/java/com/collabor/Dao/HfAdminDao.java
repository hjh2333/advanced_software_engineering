package com.collabor.Dao;

import com.collabor.Entity.HfAdmin;

import java.util.List;

public interface HfAdminDao {
    List<HfAdmin> findAllAdmins(); //查询所有管理员。
    List<HfAdmin> selectAdmin(HfAdmin hfAdmin);
}
