package com.bridgelabz.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final String template = "Hello. %s!";
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

}