package kr.or.ddit.user.login.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.listener.SessionManager;
import kr.or.ddit.user.member.service.IMemberService;
import kr.or.ddit.user.member.service.IMemberServiceImpl;
import kr.or.ddit.utiles.CryptoGenerator;
import kr.or.ddit.vo.MemberVO;

public class LoginCheckAction implements IAction {

	private boolean redirectFlag = true;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		
		HttpSession session = request.getSession();		
		
		String memid = CryptoGenerator.decryptRSA(session, mem_id);
		String mempass = CryptoGenerator.decryptRSA(session, mem_pass);
		
		SessionManager.getInstance().loginDuplicationCheck(session.getId(), memid);
		
		
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", memid);
		params.put("mem_pass", mempass);
		
		IMemberService service = IMemberServiceImpl.getInstance();
		MemberVO memberInfo = service.memberInfo(params);
		
		String message = "";
		if(memberInfo == null) {
			try {
				message = URLEncoder.encode("회원이 아닙니다", "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			request.setAttribute("list", message);
			
		}else {
			if(memberInfo.getMem_name().equals("관리자")) {
				session.setAttribute("LOGIN_ADMININFO", memberInfo);
				return "/admin/main/mainTemplate.do";
			}else {
				session.setAttribute("LOGIN_MEMBERINFO", memberInfo);
			}
			
		}
		return "/user/main/mainTemplate.do";
			
	}

}
