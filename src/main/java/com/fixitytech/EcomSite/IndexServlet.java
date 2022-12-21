package com.fixitytech.EcomSite;
import java.io.File;
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
import com.fixitytech.EcomSite.DAO.ItemDAO;



@WebServlet("/Index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	ItemDAO itemDAO;
    public IndexServlet() 
    {
        super();
        itemDAO = new ItemDAO();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//if()
		 HttpSession hs = request.getSession();
		List<CartItem> cart =(List)hs.getAttribute("cart");
		
		if(cart==null) 
			cart = new Vector<CartItem>();
		hs.setAttribute("cart", cart);  
		List<Item> products = itemDAO.getItems();

		String path=getServletContext().getRealPath("")+"/uploads/";
		for(Item item:products)
		{
			File file=new File(path+item.getId());
			String names[]=file.list();
			String name=names[0];
			item.setBase64Image("uploads/"+item.getId()+"/"+name);
		}
		
		request.setAttribute("prs", products);//forwarding to view page
        
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		//Here we are forwarding our request to the next page
	}

	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
