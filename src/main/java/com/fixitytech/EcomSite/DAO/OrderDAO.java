package com.fixitytech.EcomSite.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import com.fixitytech.EcomSite.DBConnection;
import com.fixitytech.EcomSite.OrderItem;
import com.fixitytech.EcomSite.Orders;

public class OrderDAO {
    
    public static int saveOrder(Orders o)
    {
        
        Connection con=DBConnection.getConnection();
        
        try
        {
            con.setAutoCommit(false);
            PreparedStatement ps=con.prepareStatement("insert into VOrder(totalamount,customerId)values (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setDouble(1,o.getTotalamount());
            ps.setString(2,o.getCustomerId());
        int n=ps.executeUpdate();
            if(n>0)
            {
            ResultSet rs=ps.getGeneratedKeys();
            rs.next();
            
            int orderId=rs.getInt(1);
            // HttpSession session = request.getSession();
             //request.setAttribute("orderid1",orderId);

           
            PreparedStatement pst=con.prepareStatement("insert into VOrderedItem(itemid,itemname,itemprice,itemquant,orderId)values (?,?,?,?,?)");
            
            for(OrderItem orderItem:o.getOrderItems())
            {
                pst.setInt(1, orderItem.getId());
                pst.setString(2, orderItem.getName());
                pst.setDouble(3, orderItem.getPrice());
                pst.setInt(4, orderItem.getQuantity());
                pst.setInt(5, orderId);
                
                pst.executeUpdate();
            }
            
            con.commit();
            return orderId;
            
            
            
            }    
            }
        catch(Exception e)
        {



           try {
                con.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            e.printStackTrace();
        }
        
        return  -1;
    }
    public List<Orders> getAllOrders(String userName) {
		List<Orders> orderList = new ArrayList<Orders>();
		
		Connection con = DBConnection.getConnection();
		try {
			
			PreparedStatement ps  = con.prepareStatement("select * from vorder where customerId=?");
			PreparedStatement pst1=con.prepareStatement("select * from vordereditem where orderId=?");
			ps.setString(1, userName);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				Orders order = new Orders();
				order.setOrderid(rs.getInt("orderid"));
				order.setTotalamount(rs.getDouble("totalamount"));
				order.setCustomerId(rs.getString("customerId"));
				pst1.setInt(1,order.getOrderid());
				ResultSet rs1=pst1.executeQuery();
				List<OrderItem> oitems=new Vector<OrderItem>();
				while(rs1.next()) {
					OrderItem orderItem=new OrderItem();
					orderItem.setId(rs1.getInt(2));
					orderItem.setName(rs1.getString(3));
					orderItem.setPrice(rs1.getDouble(4));
					orderItem.setQuantity(rs1.getInt(5));
					oitems.add(orderItem);
				}
				order.setOrderItems(oitems);
				orderList.add(order);

			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return orderList;
	}
    public List<Orders> getAllOrders() {
		List<Orders> orderList1 = new ArrayList<Orders>();
		
		Connection con = DBConnection.getConnection();
		try {
			
			PreparedStatement ps  = con.prepareStatement("select * from vorder ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				Orders order = new Orders();
				order.setOrderid(rs.getInt("orderid"));
				order.setTotalamount(rs.getDouble("totalamount"));
				order.setCustomerId(rs.getString("customerId"));
				
				orderList1.add(order);

			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return orderList1;
	}

    
    public List<Orders> getOrders(int status){
    	{	
    		List<Orders> orders=new Vector<Orders>();
    		Connection con = DBConnection.getConnection();
    		try {
    			PreparedStatement ps  = con.prepareStatement("select * from vorder where status=?");
    			ps.setInt(1, status);
    			ResultSet rs = ps.executeQuery();
    			while(rs.next()) {
    				Orders order = new Orders();
    				order.setOrderid(rs.getInt("orderid"));
    				order.setTotalamount(rs.getDouble("totalamount"));
    				order.setCustomerId(rs.getString("customerId"));
    				orders.add(order);
    	}
    } catch (SQLException e) {
    	e.printStackTrace();
    }
    	
    		return orders;
    	}
    	}
    public void changeStatus(int orderid,int status) {

		Connection con = DBConnection.getConnection();
		try {
			
			PreparedStatement ps  = con.prepareStatement("update vorder set status=? where orderid=?");
			ps.setInt(1, status);
			ps.setInt(2, orderid);
			
			 ps.executeUpdate();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	
    }
   
}
/*
 package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import POJO.Order;
import POJO.OrderItem;

public class OrderDAO {    
    public static int saveOrder(Order o)
    {    
        Connection con=DBConnection.getConnection();
        try
        {
            con.setAutoCommit(false);
            PreparedStatement ps=con.prepareStatement("insert into EcartOrder(totalAmount,customerId)values (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setDouble(1,o.getTotalamount());
            ps.setString(2,o.getCustomerId());
        int n=ps.executeUpdate();
            if(n>0)
            {
            ResultSet rs=ps.getGeneratedKeys();
            rs.next();
            int orderId=rs.getInt(1);
            PreparedStatement pst=con.prepareStatement("insert into OrderItem(itemId,itemName,itemPrice,itemQuanity,orderId)values (?,?,?,?,?)");            
            for(OrderItem orderITem:o.getOrderItems())
            {
                pst.setInt(1, orderITem.getItemId());
                pst.setString(2, orderITem.getItemName());
                pst.setDouble(3, orderITem.getItemPrice());
                pst.setInt(4, orderITem.getQuantity());
                pst.setInt(5, orderId);                
                pst.executeUpdate();
            }
            con.commit();
            return orderId;
            }    
            }
        catch(Exception e)
        {
           try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            
            e.printStackTrace();
        }
        return  -1;
        
        
        
        
    }
    
    
    
    List<Order> geOrders(int status){
    	{
    	
    		
    		List<Order> orders=new Vector<Order>();
    
    	
    		return orders;
    	}
    
    List<Order> getMyOrders(String userName){
    	{
    	
    		
    		List<Order> orders=new Vector<Order>();
    		
    		
    		try
    		{
    			
    			Connection con=DBConnection.getConnection();
    			
    			PreparedStatement pst=con.prepareStatement("select * from ecartorder where customerid=?");
    			PreparedStatement pst1=con.prepareStatement("select * from orderitems where orderid=?");
    			
    			pst.setString(1, userName);
    			
    			ResultSet rs=pst.executeQuery()
    					while(rs.next())
    					{
    						
    						Order or=new Order();
    						or.setOrderid(rs.getInt(1));
    						or.setCustomerId(rs.getString(2));
    						
    						pst1.setInt(1, or.getOrderid());
    						
    						ResultSet rs1=pst1.executeQuery();
    						List<OrderItem> oitems=new Vector<OrderItem>();
    						while(rs1.next())
    						{
    							OrderItem orderItem=new OrderItem();
    							orderItem.setItemId(rs1.getInt(1));
    							
    							oitems.add(orderItem);
    							
    						}
    						
    						
    						or.setOrderItems(oitems);
    						
    						orders.add(or);
    						
    					}
    			
    		}
    		catch (Exception e) {
				// TODO: handle exception
    			e.printStackTrace();
			}
    		
    		
    		return orders;
    		
    		
    	}
    	
    	
    	
    }
    
}*/
