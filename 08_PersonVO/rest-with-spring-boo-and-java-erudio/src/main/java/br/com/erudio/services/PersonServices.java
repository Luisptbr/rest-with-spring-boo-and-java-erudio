package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundExceprion;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	// Find all retorna uma lista.
	public List<Person> findAll() {

		logger.info("Procurando todos os registros!");

		return repository.findAll();
	}

	// Retorna um dados de um ID.
	public Person findById(Long id) {

		logger.info("Procurando um person!");

		// Implementando mock
//		Person person = new Person();
//		person.setId(counter.incrementAndGet());
//		person.setFirstName("Luis");
//		person.setLastName("Henrique");
//		person.setAddress("Mogi das Cruzes - São Paulo - Brasil");
//		person.setGender("Male");

		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceprion("Não encontramos ninguém com este ID!"));
	}

	public Person create(Person person) {

		logger.info("Criando uma person!");

		return repository.save(person);
	}

	public Person update(Person person) {

		logger.info("Atualizando uma person!");

		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundExceprion("Não encontramos ninguém com este ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repository.save(person);
	}

	// OBS no delete deverá ser void pois não há retorno, não contém o return no
	// final do end point
	// É necessário passar o id que deseja ser deletado.

	public void delete(Long id) {

		logger.info("Deletando uma person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundExceprion("Não encontramos ninguém com este ID!"));
		repository.delete(entity);
	}

//	private Person mockPerson(int i) {
//		
//		Person person = new Person();
//		person.setId(counter.incrementAndGet());
//		person.setFirstName("Person name " + i);
//		person.setLastName("Last name " + i);
//		person.setAddress("Some address in Brasil " + i);
//		person.setGender("Male");
//		return person;
//	}
}
