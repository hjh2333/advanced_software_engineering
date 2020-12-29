package com.collabor.Controller.flow;

import com.collabor.Controller.HfOrderController;
import com.collabor.Controller.HfOrderItemController;
import com.collabor.Dao.HfOrderDao;
import com.collabor.Dao.HfOrderItemDao;
import com.collabor.Dao.HfProductDao;
import com.collabor.Entity.HfOrder;
import com.collabor.Entity.HfOrderItem;
import com.collabor.Entity.HfProduct;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class testFlow {
    @Resource
    HfOrderDao hfOrderDao;
    @Resource
    HfOrderItemDao hfOrderItemDao;
    @Resource
    HfProductDao hfProductDao;

    @RequestMapping(value="/testFlow/placeOrder", method= RequestMethod.POST)
    public String placeOrder(@RequestBody HfOrder order){//下订单
        //HfOrderController temp=new HfOrderController();//new个controller来调用为啥不起作用？？
        String returnStr="";
        if(order.getAdmin_id()<=0){
            returnStr+="请提交合法admin_id;";
        }
        if(order.getDeadline()==null){
            returnStr+="请提交合法deadline;";
        }
        if(returnStr!="")
            return returnStr;
        String format = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        // DateTimeFormatter.ofPattern方法根据指定的格式输出时间
        String formatDateTime = LocalDateTime.now().format(df);
        order.setCreate_time(LocalDateTime.parse(formatDateTime,df));//初始化下单时间
        order.setStatus("AdvanceOrder");//初始化预订单状态  可以不要这条，因为看xml文件可以看出插入没有写这条。
       int orderId=hfOrderDao.insertOrder(order);
        if(orderId<=0){
            returnStr+="新订单记录插入失败";
            return returnStr;
        }
        //order.setOrder_id(0);为啥order的order_id已经变成了数据库里生成的相应的
        /*List<HfOrder> tempOrder=hfOrderDao.selectOrder(order);
        if(tempOrder.size()<=0){
            returnStr+="查询失败";
        }
        HfOrder tempHFOrder=tempOrder.get(0);
        orderId=tempHFOrder.getOrder_id();*/
        orderId=order.getOrder_id();
        returnStr+=" orderId为"+String.valueOf(orderId)+"的新订单记录插入成功;";

//      测试，只针对桌子
        HfOrderItem hfOrderItem=new HfOrderItem();
        hfOrderItem.setOrder_id(orderId);
        hfOrderItem.setProduct_id(7);
        hfOrderItem.setProduct_sum(1);
        hfOrderItemDao.insertOrderItem(hfOrderItem);
        returnStr+=" orderItemId为"+String.valueOf(hfOrderItem.getOrder_item_id())+"的新订单条目记录插入成功;";


        return returnStr;
    }


    @RequestMapping(value="/testFlow/decompose", method= RequestMethod.POST)//decomposition分解
    public int decompose(@RequestBody HfOrderItem hfOrderItem){
        HfProduct hfProduct=new HfProduct();
        hfProduct.setProduct_id(hfOrderItem.getProduct_id());
        List<HfProduct> tempList=hfProductDao.selectProduct(hfProduct);
        if(tempList.isEmpty()){
            return 0;
        }
        hfProduct=tempList.get(0);
        String graph=hfProduct.getProduct_description();
        distribute();
        return 1;
    }

    @RequestMapping(value="/testFlow/distribute")//distribution分配
    public void distribute(){
        System.out.println('b');
    }
}
