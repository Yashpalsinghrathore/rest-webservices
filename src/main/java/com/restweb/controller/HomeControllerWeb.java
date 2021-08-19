package com.restweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControllerWeb {

	
	
	@RequestMapping("/showpage")
	public String showPage()
	{
		
		System.out.println("show page controller");
		
		return "hello";
		
	}
	
}
