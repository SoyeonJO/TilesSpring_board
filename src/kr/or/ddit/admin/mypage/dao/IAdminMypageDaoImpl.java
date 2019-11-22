package kr.or.ddit.admin.mypage.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.WithdrawVO;

public class IAdminMypageDaoImpl implements IAdminMypageDao {
	
	private SqlMapClient client;
	private IAdminMypageDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	private static IAdminMypageDao dao;
	public static IAdminMypageDao getInstance() {
		return(dao == null) ? new IAdminMypageDaoImpl() : dao;
	}

	@Override
	public List<MemberVO> memberList(Map<String, String> params) throws SQLException {
		return client.queryForList("adminmypage.memberList", params);
	}

	@Override
	public List<WithdrawVO> memberListDel(Map<String, String> params)	throws SQLException {
		return client.queryForList("adminmypage.memberListDel", params);
	}
	
	@Override
	public void memberDelete(MemberVO membervo) throws SQLException {
		client.delete("adminmypage.memberDelete", membervo);
	}

	@Override
	public String countStar(String star) throws SQLException {
		return (String) client.queryForObject("adminmypage.countStar", star);
	}

	@Override
	public String totalCountMember(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("adminmypage.totalCountMember", params);
	}

	@Override
	public String totalCountMemberDel(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("adminmypage.totalCountMemberDel", params);
	}

	@Override
	public String countInsertDate(String selectdate) throws SQLException {
		return (String) client.queryForObject("adminmypage.countInsertDate", selectdate);
	}

}
