package kr.or.ddit.base.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.base.uri.adapter.URIHandlerAdpter;

public class WebController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
		String requestURI = request.getServletPath();
		
		IAction action = URIHandlerAdpter.getAction(requestURI);
		
		if(action != null) {
			String viewName = action.process(request, response);
			
			if(viewName != null) {
				if(action.isRedirect()) {
					response.sendRedirect(request.getContextPath() + viewName);
				}else {
					RequestDispatcher dis = request.getRequestDispatcher(viewName);
					dis.forward(request, response);
				}
			}
		}else {
			// 404 처리
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	
	}
	
	
}
