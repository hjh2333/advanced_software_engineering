package com.collabor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 此处一个大坑，要使用@MapperScan注入Dao对象。
 */
@MapperScan("com.collabor.dao")
@SpringBootApplication
public class HfCollaborFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(HfCollaborFlowApplication.class, args);
	}

}
