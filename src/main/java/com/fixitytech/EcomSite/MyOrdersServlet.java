package com.fixitytech.EcomSite;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.EcomSite.DAO.OrderDAO;

/**
 * Servlet implementation class MyOrdersServlet
 */
@WebServlet("/myorders")
public class MyOrdersServlet extends HttpServlet {
	OrderDAO orderDAO ;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyOrdersServlet() {
    	super();
    	orderDAO= new OrderDAO();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession hs = request.getSession();
		String userName=(String)hs.getAttribute("uid");
		List<Orders> ordersdetails=orderDAO.getAllOrders(userName);
		request.setAttribute("ords", ordersdetails);
		RequestDispatcher rd = request.getRequestDispatcher("myorders.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
