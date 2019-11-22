package kr.or.ddit.user.noticeitem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.user.notice.dao.INoticeDaoImpl;
import kr.or.ddit.vo.NoticeItemVO;

public class INoticeItemDaoImpl implements INoticeItemDao {

	private static INoticeItemDao dao = new INoticeItemDaoImpl();
	private SqlMapClient client;
	
	private INoticeItemDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static INoticeItemDao getInstance(){
		return (dao == null) ? dao = new INoticeItemDaoImpl() : dao;
	}
	
	@Override
	public void insertNoticeItemInfo(List<NoticeItemVO> noticeItemList)
			throws SQLException {
		try{
			client.startTransaction();
			for(NoticeItemVO noticeItemInfo : noticeItemList){
				client.insert("noticeitem.insertNoticeItem", noticeItemInfo);
			}
			client.commitTransaction();
		}finally{
			client.endTransaction();
		}
		
	}

	@Override
	public NoticeItemVO noticeItemInfo(Map<String, String> params)
			throws SQLException {
		return (NoticeItemVO)client.queryForObject("noticeitem.fileItemInfo",params);
	}

}
