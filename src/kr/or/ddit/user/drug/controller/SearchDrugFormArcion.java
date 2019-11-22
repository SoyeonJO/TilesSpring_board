package kr.or.ddit.user.drug.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;

public class SearchDrugFormArcion implements IAction {
	private boolean redirectFlag = false;

	
	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		return "/user/drug/searchDrugForm.tiles";
	}

}
