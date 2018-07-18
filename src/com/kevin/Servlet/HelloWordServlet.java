package com.kevin.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWordServlet extends HttpServlet{
/**
 * 1.先调用init service
 */
	public HelloWordServlet(){
		
	}

@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	System.out.println("service方法正在执行");
	//1.读取客户端发送
	String name = request.getParameter("name");
	
	//2.处理请求
	String result = "<span style='color:red;font-size:30px;'>"+"hello"+name+"</sapn>";
	//3.设置响应
	//生成消息头告诉浏览器,返回的数据类型
	response.setContentType("text/html;charset=utf-8");
	//获得一个输出流
	PrintWriter out = response.getWriter();
	//输出数据,将处理后的结果存放在respon对象上
	out.print(result);
	//关闭流
	out.close();
}
	//http://localhost:8080/Day3/sayHello?name=xiaoming
}
