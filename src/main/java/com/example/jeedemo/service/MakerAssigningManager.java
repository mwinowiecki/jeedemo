package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Maker;
import com.example.jeedemo.domain.Sandwich;

@Stateless
public class MakerAssigningManager {
@PersistenceContext
EntityManager em;

public void assignSandwich(Long sandwichId, Long makerId){
	Maker maker = em.find(Maker.class,makerId);
	Sandwich sandwich = em.find(Sandwich.class, sandwichId);
	sandwich.setMaker(maker);	
}
@SuppressWarnings("unchecked")
public List<Sandwich> getAvailableSandwiches(){
	return em.createNamedQuery("sandwich.unsold").getResultList();
}
}
