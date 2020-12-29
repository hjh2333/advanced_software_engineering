package com.collabor;

public class OperationTechnologyManual {
    //操作手册
    private static void operationManual()
    {
/*
1,PostMan与Task表的交互，以端口21089为例
    查询所有Task     localhost:21089/task/queryAll
    查询对应id的Task localhost:21089/task/queryTask?taskId=2
    插入一个task （该表设计时，task_status,order_id,product_id字段不可为空，所以这三个值必须输入，其它字段可选）
        另外，task_status只接受以下字符串
           "ToBeAssigned","AllocatedForProduction","InProduction","Completed","Terminated"
        常见的输入方式有
        localhost:21089/task/insertTask?taskStatus=Terminated&orderId=1&productId=1
        localhost:21089/task/insertTask?taskStatus=Terminated&factoryId=2&orderId=1&productId=1&num=10
        localhost:21089/task/insertTask?taskStatus=Terminated&factoryId=3&orderId=1&productId=1&num=10&createTime=2010-01-03 10:59:34&predictTime=2010-02-03 10:59:34&completeTime=2010-03-03 10:59:34
        三个时间值，后台程序里，没有考虑逻辑，每个时间都可选择是否空，如果输入，必须按照格式
                                createTime=2010-01-03 10:59:34
    修改Task状态，输入id号和状态字符串，
             localhost:21089/task/updateStatus?taskId=2&taskStatus=AllocatedForProduction
             localhost:21089/task/updateStatus?taskId=3&taskStatus=Terminated
    删除一条记录:   依据id，删除任务。
             localhost:21089/task/delete?taskId=3


2,
3
 */
    }
    //技术笔记
    private static void technologyNotes()
    {
/*
1,遇到的几个大坑：
(a)Mapper.xml中，以下列标签为例
        <insert id="insertTask" parameterType="com.collabor.Entity.HfTask">
   insert into语句要用insert标签，update语句 用 update 标签 , delete 语句 用 delete 标签
   id中不可出现空格。
   里面的SQL语句，先想法子在MySQL执行，检查结果。
(b)实体类的set get 以及构造方法，使用编译器自动生成。
(c)Controller类中，以下列方法为例
         //localhost:21089/task/delete?taskId=3
        @RequestMapping("/task/delete")
        public Boolean deleteTask( Integer taskId ) {
     先不考虑性能和安全性，标注用RequestMapping, 接受get pos; 用了GetMapping或者PostMapping，调试时，容易忘记。
     地址一栏中，一定要注意和方法变量名一致，当参数较多时，这里特别容易出错，可以用注解来解决此问题，但是麻烦。
2，
      Controller类中，public Boolean deleteTask( Integer taskId )
      这些方法中，用Integer这样的对象，而不用int taskId，有很大的好处。
      如果地址栏忘记输入此参数，或者输入麻烦，省略它，就不至于报错了。
3，
程序无法启动，查看出错信息，最容易的错误，比如
Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'hfAdminController': Injection of resource dependencies fail
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'hfAdminController': Injection of resource dependencies failed;
往往是Mapper.xml文件出错。
检查最近修改过的情况，象 insert,update,select,update搞混了，
                    象  (resultType,resultMap) parameterType id名 等特别容易出错的地方。
                    象  有多个参数，确使用类似这种单参数的配置parameterType="int"
4,
5,
 */
    }
}
