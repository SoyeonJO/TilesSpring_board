package kr.or.ddit.user.notice.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.NoticeItemVO;
import kr.or.ddit.vo.NoticeVO;

public class INoticeDaoImpl implements INoticeDao {

	private static INoticeDao dao = new INoticeDaoImpl();
	private SqlMapClient client;
	
	private INoticeDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	public static INoticeDao getInstance(){
		return (dao == null) ? dao = new INoticeDaoImpl() : dao;
	}
	
	@Override
	public List<NoticeVO> noticeList(Map<String, String> params)
			throws SQLException {
		return client.queryForList("notice.noticeList",params);
	}

	@Override
	public String insertNoticeInfo(NoticeVO noticeInfo) throws SQLException {
		return (String) client.insert("notice.insertNotice", noticeInfo);
	}

	@Override
	public void updateNoticeInfo(NoticeVO noticeInfo) throws SQLException {
		client.update("notice.updateNotice", noticeInfo);
		
	}

	@Override
	public NoticeVO noticeInfo(Map<String, String> params) throws SQLException {
		client.update("notice.updateNOHIT", params);
		return (NoticeVO) client.queryForObject("notice.noticeInfo",params);
	}

	@Override
	public void deleteNoticeInfo(Map<String, String> params)
			throws SQLException {
		client.update("notice.deleteNotice", params);
		
	}

	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("notice.totalCount", params);
	}
	
}
