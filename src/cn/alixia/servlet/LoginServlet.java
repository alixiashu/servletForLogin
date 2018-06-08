package cn.alixia.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.alixia.domain.User;
import cn.alixia.utils.DataSourceUtils;

public class LoginServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		//初始化登录人数count = 0
		this.getServletContext().setAttribute("count", 0);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1、获得用户名密码
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//2、数据库校验
			QueryRunner query = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select * from user where username=? and password=?";
			User user = null;
			user = query.query(sql, new BeanHandler<User>(User.class), username,password);
			if(user != null) {
				ServletContext context = this.getServletContext();
				int count = (int) context.getAttribute("count");
				count++;
				response.getWriter().write(user.toString() + ": you are the " + count + "th visiter!");
				context.setAttribute("count", count);
			}	
			else
				//用户登录失败
				response.getWriter().write("The name or password is Wrong!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3、根据数据库结果显示结果
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}