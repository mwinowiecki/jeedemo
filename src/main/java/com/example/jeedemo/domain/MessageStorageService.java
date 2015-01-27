package com.example.jeedemo.domain;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MessageStorageService {
	@PersistenceContext
	EntityManager em;
	
	public Sandwich get(Long id){
		return em.find(Sandwich.class,id);
	}
	
	public void add (Sandwich message){
		message.setId(null);
		em.persist(message);
	}
	
	public void delete (Long id){
		Sandwich message = em.find(Sandwich.class, id);
		em.remove(message);
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getAllMessages(){
		return em.createNamedQuery("person.all").
				getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Sandwich> getMessages(int offset, int limit){
		return em.createNamedQuery("message.all").
				setFirstResult(offset).
				setMaxResults(limit).
				getResultList();
	}
	
	public Long getCount(){
		return (Long) em.createNamedQuery("select count(m) from Message m").getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Sandwich> getAllByMaker(String maker){
		return em.createNamedQuery("select m from Message m where m.maker = :maker").
				setParameter("maker",maker).getResultList();
	}
	public void update(Long id, String name, float message){
		Sandwich msg = em.find(Sandwich.class, id);
		msg.setName(name);
		msg.setPrice(message);
		
		em.merge(msg);
	}

}
