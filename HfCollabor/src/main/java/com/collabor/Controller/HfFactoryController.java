package com.collabor.Controller;

import com.collabor.Dao.HfFactoryDao;
import com.collabor.Entity.HfAdmin;
import com.collabor.Entity.HfFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HfFactoryController {
    @Resource
    HfFactoryDao hfFactoryDao;

    @RequestMapping("/factory/queryAll")
    public List<HfFactory> queryAdminAll() {
        return hfFactoryDao.findAllFactory();
    }

    ///factory/login?factoryName=北京公司&factoryPassword=aaaa
    @RequestMapping("/factory/login")
    public List<HfFactory> login(String factoryName,String factoryPassword){
        List<HfFactory> temp =hfFactoryDao.login(factoryName,factoryPassword);
        if(temp!=null)
            System.out.println(temp.toString());
        else
            System.out.println("无匹配的登录账号");
        return temp;
    }

    @RequestMapping("/factory/id")
    public int findid(){
        List<HfFactory> temp=login("北京公司","aaaa");
        int ans=temp.get(0).getFactory_id();
        System.out.println(ans);
        return ans;
    }
}
