package kr.or.ddit.user.news.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.vo.NewsVO;

public interface INewsService {
	//public List<NewsVO> newsList(Map<String, String> params);
	public List<NewsVO> newsList(Map<String, String> params);
	public NewsVO newsInfo(Map<String, String> params);
	public void insertNewsInfo(NewsVO newsInfo, FileItem[] items);
	public void updateNewsInfo(NewsVO newsInfo);
	public void deleteNewsInfo(Map<String, String> params);
	public String totalCount(Map<String, String> params);
	
}
