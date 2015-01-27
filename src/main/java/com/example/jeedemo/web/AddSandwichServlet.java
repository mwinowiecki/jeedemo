package com.example.jeedemo.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jeedemo.domain.Sandwich;
import com.example.jeedemo.service.SandwichManager;

@WebServlet(urlPatterns = "/add")
public class AddSandwichServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private SandwichManager storage;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException{
		String name = request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("cena"));
		
		Sandwich newSandwich = new Sandwich();
		newSandwich.setName(name);
		newSandwich.setPrice(price);
		storage.addSandwich(newSandwich);
		response.sendRedirect(response.encodeRedirectUrl(request.getContextPath()+"/main"));
	}

}
