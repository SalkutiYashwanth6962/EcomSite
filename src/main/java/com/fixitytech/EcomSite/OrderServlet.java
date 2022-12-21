package com.fixitytech.EcomSite;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.EcomSite.DAO.OrderDAO;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		  HttpSession hp=request.getSession();
	       
	        List<CartItem> cart=(List) hp.getAttribute("cart");
	                   
	        String uid=(String)hp.getAttribute("uid");
	        
	        Orders order=new Orders();
	        
	        double payment=0;
	        
	        
	        List<OrderItem> orderItems=new Vector<OrderItem>();
	        for(CartItem cartItem:cart)
	        {    
	            orderItems.add(new OrderItem(cartItem));
	        payment+=cartItem.getTotalAmount();
	            
	        }
	        
	        order.setOrderItems(orderItems);
	        order.setTotalamount(payment);
	        order.setCustomerId(uid);
	        int orderId =OrderDAO.saveOrder(order);
	            // HttpSession hs1= request.getSession();
	             //request.setAttribute("oid", orderId);      
	        if(orderId!=-1)
	        {
	            
	            request.setAttribute("message", "Order placed Successfully With order id "+orderId);
	        }
	        else 
	            request.setAttribute("message", "Order failed");
	        
	        RequestDispatcher rd=request.getRequestDispatcher("orderStatus.jsp");
	        rd.forward(request, response);
	        
	            

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
/*package com.fixity.Ecom.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.fixity.Ecom.DAO.ItemDAO;
import com.fixity.Ecom.DAO.OrderDAO;
import com.fixity.Ecom.Object.CartITem;
import com.fixity.Ecom.Object.Item;
import com.fixity.Ecom.Object.OrderITem;
import com.fixity.Ecom.Object.Orders;




// Servlet implementation class OrderServlet
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   


   /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
  



//}*/