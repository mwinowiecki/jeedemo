package com.example.jeedemo.web;

import java.awt.image.RescaleOp;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jeedemo.service.SandwichManager;

@WebServlet(urlPatterns="/remove/*")
public class RemoveSandwichServlet extends HttpServlet{
	@Inject
	private SandwichManager storage;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException{
		Long sandwichId = WebUtils.getSandwichId(request);
		//storage.deleteSandwich(sandwichId);
		WebUtils.redirectToMainPage(request, response);
	}

}
