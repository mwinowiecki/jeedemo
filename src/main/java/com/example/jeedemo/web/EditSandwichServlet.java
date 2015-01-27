package com.example.jeedemo.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jeedemo.service.SandwichManager;

@WebServlet(urlPatterns="/edit/*")
public class EditSandwichServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Inject
private SandwichManager storage;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException{
	Long sandwichId = WebUtils.getSandwichId(request);
	request.setAttribute("sandwich",storage.get(sandwichId));
	request.getRequestDispatcher("/edit.jsp").forward(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
	String name = request.getParameter("name");
	float price = Float.parseFloat(request.getParameter("price"));
	Long sandwichId = WebUtils.getSandwichId(request);
	
	//storage.updateSandwich(sandwichId);
	WebUtils.redirectToMessageView(request,response,sandwichId);
}
}
