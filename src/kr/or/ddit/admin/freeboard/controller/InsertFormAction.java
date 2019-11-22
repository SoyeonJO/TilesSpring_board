package kr.or.ddit.admin.freeboard.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.admin.freeboard.service.FreeboardServiceImpl;
import kr.or.ddit.admin.freeboard.service.IfreeboardService;
import kr.or.ddit.utiles.FileUploadRequestWrapper;
import kr.or.ddit.vo.FreeboardVO;

public class InsertFormAction implements IAction {
	private boolean redirectFlag = false;
	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
	FileUploadRequestWrapper wrapper = (FileUploadRequestWrapper) request;
		
	FreeboardVO  freeboardInfo = new FreeboardVO(); 
		
		try {
			BeanUtils.populate(freeboardInfo, request.getParameterMap());
		    
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		IfreeboardService service = FreeboardServiceImpl.getInstance();
		service.insertInfo(freeboardInfo, wrapper.getFileItemValues("files"));
		
		return "/admin/freeboard/freeboardList.do";
	}

}
