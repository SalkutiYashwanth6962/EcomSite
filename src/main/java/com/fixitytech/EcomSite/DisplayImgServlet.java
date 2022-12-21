package com.fixitytech.EcomSite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Servlet implementation class DisplayImgServlet+
 */
@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/display")
public class DisplayImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	        response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	            //fetch form data
	            
	            Part part = request.getPart("images");
	            String fileName = part.getSubmittedFileName();
	            
	            String path = getServletContext().getRealPath("/"+"images"+File.separator+fileName);
	            
	            InputStream is = part.getInputStream();
	            boolean test = uploadFile(is,path);
	            if(test){
	                out.println("uploaded");
	            }else{
	                out.println("something wrong");
	            }
	            
	           
	        }
	}
	  public boolean uploadFile(InputStream is, String path){
	        boolean test = false;
	        try{
	            byte[] byt = new byte[is.available()];
	            is.read();
	            
	            FileOutputStream fops = new FileOutputStream(path);
	            fops.write(byt);
	            fops.flush();
	            fops.close();
	            
	            test = true;
	            
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        
	        return test;
	    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}

