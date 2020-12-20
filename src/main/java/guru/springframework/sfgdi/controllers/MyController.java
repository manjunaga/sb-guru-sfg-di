package guru.springframework.sfgdi.controllers;

import org.springframework.stereotype.Controller;

import guru.springframework.sfgdi.services.GreetingService;

@Controller
public class MyController {
	
//	public String sayHello() {
//		System.out.println("Hello World");
//		return "Hi Folks!!!";
//	}
	
	private final GreetingService greetingService;

	public MyController(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}
	

}
