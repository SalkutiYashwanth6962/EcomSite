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
import com.fixitytech.EcomSite.DAO.ItemDAO;
import com.google.gson.Gson;

/**
 * Servlet implementation class ItemServiceServlet
 */
@WebServlet("/items")
public class ItemServiceServlet extends HttpServlet {
	ItemDAO itemdao;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServiceServlet() {
        super();
        itemdao=new ItemDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    response.setContentType("application/json");
		List<Item> items=itemdao.getItems();
		PrintWriter out = response.getWriter();
		Gson gson=new Gson();
		String responseText = gson.toJson(items);
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
