package com.matheuscassiano.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheuscassiano.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	

}
