package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

@Entity
@NamedQueries({
@NamedQuery(name = "sandwich.all", query = "Select s from Sandwich s"),
@NamedQuery(name = "sandwich.unsold", query = "Select s from Sandwich s where s.sold=false")
})

public class Sandwich {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private float price = 0;
	private String type;
	private boolean sold = false;
	private int amount = 0;
	
	private ArrayList<String> ingredients;
	
	private boolean editable = false;
	
	@Temporal(TemporalType.DATE)
	@Past
	private Date dateOfMake = new Date();
	
	@OneToOne(fetch = FetchType.EAGER)
	private Maker maker;
	
	public Long getId() {//
		return id;
	}
	public void setId(Long id) {//
		this.id = id;
	}
	public String getName() {//
		return name;
	}
	public void setName(String name) {//
		this.name = name;
	}
	public Date getDateOfMake() {//
		return dateOfMake;
	}
	public void setDateOfMake(Date dateOfMake) {//
		this.dateOfMake = dateOfMake;
	}
	public float getPrice() {//
		return price;
	}
	public void setPrice(float price) {//
		this.price = price;
	}

	public ArrayList<String> getIngredients() {//
		return ingredients;
	}
	public void setIngredients(ArrayList<String> ingredients) {//
		this.ingredients = ingredients;
	}
	public boolean isSold() {//
		return sold;
	}
	public void setSold(boolean sold) {//
		this.sold = sold;
	}
	public boolean isEditable() {//
		return editable;
	}
	public void setEditable(boolean editable) {//
		this.editable = editable;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
//	@OneToMany(fetch = FetchType.EAGER)
	public Maker getMaker() {//
		return maker;
	}
	public void setMaker(Maker maker) {//
		this.maker = maker;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
