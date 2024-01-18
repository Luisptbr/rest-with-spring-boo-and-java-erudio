package br.com.erudio.mapper.custom;


import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.model.Person;

@Service
public class PersonMapper {
	
	public PersonVOV2 convertEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setAddress(person.getAddress());
		vo.setBirthDay(new Date());
		vo.setGender(person.getGender());
		return vo;
	}
	public Person convertVoTOEntity(PersonVOV2 person) {
		Person Entity = new Person();
		Entity.setId(person.getId());
		Entity.setFirstName(person.getFirstName());
		Entity.setLastName(person.getLastName());
		Entity.setAddress(person.getAddress());
//		Entity.setBirthDay(new Date());
		Entity.setGender(person.getGender());
		return Entity;
	}
}
