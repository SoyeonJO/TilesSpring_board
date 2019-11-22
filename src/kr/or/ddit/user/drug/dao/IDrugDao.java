package kr.or.ddit.user.drug.dao;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.vo.DrugSaveVO;

public interface IDrugDao {
	public void insertDrugInfo(DrugSaveVO drugInfo) throws SQLException;
}
