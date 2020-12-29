package com.collabor.Dao;

import com.collabor.Entity.HfTask;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

//@Mapper
public interface HfTaskDao {
    List<HfTask> findAllTasks(); //查询所有任务。
    HfTask searchTaskById(int taskId);//查询对应id的任务
    int insertTask(HfTask hfTask);//插入一个task
    //用多个参数，一天都没有解决，与MyBatis版本和IDEA版本都有关系。这些软件旧版本有bug .
    //有两个或以上参数时，用@Param更可靠，此时Mapper.xml里不要用parameterType="int"
    int updateTaskStatus(@Param("taskId")int taskId,@Param("taskStatus") String taskStatus);  //依据id，修改status
    /*单个参数时，不用@Param注解，Mapper里的取名可取此处的参数名称，或者数据库字段名称。*/
    int deleteTask(@Param(value="taskId") int taskId); //依据id，删除该任务。
    //给定factoryId，查询所有Task
    List<HfTask> searchTaskByFactoryId(int factoryId);
    //给定factoryId 和 taskStatus，查询所有Task
    List<HfTask> searchTaskByFactoryStatus(int factoryId, String taskStatus);
}
