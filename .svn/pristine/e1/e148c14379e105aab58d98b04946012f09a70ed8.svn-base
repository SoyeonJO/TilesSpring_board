package kr.or.ddit.user.freeboard.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.FreeboardVO;

public interface IfreeboardService {
       
	public List<FreeboardVO> FreeboardList (Map<String, String> params);
	public FreeboardVO freeboardInfo(Map<String, String> params);
	public void insertInfo(FreeboardVO freeboardInfo, FileItem[] items);
	public void updateInfo(FreeboardVO freeboardInfo);
	public void deleteInfo(Map<String, String> params);
	
	public String totalCount (Map<String, String> params);
	public void insertReInfo(FreeboardVO freeboardInfo);

}
