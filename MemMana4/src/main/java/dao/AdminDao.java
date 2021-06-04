package dao;


import dao.bean.Admin;

public interface AdminDao {
	public Admin queryAdminByPassword(String pwd);
}
