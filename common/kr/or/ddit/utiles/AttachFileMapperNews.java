package kr.or.ddit.utiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

import kr.or.ddit.global.GlobalConstant;
import kr.or.ddit.vo.NewsItemVO;


public class AttachFileMapperNews {
	public static List<NewsItemVO> mapping(FileItem[] items, String news_no){
		List<NewsItemVO> newsItemList = new ArrayList<NewsItemVO>();
		
		if(items != null){
			NewsItemVO newsItemInfo = null;
			for(FileItem item : items){
				newsItemInfo = new NewsItemVO();
				
				newsItemInfo.setFi_news_no(news_no);
				
				String fileName = FilenameUtils.getName(item.getName());
				newsItemInfo.setFi_news_name(fileName);
				newsItemInfo.setFi_news_content_type(item.getContentType());
				newsItemInfo.setFi_news_size(String.valueOf(item.getSize()));
				
				String baseName = FilenameUtils.getBaseName(fileName);
				String extension = FilenameUtils.getExtension(fileName);
				String genId = UUID.randomUUID().toString().replace("-", "");
				String newsSaveName = baseName + "-" + genId + "." + extension;
				
				newsItemInfo.setFi_news_save_name(newsSaveName);
				
				newsItemList.add(newsItemInfo);
				saveNews(newsSaveName, item);
			}
		}
		return newsItemList;
	}
	
	private static void saveNews(String newsSaveName, FileItem item){
		File saveNews = new File(GlobalConstant.FILE_PATH, newsSaveName);
		
		try{
			item.write(saveNews);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
