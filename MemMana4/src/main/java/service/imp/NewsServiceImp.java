package service.imp;

/*
 * 业务层Service的实现调用Dao层
 */

import dao.NewsDao;
import dao.bean.News;
import dao.imp.NewsDaoImp;
import service.NewsService;

import java.util.List;

public class NewsServiceImp implements NewsService {
	
	@Override
	public List<News> queryAll() {
		//服务层调用数据访问层
		NewsDao newsDaoImp = new NewsDaoImp();
		try {
			List<News> newsList = newsDaoImp.queryAll();
			System.out.println("在服务层输出从数据库查询到的"+newsList.size()+"条技术文档记录"); 
			return newsList;
			//return newsDaoImp.queryAll(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
