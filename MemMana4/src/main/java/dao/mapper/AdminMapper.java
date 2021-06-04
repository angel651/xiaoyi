package dao.mapper;

import dao.bean.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
	//表admin里只有一条记录。其中，字段password值为字符串admin的md5值
	@Select("select * from admin where username='admin' and password=md5(#{pwd})")
	public Admin queryAdminByPassword(String pwd);
}

