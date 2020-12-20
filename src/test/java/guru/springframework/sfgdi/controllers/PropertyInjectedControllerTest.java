package guru.springframework.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgdi.services.ConstructorInjectedGreetingService;

class PropertyInjectedControllerTest {
	
	PropertyInjectedController picontroller;
	
	@BeforeEach
	void setup(){
		picontroller = new PropertyInjectedController();
		picontroller.greetingService = new ConstructorInjectedGreetingService();
	}

	@Test
	void testGetGreeting() {
		System.out.println(picontroller.getGreeting());
	}

}
