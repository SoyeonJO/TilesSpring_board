package kr.or.ddit.admin.news.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.admin.news.service.INewsService;
import kr.or.ddit.admin.news.service.INewsServiceImpl;
import kr.or.ddit.vo.NewsVO;

public class NewsViewAction implements IAction {
	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		String news_no = request.getParameter("news_no");
		
		Map<String, String> params = new HashMap<String, String>();
		INewsService service = INewsServiceImpl.getInstance();
		
		params.put("news_no", news_no);
		
		NewsVO newsInfo = service.newsInfo(params);
		
		request.setAttribute("newsInfo", newsInfo);
		
		return "/admin/news/newsView.tiles";
	}
	
	
}
