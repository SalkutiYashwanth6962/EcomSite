package com.fixitytech.EcomSite;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.fixitytech.EcomSite.DAO.UserDAO;
import com.mysql.cj.jdbc.Blob;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
@MultipartConfig(maxFileSize = 16177215)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        dao = new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("register1.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("uname");
		String password=request.getParameter("upassword");
		String email=request.getParameter("uemail");
		String mobileno=request.getParameter("ucontact");
		byte[] byteArray=null;
		//file related code
		 InputStream inputStream = null; // input stream of the upload file
         
	        // obtains the upload file part in this multipart request
	        Part filePart = request.getPart("photo");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	            // Taking the InputStream data into a byte array
	            // output stream
	      
	            // Buffer size taken to be 1000 say.
	            byte[] buffer = new byte[1000];
	      
	            // Creating an object of ByteArrayOutputStream class
	            ByteArrayOutputStream byteArrayOutputStream
	                = new ByteArrayOutputStream();
	      
	            // Try block to check for exceptions
	            try {
	                int temp;
	      
	                while ((temp = inputStream.read(buffer))
	                       != -1) {
	                    byteArrayOutputStream.write(buffer, 0,
	                                                temp);
	                }
	            }
	      
	            // Catch block to handle the exceptions
	            catch (IOException e) {
	      
	                // Display the exception/s on the console
	                System.out.println(e);
	            }
	      
	            // Mow converting byte array output stream to byte
	            // array
	            byteArray
	                = byteArrayOutputStream.toByteArray();
	      
	        }
	       //Blob blob =
		//total data must be converted into one object
		//now we are getting user data from request object from that we are creating  object.
		//user object data must be converted into 1 row in table
		//user object  purpose we need to create Dao class for db integration
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setContactNo(mobileno);
		user.setPhoto(byteArray);
		
		boolean b = dao.save(user);
		if(b) {
			HttpSession hs = request.getSession();
			hs.setAttribute("uid", userName);
			response.sendRedirect("home");
		}else {
			request.setAttribute("err", "Something went wrong.");
			doGet(request, response);	
		}
		
	}

}
