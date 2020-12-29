package com.collabor.Controller;

import com.collabor.Dao.HfOrderDao;
import com.collabor.Entity.HfOrder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class HfOrderController {
    @Resource
    HfOrderDao hfOrderDao;

    @RequestMapping("/order/queryAll")
    public List<HfOrder> queryOrderAll() {
        return hfOrderDao.findAllOrder();
    }

    //String orderId,String adminId,String status,String deadline,String createTime,String predictTime,String completeTime
    //post示例 {"order_id":1,"admin_id":null,"status":null,"deadline":null,"create_time":null,"predict_time":null,"complete_time":null}
    //{"status":"AdvanceOrder"}
    //{"create_time":"2021-10-20 00:00:00"}
    @RequestMapping(value="/order/select", method= RequestMethod.POST)
    public List<HfOrder> selectOrder(@RequestBody HfOrder order){
        System.out.println(order.toString());
        return hfOrderDao.selectOrder(order);
    }

//    @RequestMapping(value="/order/countByDay")
//    public List<Integer> countOrderByDay(){
//        List<Integer> ans= hfOrderDao.countOrderByDay();
//        return ans;
//    }

    //{"admin_id":"1","deadline": "2021-10-20 00:00:00"}
    @RequestMapping(value="/order/insert", method= RequestMethod.POST)
    public int insertOrder(@RequestBody HfOrder order){
        int temp=hfOrderDao.insertOrder(order);//想返回主键，但@Options注释和xml的useGeneratedKeys没起作用
        if(temp<=0)
            System.out.println("插入失败");
        else{
            System.out.println("插入记录:"+order.toString());
        }
        return temp;
    }

    //{"order_id":5,"status":"completed"}
    @RequestMapping(value="/order/update", method= RequestMethod.POST)
    public int updateOrder(@RequestBody HfOrder order){
        int temp=hfOrderDao.updateOrder(order);
        if(temp<=0)
            System.out.println("更新失败");
        else{
            System.out.println("更新记录:"+order.toString());
        }
        return temp;
    }
}