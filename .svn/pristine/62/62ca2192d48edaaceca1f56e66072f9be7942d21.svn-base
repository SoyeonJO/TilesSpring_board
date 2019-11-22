package kr.or.ddit.admin.news.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.admin.news.service.INewsService;
import kr.or.ddit.admin.news.service.INewsServiceImpl;
import kr.or.ddit.utiles.RolePagingUtiles;
import kr.or.ddit.vo.NewsVO;

public class NewsListAction implements IAction{
	private boolean redirectFlag = false;
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		//Map<String, String> params = (Map<String, String>) request.getAttribute("publicKeyMap");
		
		INewsService service = INewsServiceImpl.getInstance();
		
		String search_keycode = request.getParameter("search_keycode");
		String search_keyword = request.getParameter("search_keyword");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		
		String currentPage = request.getParameter("currentPage");
		if(currentPage == null){
			currentPage = "1";
			
		}
		
		String totalCount = service.totalCount(params);
		
		RolePagingUtiles pagingUtiles = new RolePagingUtiles(Integer.parseInt(currentPage),
														Integer.parseInt(totalCount),
														request);
		
		params.put("startCount", String.valueOf(pagingUtiles.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtiles.getEndCount()));
		
		List<NewsVO> newsList = service.newsList(params);
		String page = pagingUtiles.getPagingHTMLS();
		
		request.setAttribute("list", newsList);
		request.setAttribute("page", page);
		
		
		return "/admin/news/newsList.tiles";
	}

	
}
