package kr.or.ddit.utiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.QnaItemVO;

public class AttachFileMapperQna {
	public static List<QnaItemVO> mapping(FileItem[] items, String qna_no){
		List<QnaItemVO> qnaItemList = new ArrayList<QnaItemVO>();
		
		if(items != null){
			QnaItemVO qnaItemInfo = null;
			for(FileItem item : items){
				qnaItemInfo = new QnaItemVO();
				qnaItemInfo.setFi_qa_no(qna_no);
				
				String fileName = FilenameUtils.getName(item.getName());
				qnaItemInfo.setFi_qa_name(fileName);
				qnaItemInfo.setFi_qa_content_type(item.getContentType());
				qnaItemInfo.setFi_qa_size(String.valueOf(item.getSize()));
				
				String baseName = FilenameUtils.getBaseName(fileName);
				String extension = FilenameUtils.getExtension(fileName);
				String genID = UUID.randomUUID().toString().replace("-", "");
				String fileSaveName = baseName + "_" + genID + "." + extension;
				qnaItemInfo.setFi_qa_save_name(fileSaveName);
				qnaItemList.add(qnaItemInfo);
				saveQna(fileSaveName, item);
				
			}
		}
		return qnaItemList;
	}

	private static void saveQna(String fileSaveName, FileItem item) {
		File saveQna = new File(GlobalConstant.FILE_PATH, fileSaveName);
		
		try {
			item.write(saveQna);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
