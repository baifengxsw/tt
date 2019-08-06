package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo1Controller {

	@RequestMapping("/hello")
	
	public String quick() {
		
		return "hello springboot";
	}
}
