package com.fixitytech.EcomSite;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.EcomSite.DAO.OrderDAO;

/**
 * Servlet implementation class AcceptOrderServlet
 */
@WebServlet("/changeStatus")
public class ChanageOrderStausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderDAO orderdao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChanageOrderStausServlet() {
        super();
        orderdao=new OrderDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status=request.getParameter("status");
		int oid=Integer.parseInt(request.getParameter("oid"));
		if(status.equals("accept"))
			orderdao.changeStatus(oid,1);
		else
			orderdao.changeStatus(oid,-1);
		
		response.sendRedirect("admin");
	
		//orderdao.acceptorders(orderid);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
