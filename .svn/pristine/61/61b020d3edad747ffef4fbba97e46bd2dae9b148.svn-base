package kr.or.ddit.admin.news.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.NewsVO;

public class INewsDaoImpl implements INewsDao {

	private static INewsDao dao = new INewsDaoImpl();
	private SqlMapClient client;
	
	private INewsDaoImpl(){
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static INewsDao getInstance(){
		return (dao == null) ? dao = new INewsDaoImpl() : dao;
	}
	
	
	@Override
	public List<NewsVO> newsList(Map<String, String> params)
			throws SQLException {
		return client.queryForList("news.newsList", params);
	}

	@Override
	public NewsVO newsInfo(Map<String, String> params) throws SQLException {
		client.update("news.updateNEWSHIT", params);
		return (NewsVO) client.queryForObject("news.newsInfo", params);
	}

	@Override
	public String insertNewsInfo(NewsVO newsInfo) throws SQLException {
		return (String) client.insert("news.insertNews", newsInfo);
	}

	@Override
	public void updateNewsInfo(NewsVO newsInfo) throws SQLException {
		client.update("news.updateNews", newsInfo);
	}

	@Override
	public void deleteNewsInfo(Map<String, String> params) throws SQLException {
		client.update("news.deleteNews", params);
	}

	@Override
	public String totalCount(Map<String, String> params) throws SQLException {
		return (String) client.queryForObject("news.totalCount", params);
	}

}
