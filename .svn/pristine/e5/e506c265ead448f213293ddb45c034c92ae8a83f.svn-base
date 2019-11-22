package kr.or.ddit.admin.drug.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.DrugSaveVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class IDrugDaoImpl implements IDrugDao {
	private static IDrugDao dao = new IDrugDaoImpl();
	private SqlMapClient client;
	
	private IDrugDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IDrugDao getInstance(){
		return (dao == null) ? dao = new IDrugDaoImpl() : dao;
	}
	
	@Override
	public String countDrug(String md_ct_name) throws SQLException {
		return  (String) client.queryForObject("drug.countDrug", md_ct_name);
	}

	@Override
	public List<DrugSaveVO> getDrugName() throws SQLException{
		return client.queryForList("drug.getDrugName");
	}
	
	@Override
	public void insertDrugInfo(DrugSaveVO drugInfo) throws SQLException {
		client.insert("drug.insertDrugInfo", drugInfo);
	}

}
