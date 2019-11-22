package kr.or.ddit.admin.drug.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.action.controller.IAction;
import kr.or.ddit.admin.drug.service.IDrugService;
import kr.or.ddit.admin.drug.service.IDrugServiceImpl;
import kr.or.ddit.vo.DrugSaveVO;

public class DrugStatisticsAction implements IAction {
	private boolean redirectFlag = false;

	@Override
	public boolean isRedirect() {
		return redirectFlag;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		IDrugService service = IDrugServiceImpl.getInstance();
		
		List<DrugSaveVO> nameList = service.getDrugName();
		
		List<String> cntList = new ArrayList<String>();
		
		for(DrugSaveVO dv : nameList){
			String drugName = dv.getMd_ct_name();
			
			String a = service.countDrug(drugName);
			
			cntList.add(a);
		}
		
		request.setAttribute("cntList", cntList);
		request.setAttribute("nameList", nameList);
		
		return "/admin/mypage/drugStatistics.tiles";
	}

}
