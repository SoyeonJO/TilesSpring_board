package kr.or.ddit.admin.newsitem.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.admin.newsitem.dao.INewsItemDao;
import kr.or.ddit.admin.newsitem.dao.INewsItemDaoImpl;
import kr.or.ddit.vo.NewsItemVO;

public class INewsItemServiceImpl implements INewsItemService {

	private static INewsItemService service = new INewsItemServiceImpl();
	private INewsItemDao dao;
	
	private INewsItemServiceImpl(){
		dao = INewsItemDaoImpl.getInstance();
	}
	
	public static INewsItemService getInstance(){
		return (service == null) ? service = new INewsItemServiceImpl() : service;
	}
	
	@Override
	public void insertNewsItemInfo(List<NewsItemVO> newsItemList) {
		// TODO Auto-generated method stub

	}

	@Override
	public NewsItemVO newsItemInfo(Map<String, String> params) {
		NewsItemVO newsItemInfo = null;
		
		try {
			newsItemInfo = dao.newsItemInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newsItemInfo;
	}

}
