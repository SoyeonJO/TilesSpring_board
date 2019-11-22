package kr.or.ddit.admin.mypage.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.member.service.IMemberService;
import kr.or.ddit.user.member.service.IMemberServiceImpl;
import kr.or.ddit.vo.WithdrawVO;

public class MemberDeleteAction implements IAction{

	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		WithdrawVO member = new WithdrawVO();
		
		try {
			BeanUtils.populate(member, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String mem_id = member.getQuit_mem_id();
		
		IMemberService service = IMemberServiceImpl.getInstance();
		service.memDelinsert(member);
		service.memberDelete(mem_id);
		
		return "/admin/mypage/memberStatus.do";
	}

}
