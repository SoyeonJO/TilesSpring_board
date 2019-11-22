package kr.or.ddit.admin.newsitem.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.NewsItemVO;

public interface INewsItemService {
	public void insertNewsItemInfo(List<NewsItemVO> newsItemList);
	public NewsItemVO newsItemInfo(Map<String, String> params);
}
