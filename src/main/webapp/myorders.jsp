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
<table class="table text-center table-striped">
  
    <tr>
      <c:forEach var="ord" items="${ords}">
      <th scope="col">OrderId</th>
      <th scope="col">TotalAmount</th>
      <th scope="col">CustomerName</th>
    </tr>
  
  
    <tr>
      
      <td><c:out value="${ord.orderid}"></c:out>&nbsp;</td>
      <td><c:out value="${ord.totalamount}"></c:out>&nbsp;</td>
      <td><c:out value="${ord.customerId}"></c:out>&nbsp;</td>
    </tr>
    <c:forEach var="order1" items="${ord.orderItems}">
 <tr>
 <td><c:out value="${order1.id}"></c:out></td>
 <td><c:out value="${order1.name}"></c:out></td>
 <td><c:out value="${order1.price}"></c:out></td>
 <td><c:out value="${order1.quantity}"></c:out></td>
 </tr>
 
 </c:forEach>
 
    </c:forEach>
    
</table>
 <c:forEach var="ord" items="${ords}">
 
 <c:out value="${ord.orderid}"></c:out>&nbsp;
 <c:out value="${ord.totalamount}"></c:out>&nbsp;
 <c:out value="${ord.customerId}"></c:out>&nbsp;
 <br>
 <c:forEach var="order1" items="${ord.orderItems}">
 
 <c:out value="${order1.id}"></c:out>&nbsp;
 <c:out value="${order1.name}"></c:out>&nbsp;
 <c:out value="${order1.price}"></c:out>&nbsp;
 <c:out value="${order1.quantity}"></c:out>&nbsp;
 <br>
 </c:forEach>
  
  </c:forEach>
 </body>
</html>