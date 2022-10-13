package com.bridgelabz.services;

import com.bridgelabz.controller.Greeting;
import com.bridgelabz.dto.User;

public interface IGreetingService {
	Greeting greetingMessage();

	User greetingMessageByName(User user);
	

}
