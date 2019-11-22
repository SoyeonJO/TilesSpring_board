package kr.or.ddit.user.drug.dao;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.DrugSaveVO;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.engine.builder.xml.SqlMapClasspathEntityResolver;

public class IDrugDaoImpl implements IDrugDao {
	private SqlMapClient client;
	
	private IDrugDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	private static IDrugDao dao = new IDrugDaoImpl();
	
	public static IDrugDao getInstance(){
		return (dao == null) ? dao = new IDrugDaoImpl() : dao;
	}
	
	@Override
	public void insertDrugInfo(DrugSaveVO drugInfo) throws SQLException {
		client.insert("drug.insertDrugInfo", drugInfo);
	}

}
