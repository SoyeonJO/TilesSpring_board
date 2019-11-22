package kr.or.ddit.user.mypage.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.AllBoardVO;

public class IMemMypageDaoImpl implements IMemMypageDao {

	private SqlMapClient client;
	private IMemMypageDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	private static IMemMypageDao dao;
	public static IMemMypageDao getInstance() {
		return (dao == null) ? new IMemMypageDaoImpl() : dao;
	}
	
	@Override
	public List<AllBoardVO> myboardList(Map<String, String> params) throws SQLException {
		return client.queryForList("memmypage.memberBoardList", params);
	}

	@Override
	public List<AllBoardVO> myFreeBList(Map<String, String> params) throws SQLException {
		return client.queryForList("memmypage.memberFreeBList", params);
	}

	@Override
	public List<AllBoardVO> myQnaBList(Map<String, String> params) throws SQLException {
		return client.queryForList("memmypage.memberQnaBList", params);
	}

	@Override
	public String totalCountFree(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("memmypage.totalCountFree", params);
	}

	@Override
	public String totalCountQna(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("memmypage.totalCountQna", params);
	}

}
