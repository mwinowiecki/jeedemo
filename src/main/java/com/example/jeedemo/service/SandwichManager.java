package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Maker;
import com.example.jeedemo.domain.Sandwich;

@Stateless
public class SandwichManager {
@PersistenceContext
EntityManager em;

public Sandwich get(Long id){
	return em.find(Sandwich.class, id);
}

public void addSandwich(Sandwich sandwich){
	sandwich.setId(null);
	em.persist(sandwich);
}

public void deleteSandwich(Sandwich sandwich){
	sandwich=em.find(Sandwich.class,sandwich.getId());
	em.remove(sandwich);
}

public void setAmountSandwich(Sandwich sandwich){
	int amountLeft;
	
	amountLeft=sandwich.getAmount();
	
	em.merge(sandwich);
}

//public void updateSandwich(Sandwich sandwich){
//	sandwich = em.find(Sandwich.class,sandwich.getId());
//	sandwich.setName(sandwich.getName());
//	sandwich.setPrice(sandwich.getPrice());
//	sandwich.setDateOfMake(sandwich.getDateOfMake());
//	sandwich.setIngredients(sandwich.getIngredients());
//	sandwich.setMaker(sandwich.getMaker());
//	em.merge(sandwich);
//}

@SuppressWarnings("unchecked")
public List<Sandwich> getAllSandwiches(){
	return em.createNamedQuery("sandwich.all").getResultList();
}

public void assignSandwichToMaker(Long sandwichId, Long makerId){
	Maker maker = em.find(Maker.class,makerId);
	Sandwich sandwich = em.find(Sandwich.class,sandwichId);
	sandwich.setMaker(maker);
	em.merge(sandwich);
}
}
