package com.fixitytech.EcomSite;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fixitytech.EcomSite.DAO.OrderDAO;

/**
 * Servlet implementation class OrderState
 */
@WebServlet("/orderstate")
public class OrderState extends HttpServlet {
	OrderDAO orderDAO;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderState() {
        super();
        orderDAO=new OrderDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int status=Integer.parseInt(request.getParameter("status"));
		List<Orders> orderstate=orderDAO.getOrders(status);
		request.setAttribute("ordst", orderstate);
		RequestDispatcher rd = request.getRequestDispatcher("orderstate.jsp");
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
