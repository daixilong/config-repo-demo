package com.xdl.config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${config}")
	private String config;
	
	@RequestMapping("/hello")
	public String hello(){
		return config+"---hello";
	}
}
