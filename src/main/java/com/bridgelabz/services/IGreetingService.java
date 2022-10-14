package com.bridgelabz.services;

import java.util.List;

import com.bridgelabz.controller.Greeting;
import com.bridgelabz.dto.User;

public interface IGreetingService {
	Greeting greetingMessage();

	User greetingMessageByName(User user);

	User getById(long id);

	List<User> getAllGreetingMessages();

}
