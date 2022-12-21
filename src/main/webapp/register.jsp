<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<center>
<div>
<form action="register" method = "post" enctype="multipart/form-data" >
 <h1>Registration Form</h1>
 <table style="border-spacing: 15px 6px; border:3px solid black">
 <tr>
 <td>Name</td><td><input type="text" value="${param.uname}" name="uname"></td>
 </tr>
 <tr>
 <td>Password</td><td> <input type="password" name="upassword"></td>
 </tr>
 <tr>
 <td>Email</td><td><input type="text" value="${param.uemail}" name="uemail"></td>
 </tr>
 <tr>
 <td>ContactNo</td><td><input type="text" value="${param.ucontact}" name="ucontact"></td>
 </tr>
 <tr>
 <td>Photo:</td><td><input type="file"  name="photo"></td>
 </tr>
  <tr>
 <td colspan="2" style="text-align:center"><button style="background-color:SkyBlue">REGISTER</button></td>
 </tr>
 </table>
 <h3>Already Existing User?&nbsp;<a href="login">Login</a></h3>
  </form>
  </div>
</center>
</body>
</html>