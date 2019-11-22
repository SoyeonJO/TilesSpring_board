package kr.or.ddit.utiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.NoticeItemVO;

public class AttachFileMapperNotice {
	public static List<NoticeItemVO> mapping(FileItem[] items, String notice_no){
		List<NoticeItemVO> noticeItemList = new ArrayList<NoticeItemVO>();
		
		if(items != null){
			NoticeItemVO noticeItemInfo = null;
			for(FileItem item : items){
				noticeItemInfo = new NoticeItemVO();
				
				noticeItemInfo.setFi_not_no(notice_no);
				
				String fileName = FilenameUtils.getName(item.getName());
				noticeItemInfo.setFi_not_name(fileName);
				noticeItemInfo.setFi_not_content_type(item.getContentType());
				noticeItemInfo.setFi_not_size(String.valueOf(item.getSize()));
				
				String baseName = FilenameUtils.getBaseName(fileName);
				String extension = FilenameUtils.getExtension(fileName);
				String genId = UUID.randomUUID().toString().replace("-", "");
				String noticeSaveName = baseName + "-" + genId + "." + extension;
				
				noticeItemInfo.setFi_not_save_name(noticeSaveName);
				
				noticeItemList.add(noticeItemInfo);
				saveNotice(noticeSaveName, item);
			}
		}
		return noticeItemList;
	}
	
	private static void saveNotice(String noticeSaveName, FileItem item){
		File saveNotice = new File(GlobalConstant.FILE_PATH, noticeSaveName);
		
		try{
			item.write(saveNotice);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
