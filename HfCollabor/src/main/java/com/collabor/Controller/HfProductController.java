package com.collabor.Controller;

import com.collabor.Dao.HfProductDao;
import com.collabor.Entity.HfProduct;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HfProductController {
    @Resource
    HfProductDao hfProductdao;

    @RequestMapping("/product/queryAll")
    public List<HfProduct> queryProductAll() {
        return hfProductdao.findAllProduct();
    }

    @RequestMapping(value="/product/select", method= RequestMethod.POST)
    List<HfProduct> selectProduct(@RequestBody HfProduct hfProduct){
        System.out.println(hfProduct.toString());
        return hfProductdao.selectProduct(hfProduct);
    }

    @RequestMapping(value="/product/insert", method= RequestMethod.POST)
    public int insertProduct(@RequestBody HfProduct hfProduct){
        int temp=hfProductdao.insertProduct(hfProduct);//想返回主键，但xml的useGeneratedKeys没起作用
        if(temp<=0)
            System.out.println("插入失败");
        else{
            System.out.println("插入记录:"+hfProduct.toString());
        }
        return temp;
    }

    @RequestMapping(value="/product/update", method= RequestMethod.POST)
    public int updateProduct(@RequestBody HfProduct hfProduct){
        int temp=hfProductdao.updateProduct(hfProduct);
        if(temp<=0)
            System.out.println("更新失败");
        else{
            System.out.println("更新记录:"+hfProduct.toString());
        }
        return temp;
    }
}
