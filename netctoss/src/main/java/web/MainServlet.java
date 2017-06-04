package web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.CostDao;
import entity.Admin;
import entity.Cost;
import util.ImageUtil;

public class MainServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//��ȡ����·��
		String path = req.getServletPath();
		//���ݹ淶����·��
		if("/findCost.do".equals(path)){
			findCost(req,res);
		}else if("/toAddCost.do".equals(path)){
			toAddCost(req,res);
		}else if("/addCost.do".equals(path)){
			addCost(req,res);
		}else if("/toUpdateCost.do".equals(path)){
			toUpdateCost(req,res);
		}else if("/updateCost.do".equals(path)){
			updateCost(req,res);
		}else if("/deleteCost.do".equals(path)){
			deleteCost(req,res);
		}else if("/toLogin.do".equals(path)){
			toLogin(req,res);
		}else if("/toIndex.do".equals(path)){
			toIndex(req,res);
		}else if("/login.do".equals(path)){
			login(req,res);
		}else if("/logout.do".equals(path)){
			logout(req,res);
		}else if("/createImg.do".equals(path)){
			createImg(req,res);
		}else{
			throw new RuntimeException("���޴�ҳ");
		}
	}
	
	protected void createImg(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//������֤�뼰ͼƬ
		Object[] objs = ImageUtil.createImage();
		//����֤�����session
		String imgCode = (String)objs[0];
		HttpSession session = req.getSession();
		session.setAttribute("imgcode", imgCode);
		//��ͼƬ����������
		BufferedImage img = (BufferedImage) objs[1];
		/*
		 * ��Servers��Ŀ����web.xml,ctrl+f����png��
		 * ����Կ���png�ļ���Ӧ����������ݸ�ʽΪimage/png���������ƣ��������html��
		 * ����Կ�����Ӧ��������ص������ҳ���ʽΪtext/html
		 */
		res.setContentType("image/png");
		//Ŀ����Ǳ��η��ʵ��Ǹ������
		OutputStream os = res.getOutputStream();
		ImageIO.write(img, "png", os);
		os.close();
		
	}
	
	protected void logout(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//����session�Ӷ�ɾ�����ڲ�����
		req.getSession().invalidate();
		//�ض��򵽵�¼
		res.sendRedirect("toLogin.do");
	}
	
	protected void deleteCost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		String id = req.getParameter("id");
		CostDao dao = new CostDao();
		dao.delete(new Integer(id));
		res.sendRedirect("findCost.do");
		
	}
	//��¼������˺�����
	protected void login(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//���ձ�����
		String adminCode = req.getParameter("adminCode");
		String password = req.getParameter("password");
		String code = req.getParameter("code");
		HttpSession session = req.getSession();
		String imgcode  = (String) session.getAttribute("imgcode");
		System.out.println("imgcode="+imgcode+",code="+code);
		if(code==null||code.equals("")||!code.equalsIgnoreCase(imgcode)){
			
			req.setAttribute("error", "��֤�����");
			//�˺Ŵ���ת�����¼ҳ��������ʾ
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			return ; //ֱ�ӷ����ˣ�����Ĵ��벻ִ����
		}

		//��֤�˺�����
		AdminDao dao = new AdminDao();
		Admin a = dao.findByCode(adminCode);
		if(a==null){
			req.setAttribute("error", "�˺Ŵ���");
			//�˺Ŵ���ת�����¼ҳ��������ʾ
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
		}else if(!a.getPassword().equals(password)){
			req.setAttribute("error", "�������");
			//�������ת���ص�¼ҳ��������ʾ
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
		}else{
			//���˺Ŵ���cookie(�˺����ݿ���Ҫ�󣬲���Ϊ���ģ�
			Cookie c = new Cookie("adminCode",adminCode);
			res.addCookie(c);
            //Ҳ���Խ��˺Ŵ���session
			
			session.setAttribute("adminCode", adminCode);
			//��֤ͨ�����ض�����ҳ
			res.sendRedirect("toIndex.do");
		}
		
	}
	
	
	//�򿪵�¼ҳ
	protected void toLogin(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
	}
	
	//����ҳ
	protected void toIndex(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/index.jsp").forward(req, res);
	}
	
	//�����ʷ�ҳ��
	protected void updateCost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//���ձ��������
		req.setCharacterEncoding("utf-8"); //������������
		String costId = req.getParameter("costId");
		String name = req.getParameter("name");
		String costType = req.getParameter("costType");
		String baseDuration = req.getParameter("baseDuration");
		String baseCost = req.getParameter("baseCost");
		String unitCost = req.getParameter( "unitCost");
		String descr = req.getParameter( "descr");
		//��װȻ�󱣴���Щ����
		Cost c = new Cost();
		c.setCostId(new Integer(costId));
		c.setName(name);
		c.setCostType(costType);
		c.setDescr(descr);
		if(baseDuration!=null&&!baseDuration.equals("")){
			c.setBaseDuration(new Integer(baseDuration));
		}
		if(baseCost!=null&&!baseCost.equals("")){
			c.setBaseCost(new Double(baseCost));
		}
		if(unitCost!=null&&!unitCost.equals("")){
			c.setUnitCost(new Double(unitCost));
		}
		CostDao dao = new CostDao();
		dao.update(c);
		res.sendRedirect("findCost.do");
	}

	protected void toUpdateCost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//��ȡҪ�޸ĵ����ݵ�id
		String id = req.getParameter("id");
		//��ѯҪ�޸ĵ�����
		CostDao dao = new CostDao();
		Cost cost = dao.findById(new Integer(id));
		//ת����jsp
		req.setAttribute("cost", cost);
		req.getRequestDispatcher("WEB-INF/cost/update.jsp").forward(req, res);
	}
	
	
	protected void addCost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//���ձ��������
		req.setCharacterEncoding("utf-8"); //������������
		String name = req.getParameter("name");
		String costType = req.getParameter("costType");
		String baseDuration = req.getParameter("baseDuration");
		String baseCost = req.getParameter("baseCost");
		String unitCost = req.getParameter( "unitCost");
		String descr = req.getParameter( "descr");
		//��װȻ�󱣴���Щ����
		Cost c = new Cost();
		c.setName(name);
		c.setCostType(costType);
		c.setDescr(descr);
		if(baseDuration!=null&&!baseDuration.equals("")){
			c.setBaseDuration(new Integer(baseDuration));
		}
		if(baseCost!=null&&!baseCost.equals("")){
			c.setBaseCost(new Double(baseCost));
		}
		if(unitCost!=null&&!unitCost.equals("")){
			c.setUnitCost(new Double(unitCost));
		}
		CostDao dao = new CostDao();
		dao.save(c);
		//�ض��򵽲�ѯ
		//��ǰ��/netctoss/addCost.do
		//Ŀ��:/netctoss/findCost.do
		res.sendRedirect("findCost.do");
		
	}
	
	//�������ʷ�ҳ��
	protected void toAddCost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//ת����jsp
		req.getRequestDispatcher("WEB-INF/cost/add.jsp").forward(req, res);
	}
	
	//��ѯ�ʷ�
	protected void findCost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//��ѯ���е��ʷ�
		CostDao dao = new CostDao();
		List<Cost> list = dao.findAll();
		//����ת����JSP
		req.setAttribute("costs", list);
		//��ǰ��/netctoss/findCost.do
		//Ŀ�꣺/netctoss/WEB-INF/cost/find.jsp
		req.getRequestDispatcher("WEB-INF/cost/find.jsp").forward(req, res);
		
	}
	
	
}
