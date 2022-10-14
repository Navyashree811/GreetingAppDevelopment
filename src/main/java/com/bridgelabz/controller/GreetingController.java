package com.bridgelabz.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.dto.User;
import com.bridgelabz.services.IGreetingService;

@RestController
@RequestMapping("student")
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	/*
	 * curl localhost:8080/greeting
	 * 
	 * @return={id =1 , content="hello world!}
	 * curllocalhost:8080/greeting?name=Navya
	 * 
	 * @return= { id=2, content="hello Navya!
	 */
	@GetMapping(value = { "/greeting", "/greeting/", "/greeting/home" })
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	/*
	 * curl localhost:8080/greeting/Navya
	 * 
	 * @return={id =1 , content="hello Navya!}
	 */
	@GetMapping("greeting/{name}")
	public Greeting greetings(@PathVariable String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@Autowired
	private IGreetingService greetingService;

	/*
	 * curl localhost:8080/greeting/service
	 * 
	 * @return={id =1 , content="hello world!}
	 */
	@GetMapping("greeting/service")
	public Greeting greeting() {
		return greetingService.greetingMessage();

	}

	@PostMapping("/insert")
	public User greetingMessage(@RequestBody User user) {
		User control = greetingService.greetingMessageByName(user);
		return control;
	}

	@GetMapping("/find")
	public User findGreetById(@RequestParam long id) {
		return greetingService.getById(id);
	}

}