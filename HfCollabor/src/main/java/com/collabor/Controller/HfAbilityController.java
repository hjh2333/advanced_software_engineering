package com.collabor.Controller;

import com.collabor.Dao.HfAbilityDao;
import com.collabor.Entity.HfAbility;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HfAbilityController {
    @Resource
    HfAbilityDao hfAbilityDao;

    @RequestMapping("/ability/queryAll")
    public List<HfAbility> queryAbilityAll() {
        return hfAbilityDao.findAllAbility();
    }

    //{"product_ability_id":6}
    //{"factory_id":1,"product_id":1}
    @RequestMapping(value="/ability/select", method= RequestMethod.POST)
    List<HfAbility> selectAbility(@RequestBody HfAbility hfAbility){//SOS!!!没加requestbody那么request提交不到这个变量里
        System.out.println(hfAbility.toString());
        return hfAbilityDao.selectAbility(hfAbility);
    }

    //{"factory_id":1,"product_id":1}该把这对设成主键的，不然有bug，不要用insert
    @RequestMapping(value="/ability/insert", method= RequestMethod.POST)
    int insertAbility(@RequestBody HfAbility hfAbility){
        int temp=hfAbilityDao.insertAbility(hfAbility);
        if(temp<=0)
            System.out.println("插入失败");
        else{
            System.out.println("插入记录:"+hfAbility.toString());
        }
        return temp;
    }

    //{"product_ability_id":6,"willingness":5}
    @RequestMapping(value="/ability/update", method= RequestMethod.POST)
    int updateAbility(@RequestBody HfAbility hfAbility){
        int temp=hfAbilityDao.updateAbility(hfAbility);
        if(temp<=0)
            System.out.println("更新失败");
        else{
            System.out.println("更新记录:"+hfAbility.toString());
        }
        return temp;
    }
}
