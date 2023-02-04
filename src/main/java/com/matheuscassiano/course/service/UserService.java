package com.matheuscassiano.course.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.matheuscassiano.course.entities.User;
import com.matheuscassiano.course.repositories.UserRepository;
import com.matheuscassiano.course.service.exceptions.DatabaseException;
import com.matheuscassiano.course.service.exceptions.ResourceNotFoundException;
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
		return obj.orElseThrow(() -> new ResourceNotFoundException(Id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	public User update(Long id, User obj) {
		try {
		//prepara o objeto monitorado para mexer e depois efetuar uma operação com o bd
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		}catch(RuntimeException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
