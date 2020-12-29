package com.collabor.Controller;

import com.collabor.Dao.HfAdminDao;
import com.collabor.Entity.HfAdmin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HfAdminController {
    @Resource
    HfAdminDao hfAdminDao;

    // 查询所有管理员
    //        localhost:21089/admin/queryAll
    @RequestMapping("/admin/queryAll")
    public List<HfAdmin> queryAdminAll() {
        return hfAdminDao.findAllAdmins();
    }

    @RequestMapping(value="/admin/select", method= RequestMethod.POST)
    List<HfAdmin> selectAdmin(@RequestBody HfAdmin hfAdmin){
        System.out.println(hfAdmin.toString());
        return hfAdminDao.selectAdmin(hfAdmin);
    }

    @RequestMapping(value="/admin/login", method= RequestMethod.POST)
    String logAdmin(@RequestBody HfAdmin hfAdmin){
        System.out.println(hfAdmin.toString());
        if(hfAdmin.getAdmin_name()==null)
            return "账号名为空，请输入账号名";
        if(hfAdmin.getAdmin_password()==null)
            return "账号密码为空，请输入账号密码";
        List<HfAdmin> temp=hfAdminDao.selectAdmin(hfAdmin);
        if(temp.isEmpty())
            return "账号密码不匹配";
        return String.valueOf(temp.get(0).getAdmin_id())+" 登录成功，该数为admin_id";
    }
}
