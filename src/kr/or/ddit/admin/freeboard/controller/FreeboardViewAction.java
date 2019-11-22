package kr.or.ddit.admin.freeboard.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.admin.freeboard.service.FreeboardServiceImpl;
import kr.or.ddit.admin.freeboard.service.IfreeboardService;
import kr.or.ddit.vo.FreeboardVO;

public class FreeboardViewAction implements IAction {

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
		IfreeboardService service = FreeboardServiceImpl.getInstance();
		
		params.put("bo_no", bo_no);
		
		
		FreeboardVO freeboardInfo = service.freeboardInfo(params);
		 
		 request.setAttribute("freeboardInfo", freeboardInfo); 
		
		return "/admin/freeboard/freeboardView.tiles";
	
	}


}
