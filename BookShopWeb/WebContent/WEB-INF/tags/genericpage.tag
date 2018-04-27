<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<title>Book Shop</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-4">
		<div class="container">
			<a href="#" class="navbar-brand">Book Shop</a>
			<button type="button" data-toggle="collapse" data-target="#navbarSupportedContent" class="navbar-toggler"></button>
			<div id="navbarSupportedContent" class="collapse navbar-collapse">
<<<<<<< HEAD
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
						<a href="/BookShopWeb/" class="nav-link">Home</a>
					</li>
					<li class="nav-item">
						<a href="/BookShopWeb/books" class="nav-link">Books</a>
					</li>
					<li class="nav-item">
						<a href="/BookShopWeb/authors" class="nav-link">Authors</a>
					</li>
					<li class="nav-item">
						<a href="/BookShopWeb/genres" class="nav-link">Genres</a>
					</li>
					<li class="nav-item">
						<a href="/BookShopWeb/inventory" class="nav-link">Inventory</a>
					</li>
					<li class="nav-item">
						<a href="/BookShopWeb/history" class="nav-link">History</a>
					</li>
=======
				<%
				  if (session != null && session.getAttribute("user") != null)
				  {
					  if(session.getAttribute("role").equals("customer")){
						 
					  
				    %>
				    <ul class="navbar-nav mr-auto">
						<li class="nav-item">
							<a href="/BookShopWeb/books/shop" class="nav-link">Shop Books</a>
						</li>
						<li class="nav-item">
							<a href="/BookShopWeb/transactions" class="nav-link">View Transactions</a>
						</li>
					</ul>
					<%}else if(session.getAttribute("role").equals("admin")){
						
					 %>
					 <ul class="navbar-nav mr-auto">
						<li class="nav-item">
							<a href="/BookShopWeb/books" class="nav-link">Books</a>
						</li>
						<li class="nav-item">
							<a href="/BookShopWeb/authors" class="nav-link">Authors</a>
						</li>
						<li class="nav-item">
							<a href="/BookShopWeb/genres" class="nav-link">Genres</a>
						</li>
						<li class="nav-item">
							<a href="/BookShopWeb/inventory" class="nav-link">Inventory</a>
						</li>
						<li class="nav-item">
							<a href="/BookShopWeb/transactionList" class="nav-link">Transactions</a>
						</li>
					
>>>>>>> buybook
				</ul>
				
				<%
					  }%>
					<ul class="navbar-nav">
					<li class="navbar-text mr-3">
						<span>Hello, <%=session.getAttribute("user") %></span>
					</li>
					<li class="nav-item">
						<a href="logout" class="nav-link">Logout</a>
					</li>
				</ul>
					  <%
				  }
				%>
				
			</div>
		</div>
	</nav>
	
	<main class="container body-content">
		<jsp:doBody />
	</main>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
	
</body>
</html>
