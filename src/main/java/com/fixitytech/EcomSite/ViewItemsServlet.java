package com.fixitytech.EcomSite;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.EcomSite.DAO.ItemDAO;

/**
 * Servlet implementation class ViewItemsServlet
 */
@WebServlet("/viewitems")
public class ViewItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		//HttpSession session=request.getSession();
		//request.getAttribute("prs");
		ItemDAO dao=new ItemDAO();
		 List<Item> items= dao.getItems();
		 String path=getServletContext().getRealPath("")+"/uploads/";
			for(Item item:items)
			{
				File file=new File(path+item.getId());
				String names[]=file.list();
				String name=names[0];
				item.setBase64Image("uploads/"+item.getId()+"/"+name);
			}
         request.setAttribute("it1", items);

		RequestDispatcher rd=request.getRequestDispatcher("viewitems.jsp");
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
