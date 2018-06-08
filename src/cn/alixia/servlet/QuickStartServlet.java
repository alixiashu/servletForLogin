package cn.alixia.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QuickStartServlet implements Servlet{
	
	/*
	 * 初始化
	 * 对象创建的时候执行
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
		System.out.println("Init running...");
		
	}
	/*
	 * 服务
	 * 每次访问的时候都会执行
	 * ServletRequest：请求；http请求内部封装的信息
	 * ServletResponse：响应：http响应要封装的信息(响应行+响应头+响应体)
	 */
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("QuickStartServlet running...");
		
	}
	/*
	 * 销毁
	 * 对象销毁的时候都会执行
	 */
	@Override
	public void destroy() {
		System.out.println("Destory running...");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
