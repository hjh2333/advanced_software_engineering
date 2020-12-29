package com.collabor.Dao;

import com.collabor.Entity.HfAbility;

import java.util.List;

public interface HfAbilityDao {
    List<HfAbility> findAllAbility();
    List<HfAbility> selectAbility(HfAbility hfAbility);
    int insertAbility(HfAbility hfAbility);
    int updateAbility(HfAbility hfAbility);
}
