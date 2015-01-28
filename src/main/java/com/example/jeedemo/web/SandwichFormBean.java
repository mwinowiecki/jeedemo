package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Maker;
import com.example.jeedemo.domain.Sandwich;
import com.example.jeedemo.service.MakerManager;
import com.example.jeedemo.service.SandwichManager;
import com.example.jeedemo.service.SellingManager;

@SessionScoped
@Named("sandwichBean")
public class SandwichFormBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sandwich sandwich = new Sandwich();
	private Maker maker = new Maker();
	private ListDataModel<Sandwich> sandwiches = new ListDataModel<Sandwich>();
	private Sandwich sandwichToShow = new Sandwich();
	private ListDataModel<Sandwich> boughtSandwiches = new ListDataModel<Sandwich>();
	private long sandwichId;
	private long makerId;
	private long boughtById;
	private int amount;
	
	@Inject
	private SandwichManager sandmen;
	
	@Inject
	private SellingManager sellmen;
	
	@Inject 
	private MakerManager makemen;
	
	public Sandwich getSandwich() {
		return sandwich;
	}
	public void setSandwich(Sandwich sandwich) {
		this.sandwich = sandwich;
	}
	public Maker getMaker() {
		return maker;
	}
	public void setMaker(Maker maker) {
		this.maker = maker;
	}
	public ListDataModel<Sandwich> getSandwiches() {
		return sandwiches;
	}
	public void setSandwiches(ListDataModel<Sandwich> sandwiches) {
		this.sandwiches = sandwiches;
	}
	public Sandwich getSandwichToShow() {
		return sandwichToShow;
	}
	public void setSandwichToShow(Sandwich sandwichToShow) {
		this.sandwichToShow = sandwichToShow;
	}
	public ListDataModel<Sandwich> getOwnedSandwiches() {
		return boughtSandwiches;
	}
	public void setOwnedSandwiches(ListDataModel<Sandwich> ownedSandwiches) {
		this.boughtSandwiches = ownedSandwiches;
	}
	public long getSandwichId() {
		return sandwichId;
	}
	public void setSandwichId(long sandwichId) {
		this.sandwichId = sandwichId;
	}
	public long getMakerId() {
		return makerId;
	}
	public void setMakerId(long makerId) {
		this.makerId = makerId;
	}
	public long getBoughtById() {
		return boughtById;
	}
	public void setBoughtById(long boughtById) {
		this.boughtById = boughtById;
	}
	
	public ListDataModel<Sandwich> getAllSandwiches(){
		sandwiches.setWrappedData(sandmen.getAllSandwiches());
		return sandwiches;
	}
	
	public String addSandwich(){
		sandmen.addSandwich(sandwich);
		return "assignMaker";
	}
	
	public String sellSandwich(){
		sandmen.setAmountSandwich(sandwich);
		
		return "showSandwiches";
	}
	
	public String deleteSandwich(){
		Sandwich sandwichToDelete = sandwiches.getRowData();
		sandmen.deleteSandwich(sandwichToDelete);
		return null;
	}
	
	public String showDetails(){
		sandwichToShow = sandwiches.getRowData();
		return "details";
	}
	
//	public String saveAction(){
//		Sandwich sandwichToUpdate = sandwiches.getRowData();
//		sandmen.updateSandwich(sandwichToUpdate);
//		for(Sandwich sandwich : sandwiches){
//			sandwich.setEditable(false);
//		}
//		return null;
//	}
	
	public String editAction(){
		Sandwich toEdit = sandwiches.getRowData();
		toEdit.setEditable(true);
		return null;
	}
	
	public List<Maker> getAllMakers(){
		return makemen.getMakers();
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	

}
