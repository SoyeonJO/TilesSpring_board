package kr.or.ddit.admin.mypage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.admin.mypage.service.IAdminMypageService;
import kr.or.ddit.admin.mypage.service.IAdminMypageServiceImpl;

public class StatisticsAction implements IAction{

	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		IAdminMypageService service = IAdminMypageServiceImpl.getInstance();
		String one = "1";
		int onestar = Integer.parseInt(service.countStar(one));
		request.setAttribute("onestar", onestar);
		
		String two = "2";
		int twostar = Integer.parseInt(service.countStar(two));
		request.setAttribute("twostar", twostar);

		String three = "3";
		int threestar = Integer.parseInt(service.countStar(three));
		request.setAttribute("threestar", threestar);
		
		String four = "4";
		int fourstar = Integer.parseInt(service.countStar(four));
		request.setAttribute("fourstar", fourstar);
		
		String five = "5";
		int fivestar = Integer.parseInt(service.countStar(five));
		request.setAttribute("fivestar", fivestar);
		

		return "/admin/mypage/statistics.tiles";
	}

}
