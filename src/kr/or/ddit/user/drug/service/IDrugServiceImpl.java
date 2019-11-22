package kr.or.ddit.user.drug.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.user.drug.dao.IDrugDao;
import kr.or.ddit.user.drug.dao.IDrugDaoImpl;
import kr.or.ddit.vo.DrugSaveVO;

public class IDrugServiceImpl implements IDrugService {
	private static IDrugService service = new IDrugServiceImpl();
	private IDrugDao dao;
	
	private IDrugServiceImpl(){
		dao = IDrugDaoImpl.getInstance();
	}
	
	public static IDrugService getInstance(){
		return (service == null) ? service = new IDrugServiceImpl() : service;
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
