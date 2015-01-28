package com.example.jeedemo.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jeedemo.service.SandwichManager;

@WebServlet(urlPatterns="/view/*")
public class ViewSandwichServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Inject
private SandwichManager storage;

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
	Long sandwichId = WebUtils.getSandwichId(request);
	
	request.setAttribute("message",storage.get(sandwichId));
	request.getRequestDispatcher("/view.jsp").forward(request, response);
}
}
