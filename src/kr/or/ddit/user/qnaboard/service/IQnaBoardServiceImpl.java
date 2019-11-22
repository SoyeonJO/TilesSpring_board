package kr.or.ddit.user.qnaboard.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.qnaboard.dao.IQnaBoardDao;
import kr.or.ddit.user.qnaboard.dao.IQnaBoardDaoImpl;
import kr.or.ddit.utiles.AttachFileMapperQna;
import kr.or.ddit.vo.QnaItemVO;
import kr.or.ddit.vo.QnaboardVO;

import org.apache.commons.fileupload.FileItem;

public class IQnaBoardServiceImpl implements IQnaBoardService {

	private static IQnaBoardService service = new IQnaBoardServiceImpl();
	private IQnaBoardDao iQnaBoardDao;
//	private IQnaItemDao IQnaItemDao; 
	
	private IQnaBoardServiceImpl(){
		iQnaBoardDao = IQnaBoardDaoImpl.getInstance();
//		IQnaItemDao = IQnaItemDaoImpl.getInstance();
	}
	
	public static IQnaBoardService getInstance(){
		return (service == null) ? service = new IQnaBoardServiceImpl() : service;
	}
	
	@Override
	public List<QnaboardVO> qnaBoardList(Map<String, String> params) {
		List<QnaboardVO> qnaBoardList = null;
		
		try {
			qnaBoardList = iQnaBoardDao.qnaBoardList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return qnaBoardList;
	}

	@Override
	public QnaboardVO qnaBoardInfo(Map<String, String> params) {
		QnaboardVO qnaBoardInfo = null;
		
		try {
			qnaBoardInfo = iQnaBoardDao.qnaBoardInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return qnaBoardInfo;
	}

	@Override
	public void insertInfo(QnaboardVO qnaBoardInfo, FileItem[] items) {
		String qna_no;
		try {
			qna_no = iQnaBoardDao.insertInfo(qnaBoardInfo);
			List<QnaItemVO> qnaItemList = AttachFileMapperQna.mapping(items, qna_no);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateInfo(QnaboardVO qnaBoardInfo) {
		try {
			iQnaBoardDao.updateInfo(qnaBoardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteInfo(Map<String, String> params) {
		try {
			iQnaBoardDao.deleteInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String totalCount(Map<String, String> params) {
		
		String totalCount = "1";

		try {
			totalCount = iQnaBoardDao.totalCount(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return totalCount;
	}

	@Override
	public void insertReInto(QnaboardVO qnaBoardInfo) {
		try {
			iQnaBoardDao.insertReInto(qnaBoardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
