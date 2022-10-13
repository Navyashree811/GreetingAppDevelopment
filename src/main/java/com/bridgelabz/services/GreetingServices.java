package com.bridgelabz.services;

import java.util.concurrent.atomic.AtomicLong;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bridgelabz.controller.Greeting;
import com.bridgelabz.dto.User;
import com.bridgelabz.dto.UserDto;

@Service
public class GreetingServices implements IGreetingService {
	private static final String template = "Hello world";
	private final AtomicLong counter = new AtomicLong();

	@Override
	public Greeting greetingMessage() {
		return new Greeting(counter.incrementAndGet(), String.format(template));
	}

	@Override
	public String greetingMessageByName(UserDto userDto) {
		User user = new User();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(userDto, user);
		return ("Hello " + user.getFirstName() + " " + user.getLastName());
	}

}
