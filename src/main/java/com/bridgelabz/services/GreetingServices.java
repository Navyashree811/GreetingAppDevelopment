package com.bridgelabz.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.controller.Greeting;
import com.bridgelabz.dto.User;
import com.bridgelabz.repository.IGreetingRepository;

@Service
public class GreetingServices implements IGreetingService {
	private static final String template = "Hello world";
	private final AtomicLong counter = new AtomicLong();

	@Override
	public Greeting greetingMessage() {
		return new Greeting(counter.incrementAndGet(), String.format(template));
	}

	@Autowired
	IGreetingRepository repository;

	@Override
	public User greetingMessageByName(User user) {
		User response = repository.save(user);
		return response;
	}

	@Override
	public User getById(long id) {
		Optional<User> greetById = repository.findById(id);
		return greetById.orElse(null);
	}

	@Override
	public List<User> getAllGreetingMessages() {
		return repository.findAll();
	}
}
