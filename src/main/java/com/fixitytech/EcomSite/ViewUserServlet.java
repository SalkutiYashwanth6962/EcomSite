package com.fixitytech.EcomSite;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fixitytech.EcomSite.DAO.UserDAO;

/**
 * Servlet implementation class ViewUserServlet
 */
@WebServlet("/viewuser")
public class ViewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		  response.setContentType("image/jpg");
         // String id = request.getParameter("uid");
            UserDAO dao = new UserDAO();

            try {
               List<User> user= dao.getUsers1();

                request.setAttribute("ur", user);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewuser.jsp");
                requestDispatcher.forward(request, response);              
            } catch (SQLException ex) {
                throw new ServletException(ex);
            }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
