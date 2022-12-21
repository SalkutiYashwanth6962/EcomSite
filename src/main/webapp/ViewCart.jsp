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
 <a href="viewCart?c=viewCart"><c:out value="${cart.size()}"></c:out></a>
 <a href="login">SignIn</a><br/>
 <c:set var="total" value="${0}"/>
 <c:forEach var="pr" items="${cart}" >
 <c:out value="${pr.name}"></c:out>&nbsp;
 <c:out value="${pr.price}"></c:out>&nbsp;
 <c:out value="${pr.quantity}"></c:out>&nbsp;
 <c:out value="${pr.price*pr.quantity}"></c:out><br/>
 
 <c:set var="total" value="${total+pr.price*pr.quantity }"></c:set>
 
 </c:forEach>
 Total Amount<c:out value="${total}"></c:out>
 <c:if test="${empty uid}">
  <a href="login?c=viewCart" >SignIn</a>
 </c:if>
 <c:if test="${not empty uid}">
  <a href="OrderServlet" >Place Order</a>
 </c:if>
</body>
</html>