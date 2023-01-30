package com.matheuscassiano.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheuscassiano.course.entities.Product;
import com.matheuscassiano.course.repositories.ProductRepository;
//registra a classe como componente, permitindo que o autowired o injete automaticamente
//@Component
@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	//operação na camada de serviço que repassa a chaamada para o repository.findall
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long Id) {
		Optional<Product> obj = repository.findById(Id);
		//operação get do option retorna um objeto do tipo (nesse caso Product) que estiver dentro do Optional.
		return obj.get();
	}
}
