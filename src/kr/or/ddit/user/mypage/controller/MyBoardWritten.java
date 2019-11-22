package kr.or.ddit.user.mypage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.mypage.service.IMemMypageService;
import kr.or.ddit.user.mypage.service.IMemMypageServiceImpl;
import kr.or.ddit.utiles.RolePagingUtiles;
import kr.or.ddit.vo.AllBoardVO;
import kr.or.ddit.vo.MemberVO;

public class MyBoardWritten implements IAction{

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
		
		HttpSession session = request.getSession();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Map<String, String> params = new HashMap<String, String>();

		MemberVO mv = new MemberVO();
		mv = (MemberVO) session.getAttribute("LOGIN_MEMBERINFO");
		
		String mem_id = mv.getMem_id();
		params.put("mem_id", mem_id);

		String search_keyword = request.getParameter("search_keyword");
		params.put("search_keyword", search_keyword);
		
		IMemMypageService service = IMemMypageServiceImpl.getInstance();
		String totalCount = service.totalCountFree(params);
		
		RolePagingUtiles pagingUtiles = new RolePagingUtiles(Integer.parseInt(currentPage), Integer.parseInt(totalCount), request);
		
		params.put("startCount", String.valueOf(pagingUtiles.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtiles.getEndCount()));
		
		List<AllBoardVO> boardlist = service.myFreeBList(params);
		
		request.setAttribute("boardList", boardlist);
		request.setAttribute("paginationContent", pagingUtiles.getPagingHTMLS());
		
		
		return "/user/mypage/myboardWritten.tiles";
	}

}
