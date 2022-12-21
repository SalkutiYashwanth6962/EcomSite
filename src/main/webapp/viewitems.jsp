<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<link rel="stylesheet" href="css/themify-icons.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/nice-select.css">
	<link rel="stylesheet" href="css/nouislider.min.css">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" href="css/main.css">

</head>
<body>


<div class="container text-center">
<c:forEach var="pr" items="${it1}">
  <div class="row">
  
    <div class="col-lg-3">
      <c:out value="${pr.name}"></c:out>
    </div>
    <div class="col-lg-3">
      <c:out value="${pr.price}"></c:out>
    </div>
    <div class="col-lg-3">
      <img src="${pr.base64Image}" width="200" height="200"/><br>
    </div><br>
    
  </div>
  </c:forEach><br>
</div>



 
 
   
 <!--  <a  href="addCart?id=${pr.id}">Add To Cart</a><br/>-->
 
 

</body>
</html>