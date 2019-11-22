package kr.or.ddit.user.fileitem.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.factory.SqlMapClientFactory;
import kr.or.ddit.vo.FileItemVO;

public class IfileItemDaoImpl implements IfileItemDao {
    
	
	private static IfileItemDao dao =  new IfileItemDaoImpl();
	private SqlMapClient client;
	
	private IfileItemDaoImpl(){
         client = SqlMapClientFactory.getSqlMapClient();

	}
	
	public static IfileItemDao getInstance(){
		return (dao == null) ? dao = new IfileItemDaoImpl() : dao ;
	}	
	
	@Override
	public void insertFile(List<FileItemVO> fileItemList) throws SQLException {
		for(FileItemVO fileInfo : fileItemList){
			
			client.startTransaction();
			client.commitTransaction();
			client.endTransaction();
			client.insert("fileitem.insertFileItem", fileInfo);
		}

	}

	@Override
	public FileItemVO fileInfo(Map<String, String> params) throws SQLException {
		return (FileItemVO) client.queryForObject("fileitem.fileItemInfo", params);
	}

}
