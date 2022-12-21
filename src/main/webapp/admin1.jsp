<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
    <!-- Mobile Specific Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/fav.png">
    <!-- Author Meta -->
    <meta name="author" content="CodePixar">
    <!-- Meta Description -->
    <meta name="description" content="">
    <!-- Meta Keyword -->
    <meta name="keywords" content="">
    <!-- meta character set -->
    <meta charset="UTF-8">
    <!-- Site Title -->
    <title>Karma Shop</title>

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
<header class="header_area sticky-header">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light main_box">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<a class="navbar-brand logo_h" href="index.html"><img src="img/logo.png" alt=""></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
					 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					
				</div>
			</nav>
		</div>
		
	</header>
	
 <!-- Start Banner Area -->
    <section class="banner-area organic-breadcrumb">
        <div class="container">
            <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                <div class="col-first">
                    <h1>Admin</h1>
                    <nav class="d-flex align-items-center">
                                            </nav>
                </div>
            </div>
        </div>
    </section>
    <!-- End Banner Area -->
    <br>
 <center><h2>Welcome To Admin Page...</h2></center>
<center>

<div class="btn-group" role="group" aria-label="Basic example">
  <a href=orderstate?status=1><button type="button" class="btn btn-warning text-dark">accepted orders</button></a>
  <a href=orderstate?status=-1><button type="button" class="btn btn-warning text-dark">rejected orders</button></a>
  <a href=orderstate?status=0><button type="button" class="btn btn-warning text-dark">pending orders</button></a>
  <a href=additem><button type="button" class="btn btn-warning text-dark">add items</button></a>
  <a href=viewuser><button type="button" class="btn btn-warning text-dark">view users</button></a>
  <a href="viewitems"><button type="button" class="btn btn-warning text-dark">view items</button></a>
</div>



</center>
<h2><pre>  Orders:</pre></h2>
<table class="table table-striped text-center">
  <thead>
    <tr>
      <th scope="col">OrderId</th>
      <th scope="col">TotalAmount</th>
      <th scope="col">CustomerName</th>
    </tr>
  </thead>
  <tbody >
  <c:forEach var="ord" items="${ords}">
    <tr class="table text-center">
     
      <td><c:out value="${ord.orderid}"></c:out>&nbsp;</td>
      <td><c:out value="${ord.totalamount}"></c:out>&nbsp;</td>   

      <td><c:out value="${ord.customerId}"></c:out>&nbsp;&nbsp;<a class="text-success" href=changeStatus?oid=${ord.orderid}&status=accept> accept</a>&nbsp;&nbsp;<a class="text-danger" href=changeStatus?oid=${ord.orderid}&status=reject>reject</a><br></td>
    </tr>
    </c:forEach>
   
  </tbody>
</table>

</body>
</html>