package com.collabor.Controller;

import com.collabor.Dao.HfTaskDao;
import com.collabor.Entity.HfTask;
import com.collabor.Tools.HfDbCheck;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
   Post or Get 等URL参数，大小写敏感。
   localhost:21089/task/queryAll （queryall则是另外一个指令了。）
   另外要注意：方法中没有用@RequestHeader等来注解的参数名，在Post/Get 请求中，必须同名。
        有如下方法： @RequestMapping("/task/delete")
                    public Boolean deleteTask( Integer taskId ) {
         那么localhost:21089/task/delete?taskId=3  通过
            localhost:21089/task/delete?id=3  出错。  !!!!!!!!!!!!!!!!!!!!!!!!!!!
*/
/*
   @GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。
   该注解将HTTP Get 映射到 特定的处理方法上。
   同理@PostMapping也是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写。
   注意：@RequestMapping如果没有指定请求方式，将接收Get、Post、Head、Options等所有的请求方式。
*/
/*
@RestController注解，相当于@Controller+@ResponseBody两个注解的结合，
 @Responsebody后，返回结果直接写入HTTP response body中，不会被解析为跳转路径，
 所以你总是看到是打印字符串的效果，不是跳转效果。
 */
@RestController
public class HfTaskController {
    @Resource
    HfTaskDao hfTaskDao;

    // 测试PostMan和此系统的联系
    //        localhost:21089/test
    @RequestMapping("/test")
    public String test() {
        return "hello hjh";
    }

    // 查询所有任务
    //        localhost:21089/task/queryAll
    @RequestMapping("/task/queryAll")
    public List<HfTask> queryAll() {
        return hfTaskDao.findAllTasks();
    }

    // 查询对应id的任务
    //        localhost:21089/task/queryTask?taskId=2
    @RequestMapping("/task/queryTask")
    public HfTask queryTask(Integer taskId) {
       if( taskId==null || taskId<1 )
           return null;
        return hfTaskDao.searchTaskById(taskId);
    }

    /* 给定factoryId，查询所有Task
            localhost:21089/task/queryTaskFact?factoryId=1
     */
    @RequestMapping("/task/queryTaskFact")
    public List<HfTask> queryTaskFact(Integer factoryId) {
        if( factoryId==null || factoryId<1 )
            return null;
        return hfTaskDao.searchTaskByFactoryId(factoryId);
    }

    /* 给定factoryId 和 taskStatus，查询所有Task
           localhost:21089/task/queryTaskFstau?factoryId=1&taskStatus=Terminated
            localhost:21089/task/queryTaskFstau?factoryId=3&taskStatus=AllocatedForProduction
    */
    @RequestMapping("/task/queryTaskFstau")
    public List<HfTask> queryTaskFstau(Integer factoryId,String taskStatus ){
        if( factoryId==null || factoryId<1 || false== HfDbCheck.isValidTaskStatus(taskStatus) )
            return null;
        return hfTaskDao.searchTaskByFactoryStatus(factoryId,taskStatus);
    }
    /*
    插入一个task
    localhost:21089/task/insertTask?taskStatus=Terminated&orderId=1&productId=1&num=10
    localhost:21089/task/insertTask?taskStatus=Terminated&factoryId=2&orderId=1&productId=1&num=10
    localhost:21089/task/insertTask?taskStatus=Terminated&factoryId=3&orderId=1&productId=1&num=10&createTime=2010-01-03 10:59:34&predictTime=2010-02-03 10:59:34&completeTime=2010-03-03 10:59:34
    */
    @RequestMapping("/task/insertTask")
    public Boolean insertIntoTask(String taskStatus, Integer factoryId, Integer orderId, Integer productId, Integer num,
                                  String createTime, String  predictTime,String completeTime,
                                  Integer completedQuantity) {
        boolean result = true;
        if( taskStatus==null || orderId==null || productId==null || num==null )
            result =  false;
        else if ( orderId < 1 || productId<1 || num<1|| false== HfDbCheck.isValidTaskStatus(taskStatus) ) {
            result =  false;
        }
        else {
            if( completedQuantity==null )
                completedQuantity = 0;
            if( factoryId==null )
                factoryId = 0;  //如果不改为具体的值，仍然让对象为null，后面无法进行操作。
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime jf_createTime = LocalDateTime.of(2000, 1, 1, 0, 0,0);
            LocalDateTime jf_predictTime = LocalDateTime.of(2000, 10, 1, 0, 0,0);
            LocalDateTime jf_completeTime = LocalDateTime.of(2000, 10, 1, 0, 0,0);
            if( createTime!=null )
                jf_createTime = LocalDateTime.parse(createTime,df);
            if( predictTime!=null )
                jf_predictTime = LocalDateTime.parse(predictTime,df);
            if( completeTime!=null )
                jf_completeTime = LocalDateTime.parse(completeTime,df);

            //task_id=0;它是自动生成的。
            HfTask hfTask = new HfTask(0,taskStatus, factoryId, orderId, productId, num,
                    jf_createTime, jf_predictTime, jf_completeTime,completedQuantity);
            result = hfTaskDao.insertTask(hfTask)>0;
        }
        return result;
    }
    /*
    待分配，ToBeAssigned     已分配待生产，AllocatedForProduction
    生产中，InProduction     已完成，Completed        已终止,Terminated
     */
    /*
         localhost:21089/task/updateStatus?taskId=1&taskStatus=InProduction
         localhost:21089/task/updateStatus?taskId=2&taskStatus=AllocatedForProduction
         localhost:21089/task/updateStatus?taskId=3&taskStatus=Terminated
     */
    @RequestMapping("/task/updateStatus")
    public Boolean updateTaskStatus(Integer taskId, String taskStatus)
    {
        boolean result = true;
        if ( taskId == null || taskId < 1 || false== HfDbCheck.isValidTaskStatus(taskStatus) ) {
            result =  false;
       }
        else {
            result = hfTaskDao.updateTaskStatus(taskId,taskStatus)>0;
        }
        return result;
    }

    /* 删除一条记录:   依据id，删除任务。
             localhost:21089/task/delete?taskId=3
     */
    @RequestMapping("/task/delete")
    public Boolean deleteTask( Integer taskId ) {
        boolean result = true;
        if (  taskId == null || taskId < 1  ) {
            result = false;
        }
        else
            result = hfTaskDao.deleteTask(taskId) > 0;
        return result;
    }
}
