package com.collabor.Dao;

import com.collabor.Entity.HfFactory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HfFactoryDao {
    List<HfFactory> findAllFactory();
    List<HfFactory> login(@Param("factoryName")String factoryName, @Param("factoryPassword")String factoryPassword);
}
