package com.fixitytech.EcomSite.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.fixitytech.EcomSite.Item;

public class ItemDAO {
public List<Item> getItems(){
List<Item> items = new Vector<Item>();
try {
	Connection con = getConnection();
	PreparedStatement pst = con.prepareStatement("select * from items");
	ResultSet rs = pst.executeQuery();
	while(rs.next()) {
		Item it = new Item();
		it.setId(rs.getInt(1));//1st column
		it.setName(rs.getString(2));
		it.setPrice(rs.getDouble(3));
		items.add(it);
	}
	
}catch(Exception e) {
	e.printStackTrace();
}
return items;
}
static Connection getConnection() {
	Connection con;
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");	
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomsitedb", "root", "yash123@");
	return con;
	}catch(Exception e) {
		e.printStackTrace();
	}
return null;	
}


public static boolean addItem(int itemId,String itemName,double itemPrice) 
{
	try {
	Connection con = getConnection();
	PreparedStatement st1;
	st1=con.prepareStatement("insert into items values(?,?,?)");
	st1.setInt(1,itemId);
	st1.setString(2,itemName);
	st1.setDouble(3,itemPrice);
	
    int row = st1.executeUpdate();
	if(row>0)
    return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return false;
}




public static Item getItem(String itemId) {
	
	try {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from items where id="+itemId);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			Item it = new Item();
			it.setId(rs.getInt(1));
			it.setName(rs.getString(2));
			it.setPrice(rs.getDouble(3));
			return it;
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return null;
	}

}
