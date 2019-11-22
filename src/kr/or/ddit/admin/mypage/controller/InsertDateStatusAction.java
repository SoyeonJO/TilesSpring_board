package kr.or.ddit.admin.mypage.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.admin.mypage.service.IAdminMypageService;
import kr.or.ddit.admin.mypage.service.IAdminMypageServiceImpl;

public class InsertDateStatusAction implements IAction{

	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		String search_keyword = request.getParameter("search_keyword");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("search_keyword", search_keyword);
		
		IAdminMypageService service = IAdminMypageServiceImpl.getInstance();
		
		for(int i = 1; i <= 12; i++ ) {
			if(i < 10) {
				String date = String.valueOf(i);
				String lessdate = "0" + date;
				date = service.countInsertDate(lessdate);
				request.setAttribute("date" + i , date);
			}else {
				String date = String.valueOf(i);
				date = service.countInsertDate(date);
				request.setAttribute("date" + i, date);
			}
		}
		
		
		
		return "/admin/mypage/insertDateStatus.tiles";
	}

}
