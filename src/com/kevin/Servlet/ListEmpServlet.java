package com.kevin.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListEmpServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01", "root", "123");
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery("select * from emp");
		    
		    response.setContentType("text/html;charset=utf-8");
		    PrintWriter out = response.getWriter();
		    out.println("<table border='1' width=60% cellpadding='0' cellspacing='0'>");
		    out.println("<tr><td>id</td>"+"<td>name</td>"+"<td>age</td>"+"<td style='text-align:center;'>姓名</td></tr>");
		    while(rs.next()){
		    	String id = rs.getString("id");
		    	String name = rs.getString("name");
		    	String age = rs.getString("age");
		    	out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>&nbsp&nbsp&nbsp<a href='dele?id="+id+"'>"+"删除</a>&nbsp&nbsp&nbsp<a href='addEmp.jsp'>"+"添加</a>&nbsp&nbsp&nbsp<a href='update.jsp'>"+"修改</a></td>"+"</tr>");
		    }
		    out.println("</table>");
		    out.println("<a href='addEmp.jsp'>添加新员工</a>");
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
