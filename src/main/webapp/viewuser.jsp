<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <c:out value="${ur.userName}"></c:out>&nbsp;
 <c:out value="${ur.password}"></c:out>&nbsp;
 <c:out value="${ur.email}"></c:out>&nbsp;
 <c:out value="${ur.contactNo}"></c:out>&nbsp;
 
<img src="data:image/png;base64,${ur.base64Image}" width="240" /> 
 --%> 
   <c:forEach var="pr1" items="${ur}">
 <c:out value="${pr1.userName}"></c:out>&nbsp;
 <c:out value="${pr1.email}"></c:out>&nbsp;
 
 <c:out value="${pr1.contactNo}"></c:out>&nbsp;
 
 <img src="data:image/png;base64,${pr1.base64Image}" width="240" />
 <br>
 
 </c:forEach> 
 
<div class="container text-center">
 <c:forEach var="pr1" items="${ur}">
  <div class="row">
  
    <div class="col-lg-2">
      <c:out value="${pr1.userName}"></c:out>&nbsp;
 
      
    </div>
    <div class="col-lg-2">
     <c:out value="${pr1.email}"></c:out>&nbsp;
    </div>
    <div class="col-lg-3">
      <c:out value="${pr1.contactNo}"></c:out>&nbsp;
    </div>
     <div class="col-lg-3">
      <img src="data:image/png;base64,${pr1.base64Image}" width="240" />
    </div><br>
    
  </div>
  </c:forEach><br>
</div>
 
 <!--
 

 
 
 
 
   <div align="center">
    <h2><c:out value="${book.title}" /></h2>
    <h3><c:out value="${book.author}" /></h3>
    <img src="data:image/jpg;base64,${book.base64Image}" width="240" height="300"/>
</div>  -->
</body>
</html>
