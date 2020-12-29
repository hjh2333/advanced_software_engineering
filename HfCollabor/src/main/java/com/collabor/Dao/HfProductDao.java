package com.collabor.Dao;

import com.collabor.Entity.HfProduct;

import java.util.List;

public interface HfProductDao {
    List<HfProduct> findAllProduct();
    List<HfProduct> selectProduct(HfProduct hfProduct);
    int insertProduct(HfProduct hfProduct);
    int updateProduct(HfProduct hfProduct);
}
