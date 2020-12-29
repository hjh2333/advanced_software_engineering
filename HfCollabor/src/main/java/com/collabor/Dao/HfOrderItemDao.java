package com.collabor.Dao;


import com.collabor.Entity.HfOrderItem;

import java.util.List;

public interface HfOrderItemDao {
    List<HfOrderItem> findAllOrderItem();
    List<HfOrderItem> selectOrderItem(HfOrderItem orderItem);
    int insertOrderItem(HfOrderItem orderItem);
}
