package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletFoo extends HttpServlet {

   public void doGet(HttpServletRequest request,HttpServletResponse response) 
		   throws ServletException,IOException{ 
	   System.out.println("get");
	   } 
   public void doPost(HttpServletRequest request,HttpServletResponse response) 
		   throws ServletException,IOException{
	   System.out.println("post"); 
		   doGet(request,response);
		   }

}
