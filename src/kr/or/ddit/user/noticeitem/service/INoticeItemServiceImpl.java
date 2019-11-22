package kr.or.ddit.user.noticeitem.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.noticeitem.dao.INoticeItemDao;
import kr.or.ddit.user.noticeitem.dao.INoticeItemDaoImpl;
import kr.or.ddit.vo.NoticeItemVO;

public class INoticeItemServiceImpl implements INoticeItemService {

	private INoticeItemDao dao;
	private INoticeItemServiceImpl() {
		dao = INoticeItemDaoImpl.getInstance();
	}
	
	private static INoticeItemService service;
	public static INoticeItemService getInstance(){
		return(service == null) ? service = new INoticeItemServiceImpl() : service;
	}
	
	@Override
	public void insertNoticeItemInfo(List<NoticeItemVO> noticeItemList) {
		
		
	}

	@Override
	public NoticeItemVO noticeItemInfo(Map<String, String> params) {
		NoticeItemVO noticeItemInfo = null;
		try{
			noticeItemInfo = dao.noticeItemInfo(params);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return noticeItemInfo;
	}

}
