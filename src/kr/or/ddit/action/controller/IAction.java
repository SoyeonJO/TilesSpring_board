package kr.or.ddit.action.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 커맨드 컨트롤러(Servant)
public interface IAction {
	// 프론트 컨트롤러(프론트 앤드 디자인 패턴)가
	// 응답제어(true : 리다이렉트 처리
	//		   false : 포워딩 처리)
	public boolean isRedirect();
	
	// Model 레이어 접근
	// 반환값 : View(JSP, 리다이렉트 또는 포워딩 될 do 확장자 주소)
	public String process(HttpServletRequest request, HttpServletResponse response);
}
