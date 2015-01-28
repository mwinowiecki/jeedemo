package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Maker;
import com.example.jeedemo.domain.Sandwich;
import com.example.jeedemo.service.MakerAssigningManager;
import com.example.jeedemo.service.MakerManager;
import com.example.jeedemo.service.SandwichManager;

@SessionScoped
@Named("assignMakerBean")
public class MakerAssignFormBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private MakerAssigningManager makeasman;
	
	@Inject
	private MakerManager makeman;
	
	@Inject
	private SandwichManager sandman;
	
	private Long sandwichId;
	private Long makerId;
	
	public Long getSandwichId() {
		return sandwichId;
	}
	public void setSandwichId(Long sandwichId) {
		this.sandwichId = sandwichId;
	}
	public Long getMakerId() {
		return makerId;
	}
	public void setMakerId(Long makerId) {
		this.makerId = makerId;
	}
	
	public List<Maker> getMakers(){
		return makeman.getMakers();
	}
	
	public List<Sandwich> getAllSandwiches(){
		return sandman.getAllSandwiches();
	}
	
	public String assignSandwich(){
		makeasman.assignSandwich(sandwichId,makerId);
		return "showSandwiches";
	}
	
	public List<Maker> getAllMakers(){
		return makeasman.getAllMakers();
	}

}
