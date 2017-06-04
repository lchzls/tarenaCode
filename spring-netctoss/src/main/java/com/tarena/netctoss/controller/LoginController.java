package com.tarena.netctoss.controller;



import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tarena.netctoss.dao.AdminDAO;
import com.tarena.netctoss.dao.CostDAO;
import com.tarena.netctoss.entity.Admin;
import com.tarena.netctoss.entity.Cost;
import com.tarena.netctoss.util.ImageUtil;



@Controller
public class LoginController {

	@Resource(name="adminDAO")
	private AdminDAO adminDAO ;
	
	@Resource(name="costDAO")
	private CostDAO costDAO;
	
	@RequestMapping("/createImg.do")
	//生成一张验证码图片
	public void checkcode(HttpServletRequest req, HttpServletResponse res) 
			throws IOException{
		System.out.println("验证码");
		        //生成验证码及图片
				Object[] objs = ImageUtil.createImage();
				//将验证码存入session
				String imgCode = (String)objs[0];
				HttpSession session = req.getSession();
				session.setAttribute("imgcode", imgCode);
				//将图片输出给浏览器
				BufferedImage img = (BufferedImage) objs[1];
				res.setContentType("image/png");
				//目标就是本次访问的那个浏览器
				OutputStream os = res.getOutputStream();
				ImageIO.write(img, "png", os);
				os.close();
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String checkLogin(HttpServletRequest request,HttpSession session){
		System.out.println("checkLogin()");
		//读取账号密码
		String adminCode = request.getParameter("adminCode");
		String pwd = request.getParameter("pwd");
		System.out.println("adminCode:"+adminCode+"pwd:"+pwd);
		String code = request.getParameter("code");
		
		String imgcode  = (String) session.getAttribute("imgcode");
		System.out.println("imgcode="+imgcode+",code="+code);
		if(code==null||code.equals("")||!code.equalsIgnoreCase(imgcode)){
			
			request.setAttribute("error", "验证码错误");
			//验证错误，转发会登录页，给予提示
			return "login";
		}
		
		try{
			Admin admin = adminDAO.findByAdminCode(adminCode);
			if(admin!=null&&admin.getPassword().equals(pwd)){
				//登录成功，绑定一些数据到session
				session.setAttribute("admin", admin);
				//登录成功，重定向到主页
				return "redirect:toIndex.do";
			}else{
				//登录失败，提示用户
				request.setAttribute("login_error", "账号或密码错误");
				return "login";
				
			}
		}catch(Exception e){
			e.printStackTrace();
			//发生了系统异常，提示用户稍后重试(有可能是数据库在更新，管理员把数据库暂时关闭了，导致连接错误）
			return "error";
		}
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping("/findCost.do")  
	public String findCost(HttpServletRequest req){
		
		try{
			List<Cost> cost = costDAO.findAll();
			req.setAttribute("costs", cost);
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "find";
	}
	
	
}
