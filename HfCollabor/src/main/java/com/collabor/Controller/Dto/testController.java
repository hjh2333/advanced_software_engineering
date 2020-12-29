package com.collabor.Controller.Dto;

import com.collabor.Dao.Dto.test;
import com.collabor.Entity.Dto.testDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class testController {
    @Resource
    test testA;

    @RequestMapping("/test/test")
    public List<testDTO> testFun(){
        return testA.testFun();
    }
}
