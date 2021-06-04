package dao.mapper;
/*
 * 定义DAO接口，未写实现类（不同于Service层）
 * DAO层实现是由Mybatis框架自动建立接口方法与SQL id之间的映射完成的
 */

import dao.bean.News;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsMapper {
	
	@Select("select * from news") /* 查找所有新闻记录 */
	public List<News> queryAllNews();
}
