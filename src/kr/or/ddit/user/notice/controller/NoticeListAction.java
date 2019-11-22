package kr.or.ddit.user.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.notice.service.INoticeService;
import kr.or.ddit.user.notice.service.INoticeServiceImpl;
import kr.or.ddit.utiles.RolePagingUtiles;
import kr.or.ddit.vo.NoticeVO;

public class NoticeListAction implements IAction {
	
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		INoticeService service = INoticeServiceImpl.getInstance();

		String search_keycode = request.getParameter("search_keycode");
		String search_keyword = request.getParameter("search_keyword");
		
		
		Map<String, String> notice = new HashMap<String, String>();
		notice.put("search_keycode", search_keycode);
		notice.put("search_keyword", search_keyword);
		
		String currentPage = request.getParameter("currentPage");
		if(currentPage == null){
			currentPage = "1";
			
		}
		
		String totalCount = service.totalCount(notice);
		
		RolePagingUtiles pagingUtiles = new RolePagingUtiles(Integer.parseInt(currentPage),
														Integer.parseInt(totalCount),
														request);
		notice.put("startCount", String.valueOf(pagingUtiles.getStartCount()));
		notice.put("endCount", String.valueOf(pagingUtiles.getEndCount()));
		
		List<NoticeVO> noticeList = service.noticeList(notice);
		String page = pagingUtiles.getPagingHTMLS();
		
		request.setAttribute("list", noticeList);
		request.setAttribute("page", page);
		
		return "/user/notice/noticeList.tiles";
	}

}
