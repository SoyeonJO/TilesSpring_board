package kr.or.ddit.user.fileitem.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.FileItemVO;

public interface IfileItemService {
	
	public void insertFile(List<FileItemVO> fileItemList);
	public FileItemVO fileInfo(Map<String, String> params);

}
