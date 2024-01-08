package br.com.erudio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	///private PersonServices service = new PersonServices();
	//@PathVariable é utilizada para recuperar dados da URL
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(value = "/{id}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") Long id) {
		return service.findById(id);
	}	
	//Metodo POST utilizado para POSTAR, CRIAR OU ATUALIZAR.
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)			
	public Person create(@RequestBody Person person){
		return service.create(person);
	}
	//Método PUT utilizado para COLOCAR dados ou ATUALIZAR.
	
	@RequestMapping(method=RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public Person update (@RequestBody Person person) {
		return service.update(person);
	}
	
	// Não esquecer de colocar o caminho da requisição URL 
	@RequestMapping(value = "/{id}", // caminho URL
			method=RequestMethod.DELETE)
	public void delete (@PathVariable(value = "id") Long id) {
		service.delete(id); // por ser void não há o return.
	}


}