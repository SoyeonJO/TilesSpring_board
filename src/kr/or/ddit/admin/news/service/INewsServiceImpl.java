package kr.or.ddit.admin.news.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.admin.news.dao.INewsDao;
import kr.or.ddit.admin.news.dao.INewsDaoImpl;
import kr.or.ddit.admin.newsitem.dao.INewsItemDao;
import kr.or.ddit.admin.newsitem.dao.INewsItemDaoImpl;
import kr.or.ddit.utiles.AttachFileMapperNews;
import kr.or.ddit.vo.NewsItemVO;
import kr.or.ddit.vo.NewsVO;

public class INewsServiceImpl implements INewsService {
	
	private static  INewsService service = new INewsServiceImpl();
	private INewsDao newsDao;
	private INewsItemDao newsitemDao;
	
	private INewsServiceImpl(){
		newsDao = INewsDaoImpl.getInstance();
		newsitemDao =INewsItemDaoImpl.getInstance();
	}
	
	public static INewsService getInstance(){
		return(service == null) ? service = new INewsServiceImpl() : service;
	}
	
	@Override
	public List<NewsVO> newsList(Map<String, String> params) {
		List<NewsVO> newsList = null;
		
		try {
			newsList = newsDao.newsList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newsList;
	}

	@Override
	public NewsVO newsInfo(Map<String, String> params) {
		NewsVO newsInfo = null;
		
		try {
			newsInfo = newsDao.newsInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return newsInfo;
	}

	@Override
	public void insertNewsInfo(NewsVO newsInfo, FileItem[] items) {
		
		try {
			String news_no = newsDao.insertNewsInfo(newsInfo);
			List<NewsItemVO> newsItemList = AttachFileMapperNews.mapping(items, news_no);
			newsitemDao.insertNewsItemInfo(newsItemList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateNewsInfo(NewsVO newsInfo) {
		try {
			newsDao.updateNewsInfo(newsInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteNewsInfo(Map<String, String> params) {
		try {
			newsDao.deleteNewsInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount = null;
		try {
			totalCount = newsDao.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCount;
	}

}
