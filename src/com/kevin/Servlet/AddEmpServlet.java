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
		//��ǰ�α���һ����utf-8
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String id = request.getParameter("id");
		System.out.println("name"+name);
		System.out.println("age"+age);
		
		//�������ݿ�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo01","root","123");
			//����ִ����
			PreparedStatement prep = conn.prepareStatement("insert into emp(id,name,age) values(?,?,?)");
			prep.setString(1, id);
			prep.setString(2, name);
			prep.setInt(3, age);
			prep.executeUpdate();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("��ӳɹ�");
			
			out.println("<a href='update.jsp'>�޸�����</a>");
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
