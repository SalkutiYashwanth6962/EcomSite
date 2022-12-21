package com.fixitytech.EcomSite.DAO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Vector;

import com.fixitytech.EcomSite.User;
import com.mysql.cj.jdbc.Blob;
//It all makes user db operations.
public class UserDAO {
	public boolean validate(String uname,String password) {
		try {
			Connection con = getConnection();
			PreparedStatement pst= con.prepareStatement("select *  from users where uid=? and password=?");
			pst.setString(1,uname);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	Connection getConnection() {
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
	public boolean save(User user) {
		try{
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into users values(?,?,?,?,?)");
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getContactNo());
			pst.setBytes(5,user.getPhoto());
			// if (file != null) {
	                // fetches input stream of the upload file for the blob column
	               // pst.setBlob(5, file);
	          //  }
			int n= pst.executeUpdate();
			if(n>0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public User getUser(String uname) {
		
		try {
			Connection con = getConnection();
			PreparedStatement pst= con.prepareStatement("select *  from users where uid=? ");
			pst.setString(1,uname);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				//here the row will be converted into object.
				User user = new User();
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setContactNo(rs.getString(4));
				return user;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	

		
	}
	
	
	


public User getUser1(String username) throws SQLException, IOException {
    User user = null;

    String sql = "SELECT * FROM users WHERE uid = ?";


        Connection connection =  getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            //user = new User();
            user = new User();
    		String userName = result.getString("uid");
    		String pwd = result.getString("password");
    		String emailId  = result.getString("email");
    		String phoneNo = result.getString("mobile");
    	    java.sql.Blob blob= result.getBlob("photo");
    		
            InputStream inputStream = blob.getBinaryStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);                  
            }

            byte[] imageBytes = outputStream.toByteArray();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);


            inputStream.close();
            outputStream.close();

            user.setUserName(userName);
    		user.setPassword(pwd);
    		user.setEmail(emailId);
    	    user.setContactNo(phoneNo);
    		user.setBase64Image(base64Image);
    	
        }
        return user;          


    }
  






public List<User> getUsers1() throws SQLException, IOException {
	List<User> users1= new Vector<User>();
    User user = null;

    String sql = "SELECT * FROM users";


        Connection connection =  getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        //statement.setString(1, username);
        ResultSet result = statement.executeQuery();
        System.out.println("--->"+result);
        while(result.next()) {
            //user = new User();
            user = new User();
    		String userName = result.getString("uid");
    		String pwd = result.getString("password");
    		String emailId  = result.getString("email");
    		String phoneNo = result.getString("mobile");
    	    java.sql.Blob blob= result.getBlob("photo");
    		
            InputStream inputStream = blob.getBinaryStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);                  
            }

            byte[] imageBytes = outputStream.toByteArray();
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);


            inputStream.close();
            outputStream.close();

            user.setUserName(userName);
    		user.setPassword(pwd);
    		user.setEmail(emailId);
    	    user.setContactNo(phoneNo);
    		user.setBase64Image(base64Image);
    		users1.add(user);
    	
        }
        return users1;          


    }
  
    
	
	public List<User> getUsers(){
		List<User> users = new Vector<User>();
		try {
			Connection con = getConnection();
			PreparedStatement pst= con.prepareStatement("select *  from users ");
			
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				//list converted to object 
				User user = new User();
				user.setUserName(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setContactNo(rs.getString(4));
				//user.setPhoto(rs.getBytes(5));
				users.add(user);
				//return users;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
/*package net.codejava;
 
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
 
public class BookDAO {
    String databaseURL = "jdbc:mysql://localhost:3306/bookstoredb";
    String user = "root";
    String password = "pass";
     
    }*/
	
}
