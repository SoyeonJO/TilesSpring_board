package kr.or.ddit.admin.freeboard.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.admin.freeboard.service.FreeboardServiceImpl;
import kr.or.ddit.admin.freeboard.service.IfreeboardService;

public class DeleteFormAction implements IAction {
	private boolean redirectFlag = false;
	
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
		
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		String bo_no = request.getParameter("bo_no");

		Map<String, String> params = new HashMap<String, String>();
		params.put("bo_no", bo_no);
		
		IfreeboardService service = FreeboardServiceImpl.getInstance();
		service.deleteInfo(params);
		
		return "/admin/freeboard/freeboardList.do";
	}

}
