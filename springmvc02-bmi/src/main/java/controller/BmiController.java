package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BmiController {

	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "bmi";
	}
	
	@RequestMapping("/login1.do")
	public String login1(HttpServletRequest req){
		double weight = Double.parseDouble(req.getParameter("weight"));
		double height = Double.parseDouble(req.getParameter("height"));
		double result = weight/height/height;
		if(result<19){
			req.setAttribute("message", "过轻");
		}else if(result>25){
			req.setAttribute("message", "过重");
		}else{
			req.setAttribute("message", "正常");
		}
		return "view";
		
	}
	
	
	@RequestMapping("/login2.do")
	public String login2(String weight,String height,HttpSession session){
		double w = Double.parseDouble(weight);
		double h = Double.parseDouble(height);
		double result = w/h/h;
		if(result<19){
			session.setAttribute("message", "过轻");
		}else if(result>25){
			session.setAttribute("message", "过重");
		}else{
			session.setAttribute("message", "正常");
		}
		return "view";
	}
	
	@RequestMapping("/login3.do")
	public String login3(BmiParam bp,ModelMap mm){
		double w = bp.getWeight();
		double h = bp.getHeight();
		double result = w/h/h;
		if(result<19){
			mm.addAttribute("message","过轻");
		}else if(result>25){
			mm.addAttribute("message","过重");
		}else{
			mm.addAttribute("message","正常");
		}
		return "view";
		
	}
	
	@RequestMapping("/login4.do")
	public ModelAndView login4(BmiParam bp){
		double w = bp.getWeight();
		double h = bp.getHeight();
		double result = w/h/h;
		Map<String,Object> data = new HashMap<String,Object>();
		if(result<19){
			data.put("message","过轻");
		}else if(result>25){
			data.put("message","过重");
		}else{
			data.put("message","正常");
		}
		ModelAndView mm = new ModelAndView("view",data);
		return mm;
		
	}
	
}
