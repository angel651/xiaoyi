package service;

import dao.bean.News;

import java.util.List;

public interface NewsService {
	 // 查询所有新闻
	public List<News> queryAll();
}
