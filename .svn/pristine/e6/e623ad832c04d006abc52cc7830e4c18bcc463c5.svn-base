package kr.or.ddit.user.news.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.news.service.INewsService;
import kr.or.ddit.user.news.service.INewsServiceImpl;

public class DeleteNewsAction implements IAction {
	
	private boolean redirectFlag = true;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {

		String news_no = request.getParameter("news_no");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("news_no", news_no);
		
		INewsService service = INewsServiceImpl.getInstance();
		service.deleteNewsInfo(params);
		
		return "/user/news/newsList.do";
	}
	
	
}
