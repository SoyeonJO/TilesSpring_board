package kr.or.ddit.user.freeboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.freeboard.service.FreeboardServiceImpl;
import kr.or.ddit.user.freeboard.service.IfreeboardService;
import kr.or.ddit.vo.FreeboardVO;

public class FreeboardReplyFormAction implements IAction {
	private boolean redirectFlag = false;
	@Override
	public boolean isRedirect() {
		
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String bo_no = request.getParameter("bo_no"); // rnum은 글이 삭제되면 바뀌니까 bo_no기준으로 

		Map<String, String> params = new HashMap<String, String>();
		IfreeboardService service = FreeboardServiceImpl.getInstance();
		
		params.put("bo_no", bo_no);
		
		
		FreeboardVO freeboardInfo = service.freeboardInfo(params);
		 
		 request.setAttribute("freeboardInfo", freeboardInfo); 
		
		
		return "/user/freeboard/freeboardReplyBoardForm.tiles";
	}

}
