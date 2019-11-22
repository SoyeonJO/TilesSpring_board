package kr.or.ddit.admin.qnaboard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.QnaboardVO;

public interface IQnaBoardDao {

	public List<QnaboardVO> qnaBoardList(Map<String, String> params) throws SQLException;
	public QnaboardVO qnaBoardInfo(Map<String, String> params) throws SQLException;
	public String insertInfo(QnaboardVO qnaBoardInfo) throws SQLException;
	public void updateInfo(QnaboardVO qnaBoardInfo) throws SQLException;
	public void deleteInfo(Map<String, String> params) throws SQLException;
	
	public String totalCount(Map<String, String> params) throws SQLException;
	public void insertReInto(QnaboardVO qnaBoardInfo) throws SQLException;
}
