package com.fixitytech.EcomSite;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fixitytech.EcomSite.DAO.ItemDAO;


 


 

/**
* Servlet implementation class UploadItemServlet
*/
@WebServlet("/uploadFolder")
@MultipartConfig(maxFileSize = 16177215)
public class UploadFolderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       ItemDAO itemdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFolderServlet() {
        super();
        itemdao =new ItemDAO();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        RequestDispatcher rd=request.getRequestDispatcher("additem.jsp");
        rd.forward(request, response);
    }

 

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    private static final String UPLOAD_DIR = "uploads";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
       int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        //InputStream inputStream = null; // input stream of the upload file
        Part filePart = request.getPart("photo");
   
        String path=getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
        
        System.out.println(path);
        
        File d=new File(path+"/"+id);
        if(!d.exists())
        	d.mkdir();
        System.out.println(d);
        
        filePart.write(path+"/"+id+"/"+filePart.getSubmittedFileName());
        
        ItemDAO dao=new ItemDAO();
        dao.addItem(id, name, price);
    }
}
        
      
