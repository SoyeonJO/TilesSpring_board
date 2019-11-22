package kr.or.ddit.admin.notice.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.admin.notice.dao.INoticeDao;
import kr.or.ddit.admin.notice.dao.INoticeDaoImpl;
import kr.or.ddit.admin.noticeitem.dao.INoticeItemDao;
import kr.or.ddit.admin.noticeitem.dao.INoticeItemDaoImpl;
import kr.or.ddit.utiles.AttachFileMapperNotice;
import kr.or.ddit.vo.NoticeItemVO;
import kr.or.ddit.vo.NoticeVO;

public class INoticeServiceImpl implements INoticeService {

	private static INoticeService service = new INoticeServiceImpl();
	private INoticeDao noticeDao;
	private INoticeItemDao noticeitemDao;
	
	private INoticeServiceImpl(){
		noticeDao = INoticeDaoImpl.getInstance();
		noticeitemDao = INoticeItemDaoImpl.getInstance();
	}
	
	public static INoticeService getInstance(){
		return (service == null) ? service = new INoticeServiceImpl() : service;
	}
	
	@Override
	public List<NoticeVO> noticeList(Map<String, String> params) {
		List<NoticeVO> noticeList = null;
		try{
			noticeList = noticeDao.noticeList(params);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return noticeList;
	}

	@Override
	public void insertNoticeInfo(NoticeVO noticeInfo, FileItem[] items){
		try{
			String notice_no = noticeDao.insertNoticeInfo(noticeInfo);
			List<NoticeItemVO> noticeItemList = AttachFileMapperNotice.mapping(items, notice_no);
			
			noticeitemDao.insertNoticeItemInfo(noticeItemList);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}


	@Override
	public NoticeVO noticeInfo(Map<String, String> params) {
		NoticeVO noticeInfo = null;
		try{
			noticeInfo = noticeDao.noticeInfo(params);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return noticeInfo;
	}

	@Override
	public void updateNoticeInfo(NoticeVO noticeInfo) {
		try{
			noticeDao.updateNoticeInfo(noticeInfo);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteNoticeInfo(Map<String, String> params) {
		try{
			noticeDao.deleteNoticeInfo(params);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String cnt = null;
		try{
			cnt = noticeDao.totalCount(params);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return cnt;
	}



}
