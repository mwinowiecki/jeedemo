package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Maker;

@Stateless
public class MakerManager {
	@PersistenceContext
	EntityManager em;
	
	public void addMaker(Maker maker){
		maker.setId(null);		
		em.persist(maker);
	}
	
	@SuppressWarnings("unchecked")
	public List<Maker> getMakers(){
		return em.createNamedQuery("maker.all").getResultList();
	}

}
