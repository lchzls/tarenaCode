package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Course;
import entity.Student;

public class FindServlet extends HttpServlet {
  
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//ģ��ѧ����ѯ
		Student stu = new Student();
		stu.setName("zhangsan");
		stu.setAge(23);
		stu.setSex("M");
		stu.setInterests(new String[]{"����","ƹ����"});
		Course c = new Course();
		c.setId(1);
		stu.setCourse(c);
	
       
		req.setAttribute("stu", stu);
		req.getRequestDispatcher("find.jsp").forward(req, res);
		

	}

	
	

}
