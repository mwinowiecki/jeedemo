package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Sandwich;

@Stateless
public class PersonManager {

	@PersistenceContext
	EntityManager em;

	public void addPerson(Person person) {
		person.setId(null);
		em.persist(person);
	}

	public void deletePerson(Person person) {
		person = em.find(Person.class, person.getId());
		em.remove(person);
	}

	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		return em.createNamedQuery("person.all").getResultList();
	}

	public List<Sandwich> getBoughtSandwiches(Person person) {
		person = em.find(Person.class, person.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Sandwich> sandwiches = new ArrayList<Sandwich>(person.getSandwiches());
		return sandwiches;
	}

}
