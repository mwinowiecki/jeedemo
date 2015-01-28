package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Sandwich;


/* 
 * This is a Stateless EJB Bean
 * All its methods are transactional
 */
@Stateless
public class SellingManager {

	@PersistenceContext
	EntityManager em;

	public void sellSandwich(Long personId, Long sandwichId) {

		int amountLeft;
		Person person = em.find(Person.class, personId);
		Sandwich sandwich = em.find(Sandwich.class, sandwichId);
		//sandwich.setSold(true);

		amountLeft=sandwich.getAmount();
		
		sandwich.setAmount(amountLeft-5);
		em.merge(sandwich);
		person.getSandwiches().add(sandwich);
	}

	@SuppressWarnings("unchecked")
	public List<Sandwich> getAvailableSandwiches() {
		return em.createNamedQuery("sandwich.unsold").getResultList();
	}

	public void disposeSandwich(Person person, Sandwich sandwich, int amount) {

		person = em.find(Person.class, person.getId());
		sandwich = em.find(Sandwich.class, sandwich.getId());

		Sandwich toRemove = null;
		// lazy loading here 
		for (Sandwich aSandwich : person.getSandwiches())
			if (aSandwich.getId().compareTo(sandwich.getId()) == 0 
				&& (aSandwich.getAmount()>=amount)) {
				
				aSandwich.setAmount(aSandwich.getAmount()-amount);
				if(aSandwich.getAmount()==0)
					toRemove = aSandwich;
				//person.setSandwiches(aSandwich);//tu jakos dodac nazwe kanapki do Person
				break;
			}

		if (toRemove != null)
			person.getSandwiches().remove(toRemove);
		
		sandwich.setSold(false);
	}
}
