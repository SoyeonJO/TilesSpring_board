package kr.or.ddit.admin.drug.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.admin.drug.dao.IDrugDao;
import kr.or.ddit.admin.drug.dao.IDrugDaoImpl;
import kr.or.ddit.vo.DrugSaveVO;

public class IDrugServiceImpl implements IDrugService {
	private IDrugDao dao;
	private static IDrugService service = new IDrugServiceImpl();
	
	private IDrugServiceImpl(){
		dao = IDrugDaoImpl.getInstance();
	}
	
	public static IDrugService getInstance(){
		return (service == null) ? service = new IDrugServiceImpl() : service;
	}
	
	@Override
	public String countDrug(String md_ct_name) {
		String drugList = null;
		
		try {
			drugList = dao.countDrug(md_ct_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return drugList;
	}

	@Override
	public List<DrugSaveVO> getDrugName() {
		List<DrugSaveVO> nameList = null;
		
		try {
			nameList = dao.getDrugName();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nameList;
	}
	
	@Override
	public void insertDrugInfo(DrugSaveVO drugInfo) {
		try {
			dao.insertDrugInfo(drugInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
