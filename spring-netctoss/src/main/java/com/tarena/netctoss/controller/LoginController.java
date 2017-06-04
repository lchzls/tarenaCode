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
	//����һ����֤��ͼƬ
	public void checkcode(HttpServletRequest req, HttpServletResponse res) 
			throws IOException{
		System.out.println("��֤��");
		        //������֤�뼰ͼƬ
				Object[] objs = ImageUtil.createImage();
				//����֤�����session
				String imgCode = (String)objs[0];
				HttpSession session = req.getSession();
				session.setAttribute("imgcode", imgCode);
				//��ͼƬ����������
				BufferedImage img = (BufferedImage) objs[1];
				res.setContentType("image/png");
				//Ŀ����Ǳ��η��ʵ��Ǹ������
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
		//��ȡ�˺�����
		String adminCode = request.getParameter("adminCode");
		String pwd = request.getParameter("pwd");
		System.out.println("adminCode:"+adminCode+"pwd:"+pwd);
		String code = request.getParameter("code");
		
		String imgcode  = (String) session.getAttribute("imgcode");
		System.out.println("imgcode="+imgcode+",code="+code);
		if(code==null||code.equals("")||!code.equalsIgnoreCase(imgcode)){
			
			request.setAttribute("error", "��֤�����");
			//��֤����ת�����¼ҳ��������ʾ
			return "login";
		}
		
		try{
			Admin admin = adminDAO.findByAdminCode(adminCode);
			if(admin!=null&&admin.getPassword().equals(pwd)){
				//��¼�ɹ�����һЩ���ݵ�session
				session.setAttribute("admin", admin);
				//��¼�ɹ����ض�����ҳ
				return "redirect:toIndex.do";
			}else{
				//��¼ʧ�ܣ���ʾ�û�
				request.setAttribute("login_error", "�˺Ż��������");
				return "login";
				
			}
		}catch(Exception e){
			e.printStackTrace();
			//������ϵͳ�쳣����ʾ�û��Ժ�����(�п��������ݿ��ڸ��£�����Ա�����ݿ���ʱ�ر��ˣ��������Ӵ���
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
