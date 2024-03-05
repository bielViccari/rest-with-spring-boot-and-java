package br.com.gabriel;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final String template = "hello %s !";
	
	public Greeting greeting(@RequestParam);
}
