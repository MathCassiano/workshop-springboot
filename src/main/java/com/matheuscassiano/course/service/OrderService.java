package com.matheuscassiano.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheuscassiano.course.entities.Order;
import com.matheuscassiano.course.repositories.OrderRepository;
//registra a classe como componente, permitindo que o autowired o injete automaticamente
//@Component
@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	//operação na camada de serviço que repassa a chaamada para o repository.findall
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long Id) {
		Optional<Order> obj = repository.findById(Id);
		//operação get do option retorna um objeto do tipo (nesse caso Order) que estiver dentro do Optional.
		return obj.get();
	}
}
