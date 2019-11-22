package kr.or.ddit.admin.mypage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.member.service.IMemberService;
import kr.or.ddit.user.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberInfoAction implements IAction{

	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String mem_id = request.getParameter("mem_id");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", mem_id);
		
		MemberVO member = new MemberVO();
		
		IMemberService service = IMemberServiceImpl.getInstance();
		member = service.memberInfo(params);
		
		request.setAttribute("memberInfo", member);
		
		return "/admin/mypage/memberDetail.tiles";
	}

}
