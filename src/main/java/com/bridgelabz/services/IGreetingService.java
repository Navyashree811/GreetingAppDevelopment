package com.bridgelabz.services;

import com.bridgelabz.controller.Greeting;
import com.bridgelabz.dto.UserDto;

public interface IGreetingService {
	Greeting greetingMessage();

	String greetingMessageByName(UserDto userDto);

}
