package kr.or.ddit.user.freeboard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FreeboardVO;

public interface IfreeboardDao {

	
	public List<FreeboardVO> FreeboardList (Map<String, String> params) throws SQLException;
	public FreeboardVO freeboardInfo(Map<String, String> params) throws SQLException;
	public String insertInfo(FreeboardVO freeboardInfo) throws SQLException;
	public void updateInfo(FreeboardVO freeboardInfo) throws SQLException;
	public void deleteInfo(Map<String, String> params) throws SQLException;
	
	public String totalCount (Map<String, String> params) throws SQLException;
	public void insertReInfo(FreeboardVO freeboardInfo) throws SQLException;
}
