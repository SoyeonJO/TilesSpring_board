package kr.or.ddit.admin.freeboard.service;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.admin.fileitem.dao.IfileItemDao;
import kr.or.ddit.admin.fileitem.dao.IfileItemDaoImpl;
import kr.or.ddit.admin.freeboard.dao.FreeboardDaoImpl;
import kr.or.ddit.admin.freeboard.dao.IfreeboardDao;
import kr.or.ddit.utiles.AttachFileMapper_free;
import kr.or.ddit.vo.FileItemVO;
import kr.or.ddit.vo.FreeboardVO;

public class FreeboardServiceImpl implements IfreeboardService {

	private static IfreeboardService service = new FreeboardServiceImpl();
	private IfreeboardDao IfreeboardDao;
	private IfileItemDao IfileItemDao;
	

	private FreeboardServiceImpl() {
		IfreeboardDao = FreeboardDaoImpl.getInstance();
		IfileItemDao = IfileItemDaoImpl.getInstance();
	}
	
	
	

	public static IfreeboardService getInstance() {
		return (service == null) ? service = new FreeboardServiceImpl()
				: service;
	}
	  
	@Override
	public List<FreeboardVO> FreeboardList(Map<String, String> params) {
		List<FreeboardVO> freeboardList = null;
		   
		try {
			freeboardList = IfreeboardDao.FreeboardList(params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return freeboardList;
	}
	  

	@Override
	public FreeboardVO freeboardInfo(Map<String, String> params) {
		   FreeboardVO freeboardInfo = null;
		   
		      try {
				freeboardInfo = IfreeboardDao.freeboardInfo(params);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return freeboardInfo;
	}

	@Override
	public void insertInfo(FreeboardVO freeboardInfo, FileItem[] items) {
		         try {
		        	String bo_no = IfreeboardDao.insertInfo(freeboardInfo);
		        	List<FileItemVO> fileItemList  = AttachFileMapper_free.mapping(items, bo_no);
		        	
		        	IfileItemDao.insertFile(fileItemList);
				} catch (SQLException e) {
					e.printStackTrace();
				}   
		
	}

	@Override
	public void updateInfo(FreeboardVO freeboardInfo) {
		   try {
			IfreeboardDao.updateInfo(freeboardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteInfo(Map<String, String> params) {
		try {
			IfreeboardDao.deleteInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String totalCount(Map<String, String> params) {
		String totalCount = "1";
		    try {
		    	totalCount = IfreeboardDao.totalCount(params);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return totalCount;
	}




	@Override
	public void insertReInfo(FreeboardVO freeboardInfo) {
	   
		try {
			IfreeboardDao.insertReInfo(freeboardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}





}
