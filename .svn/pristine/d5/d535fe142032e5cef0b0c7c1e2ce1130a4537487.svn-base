package kr.or.ddit.user.fileitem.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.fileitem.dao.IfileItemDao;
import kr.or.ddit.user.fileitem.dao.IfileItemDaoImpl;
import kr.or.ddit.user.freeboard.dao.IfreeboardDao;
import kr.or.ddit.vo.FileItemVO;

public class IfileItemServiceImpl implements IfileItemService {

	private static IfileItemService service = new IfileItemServiceImpl();
	   
	   private IfileItemDao dao;
	   private IfileItemServiceImpl(){
		   dao = IfileItemDaoImpl.getInstance();
	   }
	   
	   public static IfileItemService getInstance(){
		   
		   return (service  == null) ? service = new IfileItemServiceImpl() : service; 
	   }
	   
	
	
	@Override
	public void insertFile(List<FileItemVO> fileItemList) {
		// TODO Auto-generated method stub

	}

	@Override
	public FileItemVO fileInfo(Map<String, String> params) {
	       FileItemVO fileInfo = null;
	       
	       try {
			fileInfo = dao.fileInfo(params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileInfo;
	}

}
