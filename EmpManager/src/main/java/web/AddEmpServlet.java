package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Emp;

public class AddEmpServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//1.���ձ�����
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("ename");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		
		//2.������Щ����
		Emp e = new Emp();
		e.setEname(name);
		e.setJob(job);
		//һ��Ҫ�ǵö�sal�ж��Ƿ�Ϊ�գ�����һnew�ͻᱨ��
		//д����Ҫ�Ͻ�һЩ
		if(sal!=null&&!sal.equals("")){
			e.setSal(new Double(sal));
		}
		//3.������Ӧ��Ϣ
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter out = res.getWriter();
//		out.println("<p>����ɹ�</p>");
//		out.close();
		
		//�ض��򵽲�ѯҳ��
		//�ض���һ���������ת��ʽ
		//��ǰ·����/EmpManager/addEmp
		//Ŀ��·����/EmpManager/findEmp
		res.sendRedirect("findEmp");
	}
 
}
