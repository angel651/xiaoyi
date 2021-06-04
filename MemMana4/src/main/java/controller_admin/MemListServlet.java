package controller_admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.bean.Pager;
import dao.bean.User;
import dao.mapper.UserMapper;
import dao.utils.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MemListServlet")
public class MemListServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageSize=3; //设定每页记录数
		String parameter=req.getParameter("p"); //导航条传来的页码
		Integer page=(parameter!=null)?Integer.valueOf(parameter):1; //初始指定第1页

		PageHelper.startPage(page,pageSize);  //分页

		List<User> users = MyBatisUtil.getSqlSession().getMapper(UserMapper.class).getAllUsers();  //获取当前页记录
		for(User user:users){
			System.out.println(user);  //控制台输出测试
		}

		PageInfo<User> pageInfo = new PageInfo<User>(users);  //创建分页信息对象
		Pager pager = new Pager(pageInfo.getPages(),pageInfo.getTotal(),pageInfo.getPageSize(), page, req);
		req.setAttribute("pageNav", pager.getPageNav());  //转发记录导航
		req.setAttribute("users", users); // 转发记录

		// 设置属性delete减少了在MemDeleteServlet里创建List类型的列表数据的代码
		Object isDeleteFlag = req.getAttribute("delete");
		if (isDeleteFlag != null) {
			req.getRequestDispatcher("views/admin/memDelete.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("views/admin/memInfo.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
