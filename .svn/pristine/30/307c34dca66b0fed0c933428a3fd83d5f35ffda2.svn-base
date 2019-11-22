package kr.or.ddit.user.mypage.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.member.service.IMemberService;
import kr.or.ddit.user.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class PassCheckAction implements IAction{
	
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String pass = request.getParameter("mem_pass");
		String id = request.getParameter("mem_id");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", id);
		params.put("mem_pass", pass);
		
		IMemberService service = IMemberServiceImpl.getInstance();
		MemberVO memberinfo = service.memberInfo(params);
		
		if(memberinfo == null) {
			return "/user/mypage/mypagePassCheck.tiles";
		}else {
			request.setAttribute("memberInfo", memberinfo);
			return "/user/mypage/mypageInfoCheck.tiles";
		}
		
		
	}

}
