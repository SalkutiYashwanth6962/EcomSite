package com.fixitytech.EcomSite.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fixitytech.EcomSite.Item;
import com.fixitytech.EcomSite.Orders;
import com.fixitytech.EcomSite.DAO.OrderDAO;
import com.google.gson.Gson;

/**
 * Servlet implementation class OrderServiceServlet
 */
@WebServlet("/orders")
public class OrderServiceServlet extends HttpServlet {
	OrderDAO orderdao;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServiceServlet() {
        super();
        orderdao=new OrderDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 response.setContentType("application/json");
			List<Orders> orders=orderdao.getAllOrders();
			PrintWriter out = response.getWriter();
			Gson gson=new Gson();
			String responseText = gson.toJson(orders);
			out.write(responseText);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
