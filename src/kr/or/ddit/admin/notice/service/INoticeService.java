package kr.or.ddit.admin.notice.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.NoticeItemVO;
import kr.or.ddit.vo.NoticeVO;

public interface INoticeService {
//	public List<FreeboardVO> freeboardList(Map<String, String> params);
//	public void insertFreeboardInfo(FreeboardVO freeboardInfo, FileItem[] items);
//	public void updateFreeboardInfo(FreeboardVO freeboardInfo);
//	public FreeboardVO freeboardInfo(Map<String, String> params);
//	public void deleteFreeboardInfo(Map<String, String> params);
//	public String totalCount(Map<String, String> params);
//	public void insertFreeboardReplyInfo(FreeboardVO freeboardInfo);

	public List<NoticeVO> noticeList(Map<String, String> params);
	public void insertNoticeInfo(NoticeVO noticeInfo, FileItem[] items);
	public void updateNoticeInfo(NoticeVO noticeInfo);
	public NoticeVO noticeInfo(Map<String, String> params);
	public void deleteNoticeInfo(Map<String, String> params);
	public String totalCount(Map<String, String> params);
	
}
