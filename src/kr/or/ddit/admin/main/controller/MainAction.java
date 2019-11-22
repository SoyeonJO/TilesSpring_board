package kr.or.ddit.admin.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;

public class MainAction implements IAction {
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}
	
	// 반환값 View(/WEB-INF/경로/특정 JSP)
	//		 do확장자를 활용한 리다이렉트, 포워딩 처리
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		return "/admin/news/newsList.do";
	}

}
