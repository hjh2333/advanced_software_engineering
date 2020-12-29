package com.collabor.Tools;

/*
用于执行数据库的各项校验
 */
public class HfDbCheck {
    /*检查status是否可以作为 task表status的合法值。
    待分配，ToBeAssigned     已分配待生产，AllocatedForProduction
    生产中，InProduction     已完成，Completed        已终止,Terminated*/
    public static boolean isValidTaskStatus(String status)
    {
        String[] taskStatus = { "ToBeAssigned","AllocatedForProduction","InProduction","Completed","Terminated"};
        boolean found = false;
        for( int i=0;i<taskStatus.length;i++ )
        {
            if( taskStatus[i].equals(status) )
            {
                found = true;
                break;
            }
        }
        return found;
    }

    /*统一制定日期的格式，LocalDateTime*/
    public static String getDateTimeFormat()
    {
        return "yyyy-MM-dd HH:mm:ss";
    }
}
