package com.matheuscassiano.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheuscassiano.course.entities.Category;
import com.matheuscassiano.course.repositories.CategoryRepository;
//registra a classe como componente, permitindo que o autowired o injete automaticamente
//@Component
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	//operação na camada de serviço que repassa a chaamada para o repository.findall
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long Id) {
		Optional<Category> obj = repository.findById(Id);
		//operação get do option retorna um objeto do tipo (nesse caso Category) que estiver dentro do Optional.
		return obj.get();
	}
}
