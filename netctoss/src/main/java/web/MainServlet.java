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
		//获取请求路径
		String path = req.getServletPath();
		//根据规范处理路径
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
			throw new RuntimeException("查无此页");
		}
	}
	
	protected void createImg(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//生成验证码及图片
		Object[] objs = ImageUtil.createImage();
		//将验证码存入session
		String imgCode = (String)objs[0];
		HttpSession session = req.getSession();
		session.setAttribute("imgcode", imgCode);
		//将图片输出给浏览器
		BufferedImage img = (BufferedImage) objs[1];
		/*
		 * 打开Servers项目，打开web.xml,ctrl+f查找png，
		 * 则可以看到png文件对应的浏览器内容格式为image/png。这是类似，比如查找html，
		 * 则可以看到对应浏览器返回的浏览器页面格式为text/html
		 */
		res.setContentType("image/png");
		//目标就是本次访问的那个浏览器
		OutputStream os = res.getOutputStream();
		ImageIO.write(img, "png", os);
		os.close();
		
	}
	
	protected void logout(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//销毁session从而删除其内部数据
		req.getSession().invalidate();
		//重定向到登录
		res.sendRedirect("toLogin.do");
	}
	
	protected void deleteCost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		String id = req.getParameter("id");
		CostDao dao = new CostDao();
		dao.delete(new Integer(id));
		res.sendRedirect("findCost.do");
		
	}
	//登录：检查账号密码
	protected void login(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//接收表单数据
		String adminCode = req.getParameter("adminCode");
		String password = req.getParameter("password");
		String code = req.getParameter("code");
		HttpSession session = req.getSession();
		String imgcode  = (String) session.getAttribute("imgcode");
		System.out.println("imgcode="+imgcode+",code="+code);
		if(code==null||code.equals("")||!code.equalsIgnoreCase(imgcode)){
			
			req.setAttribute("error", "验证码错误");
			//账号错误，转发会登录页，给予提示
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
			return ; //直接返回了，后面的代码不执行了
		}

		//验证账号密码
		AdminDao dao = new AdminDao();
		Admin a = dao.findByCode(adminCode);
		if(a==null){
			req.setAttribute("error", "账号错误");
			//账号错误，转发会登录页，给予提示
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
		}else if(!a.getPassword().equals(password)){
			req.setAttribute("error", "密码错误");
			//密码错误，转发回登录页，给予提示
			req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
		}else{
			//将账号存入cookie(账号数据库有要求，不能为中文）
			Cookie c = new Cookie("adminCode",adminCode);
			res.addCookie(c);
            //也可以将账号存入session
			
			session.setAttribute("adminCode", adminCode);
			//验证通过，重定向到首页
			res.sendRedirect("toIndex.do");
		}
		
	}
	
	
	//打开登录页
	protected void toLogin(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/login.jsp").forward(req, res);
	}
	
	//打开首页
	protected void toIndex(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/main/index.jsp").forward(req, res);
	}
	
	//更新资费页面
	protected void updateCost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//接收保存的数据
		req.setCharacterEncoding("utf-8"); //处理中文乱码
		String costId = req.getParameter("costId");
		String name = req.getParameter("name");
		String costType = req.getParameter("costType");
		String baseDuration = req.getParameter("baseDuration");
		String baseCost = req.getParameter("baseCost");
		String unitCost = req.getParameter( "unitCost");
		String descr = req.getParameter( "descr");
		//封装然后保存这些数据
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
		//获取要修改的数据的id
		String id = req.getParameter("id");
		//查询要修改的数据
		CostDao dao = new CostDao();
		Cost cost = dao.findById(new Integer(id));
		//转发到jsp
		req.setAttribute("cost", cost);
		req.getRequestDispatcher("WEB-INF/cost/update.jsp").forward(req, res);
	}
	
	
	protected void addCost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//接收保存的数据
		req.setCharacterEncoding("utf-8"); //处理中文乱码
		String name = req.getParameter("name");
		String costType = req.getParameter("costType");
		String baseDuration = req.getParameter("baseDuration");
		String baseCost = req.getParameter("baseCost");
		String unitCost = req.getParameter( "unitCost");
		String descr = req.getParameter( "descr");
		//封装然后保存这些数据
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
		//重定向到查询
		//当前：/netctoss/addCost.do
		//目标:/netctoss/findCost.do
		res.sendRedirect("findCost.do");
		
	}
	
	//打开增加资费页面
	protected void toAddCost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//转发到jsp
		req.getRequestDispatcher("WEB-INF/cost/add.jsp").forward(req, res);
	}
	
	//查询资费
	protected void findCost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		//查询所有的资费
		CostDao dao = new CostDao();
		List<Cost> list = dao.findAll();
		//将其转发给JSP
		req.setAttribute("costs", list);
		//当前：/netctoss/findCost.do
		//目标：/netctoss/WEB-INF/cost/find.jsp
		req.getRequestDispatcher("WEB-INF/cost/find.jsp").forward(req, res);
		
	}
	
	
}
