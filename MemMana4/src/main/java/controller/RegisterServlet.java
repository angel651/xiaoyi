package controller;

import dao.bean.User;
import dao.imp.UserDaoImp;
import service.imp.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = new User();
		req.setCharacterEncoding("utf8");  //按照utf-8编码格式接受数据
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		
		if("".equals(user.getUsername().trim()) || "".equals(user.getPassword().trim())){  //防止空提交
			req.setAttribute("message", "用户名和密码不能为空!");
			req.getRequestDispatcher("views/public/message.jsp").forward(req, resp);
		}else{
			UserDaoImp userDaoImp = new UserDaoImp();
			User user1 = userDaoImp.queryUserByUsername(user.getUsername());
			if(user1!=null){   //rs!=null
				req.setAttribute("message", "该用户名已经存在!");
				req.getRequestDispatcher("views/public/message.jsp").forward(req, resp);
			}else{
				user.setRealname(req.getParameter("realname"));
				user.setMobile(req.getParameter("mobile"));
				String age = req.getParameter("age");
				if(!"".equals(age.trim())){
					user.setAge(Integer.valueOf(age));  //类型转型：String
				}
				userDaoImp.addUser(user);  //保存实体类对象（记录）
				System.out.println(user);
				req.setAttribute("message","注册成功！"); //参数设置
				req.getRequestDispatcher("views/public/message.jsp").forward(req, resp);  //转向控制
			}
		}
	}
}
