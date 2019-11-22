package kr.or.ddit.admin.qnaboard.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.admin.qnaboard.service.IQnaBoardService;
import kr.or.ddit.admin.qnaboard.service.IQnaBoardServiceImpl;
import kr.or.ddit.utiles.FileUploadRequestWrapper;
import kr.or.ddit.vo.QnaboardVO;

public class InsertQnaAction implements IAction {

	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		FileUploadRequestWrapper wrapper = (FileUploadRequestWrapper) request;
		
		QnaboardVO qnaBoardInfo = new QnaboardVO();
		
		try {
			BeanUtils.populate(qnaBoardInfo, request.getParameterMap());
		
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		IQnaBoardService service = IQnaBoardServiceImpl.getInstance();
		service.insertInfo(qnaBoardInfo, wrapper.getFileItemValues("files"));
		
		
		return "/admin/qna/qnaList.do";
		
	}

}
