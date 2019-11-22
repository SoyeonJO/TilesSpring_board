package kr.or.ddit.user.qnaboard.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.QnaboardVO;

public class IQnaBoardDaoImpl implements IQnaBoardDao {

	private static IQnaBoardDao dao = new IQnaBoardDaoImpl();
	private SqlMapClient client;
	
	private IQnaBoardDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IQnaBoardDao getInstance(){
		return (dao == null) ? dao = new IQnaBoardDaoImpl() : dao;
	}
	
	@Override
	public List<QnaboardVO> qnaBoardList(Map<String, String> params)
			throws SQLException {
		
		return client.queryForList("qnaboard.qnaBoardList", params);
	}

	@Override
	public QnaboardVO qnaBoardInfo(Map<String, String> params)
			throws SQLException {
		client.update("qnaboard.updateQNAHIT", params);
		return (QnaboardVO) client.queryForObject("qnaboard.qnaBoardInfo", params);
	}

	@Override
	public String insertInfo(QnaboardVO qnaBoardInfo) throws SQLException {
		return (String) client.insert("qnaboard.qnainsert", qnaBoardInfo);
	}

	@Override
	public void updateInfo(QnaboardVO qnaBoardInfo) throws SQLException {
		client.update("qnaboard.qnaupdate", qnaBoardInfo);
	}

	@Override
	public void deleteInfo(Map<String, String> params) throws SQLException {
		client.delete("qnaboard.qnadelete", params);
	}

	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("qnaboard.totalCount", params);
	}

	@Override
	public void insertReInto(QnaboardVO qnaBoardInfo) throws SQLException {
		
			try{
			client.startTransaction();
			String qa_seq;
			if("0".intern() == qnaBoardInfo.getQa_seq().intern()){
				qa_seq = (String) client.queryForObject("qnaboard.incrementSEQ", qnaBoardInfo);
			}else{
				client.update("qnaboard.updateSEQ", qnaBoardInfo);
				qa_seq = String.valueOf(Integer.parseInt(qnaBoardInfo.getQa_depth()) + 1);
			}
			qnaBoardInfo.setQa_seq(qa_seq);
			
			String qa_depth = String.valueOf(Integer.parseInt(qnaBoardInfo.getQa_depth()) + 1);
			qnaBoardInfo.setQa_depth(qa_depth);
			
			client.insert("qnaboard.insertQnaBoardReply", qnaBoardInfo);
			client.commitTransaction();
		
		}catch(SQLException e){
			client.endTransaction();
		}
	}		
}		
