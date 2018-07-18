package com.kevin.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//与前段保持一致是utf-8
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String id = request.getParameter("id");
		System.out.println("name"+name);
		System.out.println("age"+age);
		
		//访问数据库
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01","root","123");
			//创建执行器
			PreparedStatement prep = conn.prepareStatement("insert into emp(id,name,age) values(?,?,?)");
			prep.setString(1, id);
			prep.setString(2, name);
			prep.setInt(3, age);
			prep.executeUpdate();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("添加成功");
			
			out.println("<a href='update.jsp'>修改数据</a>");
			out.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
