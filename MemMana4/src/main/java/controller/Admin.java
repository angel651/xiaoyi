/*
 * 本程序处理后台管理员登录
 * 登录成功时，请求将重定向（而不是转发！）至后台主页admin/adminIndex.jsp
 */
package controller;

import dao.imp.AdminDaoImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
			String pw = req.getParameter("pwd");  //获取表单提交参数值
			if (pw.trim().length() > 0) { // 必须输入表单元素username的值才进行数据库查询
				dao.bean.Admin admin = new AdminDaoImp().queryAdminByPassword(pw);
				if (admin!=null) { //输入密码正确时
					System.out.println("登录成功");
					req.getSession().setAttribute("admin", "admin");  //会话跟踪
					resp.sendRedirect("views/admin/adminIndex.jsp");  //重定向至主控制器
				} else {  // 输入密码错误时
					req.setAttribute("msg", "密码错误!");
					req.getRequestDispatcher("views/adminLogin.jsp").forward(req, resp);
				}
			}
	}
}
