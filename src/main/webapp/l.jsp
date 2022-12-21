<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html5>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script type="text/javascript">
function usernamevalidate(username){
	var el = document.getElementById("err");
	//var un = document.getElementById("uname").value;
	var un = username.value;
	if(un.length<5){
		el.innerHTML="please enter minimum 4 characters ";
		//return false;
	}
	else{
		innerHTML=" ";
	}
	
}
function validate(){
	var el1 = document.getElementById("error");
	var un1= document.getElementById("uname").value;
	//var un1 = username.value;
	if(un1.length<5){
		el1.innerHTML="errors in form";
		return false;
	}
	else{
		innerHTML=" ";
	}
	
}
</script>
</head>
<body>
<center>
<form action="login" method="post" onsubmit="return validate()" >
<div id = "error"></div>
 <h1>Login</h1>
 <h4>${err}</h4>
 <table style=" border-spacing: 15px 6px; border:3px solid black ">
 <tr>
 <td>UserName</td><td><input type="text" name="uname" id="uname" onblur="usernamevalidate(this)" required></td>
 </tr>
 <div id="err"> </div>
 <tr>
 <td><input type="hidden" name="c" value="${param.c}"></td>
 </tr>
 <tr>
 <td>Password</td><td> <input type="password" name="upassword" required></td>
 </tr>
 <tr>
 <td colspan="2" style="text-align:center"><button style="background-color:SkyBlue" >Log In</button></td>
 </tr>
 </table>
 <h3>If not registered ?&nbsp;<a href="register">Register</a></h3>
  </form>
 </center>
</body>
</html>