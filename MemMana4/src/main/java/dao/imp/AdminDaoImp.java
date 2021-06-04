package dao.imp;

import dao.AdminDao;
import dao.bean.Admin;
import dao.mapper.AdminMapper;
import dao.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class AdminDaoImp implements AdminDao {
	public Admin queryAdminByPassword(String pwd) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
		return mapper.queryAdminByPassword(pwd);
	}


}
