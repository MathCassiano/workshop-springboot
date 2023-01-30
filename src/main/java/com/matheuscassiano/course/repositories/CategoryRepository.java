package com.matheuscassiano.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheuscassiano.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	

}
