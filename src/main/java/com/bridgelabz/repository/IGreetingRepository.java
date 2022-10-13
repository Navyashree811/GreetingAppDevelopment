package com.bridgelabz.repository;

import org.springframework.stereotype.Repository;

import com.bridgelabz.dto.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IGreetingRepository extends JpaRepository<User, Long> {

}
