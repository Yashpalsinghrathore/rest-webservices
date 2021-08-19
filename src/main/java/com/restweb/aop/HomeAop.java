package com.restweb.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class HomeAop {

	
	  private long currentTimeMillis;
	  
	  @Before(value =
	  "execution(* com.restweb.controller.ws.HomeController.*(..))||execution(* com.restweb.service.HomeService.*(..))||execution(* com.restweb.dao.HomeDaoImpl.*(..))"
	  ) public void before() { System.out.println("before");
	  
	  currentTimeMillis = System.currentTimeMillis();
	  
	  
	  }
	  
		
		  @After(value =
		  "execution(* com.restweb.controller.ws.HomeController.*(..))||execution(* com.restweb.service.HomeService.*(..))||execution(* com.restweb.dao.HomeDaoImpl.*(..))"
		  ) public void after() { System.out.println("after");
		  
		  long totalTime = System.currentTimeMillis()-currentTimeMillis;
		  
		  System.out.println("Total Time"+totalTime); }
		 

	/*
	 * @Before(value =
	 * "execution(* com.restweb.controller.ws.HomeController.getPerson())") public
	 * void before() {
	 * 
	 * System.out.println("before");
	 * 
	 * }
	 */

}
