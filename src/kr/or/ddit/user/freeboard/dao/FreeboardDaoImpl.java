package kr.or.ddit.user.freeboard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.FreeboardVO;

public class FreeboardDaoImpl implements IfreeboardDao {
	
	
	private static IfreeboardDao dao = new FreeboardDaoImpl();
	private SqlMapClient client;
	
	private FreeboardDaoImpl(){
		client= SqlMapClientFactory.getSqlMapClient();
	}
	public static IfreeboardDao getInstance(){
		return (dao == null) ? dao = new FreeboardDaoImpl(): dao;
	}
	

	@Override
	public List<FreeboardVO> FreeboardList(Map<String, String> params)
			throws SQLException {
		
		return client.queryForList("freeboard.freeboardList", params);
	}
	

	@Override
	public FreeboardVO freeboardInfo(Map<String, String> params) throws SQLException {
		client.update("freeboard.updateBOHIT", params);
		return (FreeboardVO) client.queryForObject("freeboard.freeboardInfo", params);
	}
	@Override
	public String insertInfo(FreeboardVO freeboardInfo) throws SQLException {
	   return (String) client.insert("freeboard.boinsert", freeboardInfo);
	}
	@Override
	public void updateInfo(FreeboardVO freeboardInfo) throws SQLException {
		  client.update("freeboard.boupdate", freeboardInfo);
	
	}
	@Override
	public void deleteInfo(Map<String, String> params) throws SQLException {
	     client.delete("freeboard.bodelete", params);	
	}
	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		// TODO Auto-generated method stub
		return (String) client.queryForObject("freeboard.totalCount", params);
	}
	@Override
	public void insertReInfo(FreeboardVO freeboardInfo) throws SQLException {
		  
		
	try{	
		client.startTransaction();
		String bo_seq;
		 if("0".intern() == freeboardInfo.getBo_seq().intern()){
			 
			bo_seq = (String) client.queryForObject("freeboard.incrementSEQ", freeboardInfo);
		 }else{
			client.update("freeboard.updateSEQ", freeboardInfo);
			bo_seq = String.valueOf(Integer.parseInt(freeboardInfo.getBo_seq())+1);
		 }

		 
		 freeboardInfo.setBo_seq(bo_seq);
		 
		 String bo_depth = String.valueOf(Integer.parseInt(freeboardInfo.getBo_seq())+1);
		 freeboardInfo.setBo_depth(bo_depth);
		 
		 client.insert("freeboard.insertFreeboardReply", freeboardInfo);
		 client.commitTransaction();
		
	}finally{
		 client.endTransaction();

	}
  }
}