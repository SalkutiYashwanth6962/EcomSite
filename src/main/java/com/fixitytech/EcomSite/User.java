package com.fixitytech.EcomSite;

import com.mysql.cj.jdbc.Blob;

public class User {
 String userName,password,email,contactNo;
 byte[] photo;
 String base64Image;


public String getBase64Image() {
	return base64Image;
}

public void setBase64Image(String base64Image) {
	this.base64Image = base64Image;
}

public byte[] getPhoto() {
	return photo;
}

public void setPhoto(byte[] byteArray) {
	this.photo = byteArray;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getContactNo() {
	return contactNo;
}

public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
 
}
