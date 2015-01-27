package com.example.jeedemo.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtils {

	public static Long getSandwichId(HttpServletRequest request) {
		String pathInfo = request.getPathInfo();
		String SandwichId=pathInfo.substring(pathInfo.lastIndexOf("/")+1, pathInfo.length());
		
		return Long.valueOf(SandwichId);
	}

	@SuppressWarnings("deprecation")
	public static void redirectToMessageView(HttpServletRequest request, HttpServletResponse response, Long sandwichId) throws
	IOException{
		response.sendRedirect(response.encodeRedirectUrl(request.getContextPath()+"/view" + sandwichId));
	}

	@SuppressWarnings("deprecation")
	public static void redirectToMainPage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.sendRedirect(response.encodeRedirectUrl(request.getContextPath()+ "/main"));
	}

}
