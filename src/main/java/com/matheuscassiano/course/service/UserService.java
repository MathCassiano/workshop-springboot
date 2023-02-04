package com.matheuscassiano.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheuscassiano.course.entities.User;
import com.matheuscassiano.course.repositories.UserRepository;
//registra a classe como componente, permitindo que o autowired o injete automaticamente
//@Component
@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	//operação na camada de serviço que repassa a chaamada para o repository.findall
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long Id) {
		Optional<User> obj = repository.findById(Id);
		//operação get do option retorna um objeto do tipo (nesse caso User) que estiver dentro do Optional.
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
