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

public class DeleteEmpServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
		//获取数据
		        String id = request.getParameter("id");
				String name = request.getParameter("name");
				String age = request.getParameter("age");
				
		//连接数据
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01","root","123");
					PreparedStatement pre = conn.prepareStatement("delete from emp where id=?");
					pre.setString(1, id);
					pre.executeUpdate();
					response.setContentType("text/html,charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print("删除成功");
					out.println("<a href='show'>查删除完成数据</a>");
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
