package kr.or.ddit.admin.drug.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.vo.DrugSaveVO;

public interface IDrugDao {
	public List<DrugSaveVO> getDrugName() throws SQLException;
	
	public String countDrug(String md_ct_name) throws SQLException;
	
	public void insertDrugInfo(DrugSaveVO drugInfo) throws SQLException;
}
