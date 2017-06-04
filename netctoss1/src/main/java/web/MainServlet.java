package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CostDao;
import entity.Cost;

public class MainServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String path = req.getServletPath();
		if("/findCost.do".equals(path)){
			findCost(req,res);
		}else{
			throw new RuntimeException("≤ÈŒﬁ¥À“≥");
		}
		
	}

	protected void findCost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		CostDao dao = new CostDao();
		List<Cost> cost = dao.findAll();
		req.setAttribute("costs", cost);
		//  /netctoss/findCost.do   /netctoss/WEB-INF/cost/find.jsp
		req.getRequestDispatcher("WEB-INF/cost/find.jsp").forward(req, res);
	}
	
}
