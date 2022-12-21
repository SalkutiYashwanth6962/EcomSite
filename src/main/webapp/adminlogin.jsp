<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="adminlogin" method="post">
 <h1>Login</h1>
 <h4>${err}</h4>
 <table>
 <tr>
 <td>UserName</td><td><input type="text" name="uname1"></td>
 </tr>
 <tr>
 <td>Password</td><td> <input type="password" name="upassword1"></td>
 </tr>
 <tr>
 <td colspan="2" style="text-align:center"><button>Log In</button></td>
 </tr>
 </table>
  </form>
</body>
</html>