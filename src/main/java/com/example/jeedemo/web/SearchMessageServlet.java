package com.example.jeedemo.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.jeedemo.domain.MessageStorageService;

@WebServlet(urlPatterns="/search")
public class SearchMessageServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@EJB
private MessageStorageService storage;

@SuppressWarnings("deprecation")
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException{
	String type = request.getParameter("type");
	if(type == null){
		response.sendRedirect(response.encodeRedirectUrl(request.getContextPath()+"/main"));
		return;
	}
	
	request.setAttribute("type", type);
	
	if(type.equals("maker")){
		String maker = request.getParameter("maker");
		request.setAttribute("messages",storage.getAllByMaker(maker));
		request.setAttribute("headertext", "Sandwiches by " + maker);
		request.setAttribute("maker",maker);
	}
	request.getRequestDispatcher("search.jsp").forward(request,response);
}
}
