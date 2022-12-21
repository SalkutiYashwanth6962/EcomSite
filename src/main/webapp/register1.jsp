<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <!--
            CSS
            ============================================= -->
    <link rel="stylesheet" href="css/linearicons.css">
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <link rel="stylesheet" href="css/nice-select.css">
    <link rel="stylesheet" href="css/nouislider.min.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/main.css">

</head>
<body>
  <div class="login_form_inner">
						<h3>Registration Form..</h3>
						<form class="row login_form" action="register" method="post" id="contactForm" enctype="multipart/form-data" >
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" value="${param.uname}" id="name" name="uname" placeholder="Username" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Username'">
							</div>
							<div class="col-md-12 form-group">
								<input type="password" class="form-control" id="name" name="upassword" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" value="${param.uemail}" id="name" name="uemail" placeholder="email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'email'">
							</div>
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" value="${param.ucontact}" id="name" name="ucontact" placeholder="Contact Number" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Contact Number'">
							</div>
							<div class="col-md-12 form-group">
								<input type="file" class="form-control"  id="name" name="photo" placeholder="Photo" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Photo'">
							</div>
							
							<div class="col-md-12 form-group">
								<button type="submit" value="submit" class="primary-btn">Register</button>
								
							</div>
						</form>
					</div>
					<!-- <body >
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
					 -->
</body>
</html>