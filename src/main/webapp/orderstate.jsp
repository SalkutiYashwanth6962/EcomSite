<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
 <table class="table table-warning table-striped text-center">
  <thead>
    <tr>
      <th scope="col">OrderId</th>
      <th scope="col">TotalAmount</th>
      <th scope="col">CustomerName</th>
    </tr>
  </thead>
  <tbody >
  <c:forEach var="ord" items="${ordst}">
    <tr class="table text-center">
     
      <td><c:out value="${ord.orderid}"></c:out>&nbsp;</td>
      <td><c:out value="${ord.totalamount}"></c:out>&nbsp;</td>   
      <td><c:out value="${ord.customerId}"></c:out></td>
    </tr>
    </c:forEach>
   
  </tbody>
</table>
</body>
</html>