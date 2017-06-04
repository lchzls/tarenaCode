package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class MainServlet extends HttpServlet {

	/*
	 * ·���淶��
	 * ��ѯԱ����/findEmp.do
	 * ����Ա����/addEmp.do
	 * */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//��ȡ����·��
		String path = req.getServletPath();
		//���ݹ淶������Щ·��
		if("/findEmp.do".equals(path)){
			//��ѯԱ��
			findEmp(req,res);
		}else if("/addEmp.do".equals(path)){
			//����Ա��
			addEmp(req,res);
		}else{
			throw new RuntimeException("���޴�ҳ");
		}
	}
	protected void findEmp(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//1.�����������
				//��ǰҵ��û�в�����Ҫ����
				//2.ʹ�ò�������ҵ��(��ѯ)
				EmpDao dao = new EmpDao();
				List<Emp> list = dao.findAll();
				//3.�����Ӧ��Ϣ
				res.setContentType(
					"text/html;charset=gbk");
				PrintWriter out = res.getWriter();
				//�ڴ˿���ģʽ��дCSS̫�鷳�ˣ�
				//����дԪ�ص����Դ��档
				//th�������td���Դ��˾��С��Ӵֵ�Ч����
				out.println("<a href='add_emp.html'>����</a>");
				out.println("<table width='40%' border='1' cellspacing='0'>");
				out.println("  <tr>");
				out.println("    <th>���</th>");
				out.println("    <th>����</th>");
				out.println("    <th>ְλ</th>");
				out.println("    <th>н��</th>");
				out.println("  </tr>");
				if(list != null) {
					for(Emp e : list) {
						out.println("<tr>");
						out.println("  <td>"+e.getEmpno()+"</td>");
						out.println("  <td>"+e.getEname()+"</td>");
						out.println("  <td>"+e.getJob()+"</td>");
						out.println("  <td>"+e.getSal()+"</td>");
						out.println("</tr>");
					}
				}
				out.println("</table>");
	}
	protected void addEmp(HttpServletRequest req, HttpServletResponse res) 
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
//				res.setContentType("text/html;charset=utf-8");
//				PrintWriter out = res.getWriter();
//				out.println("<p>����ɹ�</p>");
//				out.close();
				
				//�ض��򵽲�ѯҳ��
				//�ض���һ���������ת��ʽ
				//��ǰ·����/EmpManager/addEmp
				//Ŀ��·����/EmpManager/findEmp
				res.sendRedirect("findEmp.do");
	}
}
