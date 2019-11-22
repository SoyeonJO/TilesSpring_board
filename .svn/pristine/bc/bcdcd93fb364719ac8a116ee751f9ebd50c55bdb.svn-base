package kr.or.ddit.admin.freeboard.controller;

import java.lang.reflect.InvocationTargetException;
import java.sql.Wrapper;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.admin.freeboard.service.FreeboardServiceImpl;
import kr.or.ddit.admin.freeboard.service.IfreeboardService;
import kr.or.ddit.vo.FreeboardVO;

public class FreeboardFormAction implements IAction {

	private boolean redirectFlag = false;
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		return "/admin/freeboard/freeboardForm.tiles";
	
	}


}
