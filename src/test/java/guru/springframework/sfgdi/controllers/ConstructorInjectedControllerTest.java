package guru.springframework.sfgdi.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgdi.services.ConstructorInjectedGreetingService;

class ConstructorInjectedControllerTest {
	
	ConstructorInjectedController controller;

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		controller = new ConstructorInjectedController(new ConstructorInjectedGreetingService());
	}

	@Test
	void testGetGreeting() {
		System.out.println(controller.getGreeting());
	}

}
