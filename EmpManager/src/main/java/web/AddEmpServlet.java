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
		//1.接收表单数据
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("ename");
		String job = req.getParameter("job");
		String sal = req.getParameter("sal");
		
		//2.保存这些数据
		Emp e = new Emp();
		e.setEname(name);
		e.setJob(job);
		//一定要记得对sal判断是否为空，否则一new就会报错
		//写代码要严谨一些
		if(sal!=null&&!sal.equals("")){
			e.setSal(new Double(sal));
		}
		//3.发送响应信息
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter out = res.getWriter();
//		out.println("<p>保存成功</p>");
//		out.close();
		
		//重定向到查询页面
		//重定向：一种特殊的跳转方式
		//当前路径：/EmpManager/addEmp
		//目标路径：/EmpManager/findEmp
		res.sendRedirect("findEmp");
	}
 
}
