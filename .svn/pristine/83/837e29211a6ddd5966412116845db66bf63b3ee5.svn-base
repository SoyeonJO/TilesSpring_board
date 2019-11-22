package kr.or.ddit.user.news.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.news.service.INewsService;
import kr.or.ddit.user.news.service.INewsServiceImpl;
import kr.or.ddit.vo.NewsVO;

public class UpdateNewsAction implements IAction{
	
	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {

		NewsVO newsInfo = new NewsVO();
		
		try {
			BeanUtils.populate(newsInfo, request.getParameterMap());
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8"); 
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		INewsService service = INewsServiceImpl.getInstance();
		service.updateNewsInfo(newsInfo);
		
		
		return "/user/news/newsList.do";
	}
	
	
}
