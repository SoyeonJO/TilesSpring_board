package kr.or.ddit.user.main.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.utiles.CryptoGenerator;

public class MainAction implements IAction {
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}
	
	// 반환값 View(/WEB-INF/경로/특정 JSP)
	//		 do확장자를 활용한 리다이렉트, 포워딩 처리
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		
		return "/user/news/newsList.do";
	}

}
