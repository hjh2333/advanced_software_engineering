package com.collabor.Dao;


import com.collabor.Entity.HfOrder;
import org.apache.ibatis.annotations.Options;


import java.util.List;

public interface HfOrderDao {
    List<HfOrder> findAllOrder();
    List<HfOrder> selectOrder(HfOrder order);
    @Options(useGeneratedKeys = true, keyProperty = "order_id", keyColumn = "order_id")
    int insertOrder(HfOrder order);
    int updateOrder(HfOrder order);
//    List<Integer> countOrderByDay();
}
