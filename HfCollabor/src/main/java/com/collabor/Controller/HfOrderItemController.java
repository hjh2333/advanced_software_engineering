package com.collabor.Controller;

import com.collabor.Dao.HfOrderItemDao;
import com.collabor.Entity.HfOrderItem;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HfOrderItemController {
    @Resource
    HfOrderItemDao hfOrderItemDao;

    @RequestMapping("/orderItem/queryAll")
    public List<HfOrderItem> queryOrderItemAll() {
        return hfOrderItemDao.findAllOrderItem();
    }

    @RequestMapping(value="/orderItem/select", method= RequestMethod.POST)
    public List<HfOrderItem> selectOrderItem(@RequestBody HfOrderItem hfOrderItem){
        System.out.println(hfOrderItem.toString());
        return hfOrderItemDao.selectOrderItem(hfOrderItem);
    }

    //{"order_id":4,"product_id":1,"product_sum":2}
    @RequestMapping(value="/orderItem/insert", method= RequestMethod.POST)
    public int insertOrderItem(@RequestBody HfOrderItem hfOrderItem){
        System.out.println(hfOrderItem.toString());
        if(hfOrderItem.getOrder_id()<=0||hfOrderItem.getProduct_id()<=0||hfOrderItem.getProduct_sum()<=0){
            System.out.println("orderItem插入不合法");
            return 0;
        }
        int temp=hfOrderItemDao.insertOrderItem(hfOrderItem);//想返回主键，但@Options注释和xml的useGeneratedKeys没起作用
        if(temp<=0)
            System.out.println("插入失败");
        else{
            System.out.println("插入记录:"+hfOrderItem.toString());
        }
        return temp;
    }
}
