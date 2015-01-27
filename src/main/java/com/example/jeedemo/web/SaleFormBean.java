package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Sandwich;
import com.example.jeedemo.service.PersonManager;
import com.example.jeedemo.service.SellingManager;

@SessionScoped
@Named("saleBean")
public class SaleFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SellingManager sm;

	@Inject
	private PersonManager pm;

	private Long sandwichId;
	private Long personId;
	
	public Long getSandwichId() {
		return sandwichId;
	}
	public void setSandwichId(Long sandwichId) {
		this.sandwichId = sandwichId;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public List<Sandwich> getAvailableSandwiches() {
		return sm.getAvailableSandwiches();
	}

	public List<Person> getAllPersons() {
		return pm.getAllPersons();
	}

	public String sellSandwich() {
		sm.sellSandwich(personId, sandwichId);
		return null;
	}
}
