package kr.or.ddit.user.drug.controller;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.user.drug.service.IDrugService;
import kr.or.ddit.user.drug.service.IDrugServiceImpl;
import kr.or.ddit.vo.DrugSaveVO;

public class SaveDrugInfoAction implements IAction {
	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		DrugSaveVO drugInfo = new DrugSaveVO();
		
		try {
			BeanUtils.populate(drugInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		IDrugService service = IDrugServiceImpl.getInstance();
		service.insertDrugInfo(drugInfo);
		
		return "/user/drug/drugView.do";
	}

}
