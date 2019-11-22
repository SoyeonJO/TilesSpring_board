package kr.or.ddit.admin.mypage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.admin.mypage.service.IAdminMypageService;
import kr.or.ddit.admin.mypage.service.IAdminMypageServiceImpl;
import kr.or.ddit.utiles.RolePagingUtiles;
import kr.or.ddit.vo.MemberVO;

public class MemberStatusAction implements IAction{

	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String currentPage = request.getParameter("currentPage");
		if(currentPage == null) {
			currentPage = "1";
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Map<String, String> params = new HashMap<String, String>();
		
		MemberVO mv = new MemberVO();
		
		String search_keyword = request.getParameter("search_keyword");
		params.put("search_keyword", search_keyword);
		
		IAdminMypageService service = IAdminMypageServiceImpl.getInstance();
		String totalCount = service.totalCountMember(params);
		
		RolePagingUtiles pagingUtiles = new RolePagingUtiles(Integer.parseInt(currentPage), Integer.parseInt(totalCount), request);
		
		params.put("startCount", String.valueOf(pagingUtiles.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtiles.getEndCount()));
		
		List<MemberVO> memberList = service.memberList(params);
		
		request.setAttribute("memberList", memberList);
		request.setAttribute("paginationContent", pagingUtiles.getPagingHTMLS());

		return "/admin/mypage/memberstatus.tiles";
	}

}
