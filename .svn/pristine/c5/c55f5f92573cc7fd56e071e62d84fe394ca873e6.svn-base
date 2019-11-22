package kr.or.ddit.user.newsitem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.NewsItemVO;

public class INewsItemDaoImpl implements INewsItemDao {

	private static INewsItemDao dao = new INewsItemDaoImpl();
	private SqlMapClient client;
	
	private INewsItemDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static INewsItemDao getInstance(){
		return (dao == null) ? dao = new INewsItemDaoImpl() : dao;
	}
	
	@Override
	public void insertNewsItemInfo(List<NewsItemVO> newsItemList) throws SQLException {
		
		try{
			client.startTransaction();
			for(NewsItemVO newsItemInfo : newsItemList){
				client.insert("newsitem.insertNewsItem", newsItemInfo);			
			}
			client.commitTransaction();
			
		}finally{
			client.endTransaction();
		}
	}

	@Override
	public NewsItemVO newsItemInfo(Map<String, String> params)
			throws SQLException {
		return (NewsItemVO) client.queryForObject("newsitem.newsItemInfo", params);
	}

}
