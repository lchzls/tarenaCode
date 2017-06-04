package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IdServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		String card = "430521199306117544";
		String year = card.substring(6,10);
		String month = card.substring(10,12);
		if(month.charAt(0)=='0'){
			month = month.substring(1);
		}
		String day = card.substring(12,14);
		out.print("<p>"+year+"Äê"+month+"ÔÂ"+day+"ÈÕ");
		out.close();
	}
 
}
