<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ecom Site...</title>
</head>
<body>
 Welcome to Ecommerce Site.
 <a href="viewCart"><c:out value="${cart.size()}">Items</c:out></a>
 
   <c:if test="${empty uid}">
   <a href="login?c=Index">SignIn</a><br/>
   <!--<a href="login" >SignIn</a>
     -->  
 </c:if>
 <c:if test="${not empty uid}">
 Welcome <c:out value="${uid}"></c:out>
  <a href="logout" >Sign Out..</a>
 </c:if><br>
 <c:forEach var="pr" items="${prs}">
 <c:out value="${pr.name}"></c:out>&nbsp;
 <c:out value="${pr.price}"></c:out>&nbsp;
  <img src="${pr.base64Image}" width="340" height="300"/> 
 <a  href="addCart?id=${pr.id}">Add To Cart</a><br/>
 
 </c:forEach>
</body>
</html>