package com.fixtytech.EcomSite;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fixitytech.EcomSite.DAO.UserDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public LoginServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		
		String userName = request.getParameter("uname");
		String password = request.getParameter("upassword");
		String continue1 = request.getParameter("c");

		boolean b = new UserDAO().validate(userName, password);
		if (b) 
		{
			HttpSession hs = request.getSession();
			hs.setAttribute("uid", userName);
			if (continue1 != null && continue1.length() > 0)
				response.sendRedirect(continue1);
			else
				response.sendRedirect("Index");
				//response.sendRedirect("home");
		} else 
		{
			request.setAttribute("err", "Entered username or password are wrong.");
			doGet(request, response);

		}

	}

}
