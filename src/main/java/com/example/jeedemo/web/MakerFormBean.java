package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Maker;
import com.example.jeedemo.service.MakerManager;

@SessionScoped
@Named("makerBean")
public class MakerFormBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Maker maker = new Maker();
	private ListDataModel<Maker> makers = new ListDataModel<Maker>();
	
	@Inject
	private MakerManager makemen;
	
	private Long makerId;
	
	public String addMaker(){
		makemen.addMaker(getMaker());
		return "showSandwiches";
	}

	public Maker getMaker() {
		return maker;
	}

	public void setMaker(Maker maker) {
		this.maker = maker;
	}

	public ListDataModel<Maker> getMakers() {
		return makers;
	}

	public void setMakers(ListDataModel<Maker> makers) {
		this.makers = makers;
	}

	public Long getMakerId() {
		return makerId;
	}

	public void setMakerId(Long makerId) {
		this.makerId = makerId;
	}
	

}
