package kr.or.ddit.admin.qnaboard.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.QnaboardVO;

public interface IQnaBoardService {
	public List<QnaboardVO> qnaBoardList(Map<String, String> params);
	public QnaboardVO qnaBoardInfo(Map<String, String> params);
	public void insertInfo(QnaboardVO qnaBoardInfo, FileItem[] items);
	public void updateInfo(QnaboardVO qnaBoardInfo);
	public void deleteInfo(Map<String, String> params);
	
	public String totalCount(Map<String, String> params);
	public void insertReInto(QnaboardVO qnaBoardInfo);
}
