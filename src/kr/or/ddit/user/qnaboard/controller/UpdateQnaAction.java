package kr.or.ddit.user.qnaboard.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.qnaboard.service.IQnaBoardService;
import kr.or.ddit.user.qnaboard.service.IQnaBoardServiceImpl;
import kr.or.ddit.vo.QnaboardVO;

public class UpdateQnaAction implements IAction{
	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		QnaboardVO qnaInfo = new QnaboardVO();
		
		try {
			
			BeanUtils.populate(qnaInfo, request.getParameterMap());
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8"); 
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		IQnaBoardService service = IQnaBoardServiceImpl.getInstance();
		service.updateInfo(qnaInfo);
		
		return "/user/qna/qnaList.do";
	}

}
