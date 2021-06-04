package dao.imp;

import dao.NewsDao;
import dao.bean.News;
import dao.mapper.NewsMapper;
import dao.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class NewsDaoImp implements NewsDao {

	public List<News> queryAll() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		NewsMapper mapper = sqlSession.getMapper(NewsMapper.class);
		return mapper.queryAllNews();
	}
}
