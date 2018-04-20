package com.xdl.config_client.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xdl.config_client.model.User;

@RestController
public class HelloController {

	@Value("${config}")
	private String config;
	
	@RequestMapping("/hello")
	public String hello(){
		return config+"---hello";
	}
	
	//@RequestMapping("/user")
	@PostMapping("/user")
	public String user(@Valid User user){
		return "测试用户";
	}
}
