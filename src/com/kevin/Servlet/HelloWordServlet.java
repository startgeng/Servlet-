package com.kevin.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWordServlet extends HttpServlet{
/**
 * 1.�ȵ���init service
 */
	public HelloWordServlet(){
		
	}

@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	System.out.println("service��������ִ��");
	//1.��ȡ�ͻ��˷���
	String name = request.getParameter("name");
	
	//2.��������
	String result = "<span style='color:red;font-size:30px;'>"+"hello"+name+"</sapn>";
	//3.������Ӧ
	//������Ϣͷ���������,���ص���������
	response.setContentType("text/html;charset=utf-8");
	//���һ�������
	PrintWriter out = response.getWriter();
	//�������,�������Ľ�������respon������
	out.print(result);
	//�ر���
	out.close();
}
	//http://localhost:8080/Day3/sayHello?name=xiaoming
}
