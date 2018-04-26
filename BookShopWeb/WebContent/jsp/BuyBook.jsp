<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="java.util.List" import="com.bookshopweb.model.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
Book book = (Book)request.getAttribute("book");

%>
<t:genericpage>
	<h1>Books</h1>
	<form action="/success" method="POST">
		<input type="hidden" name="id" value=${ book.getBookId() } />
		<input type="hidden" name="qty" value="1" />
		<table class="table table-responsive">
			<thead>
				<tr>
					<th>Book Title</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>HST</th>
					<th>Total Payable</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${book.getTitle()}</td>
					<td>1</td>
					<td>${book.getInventory().getPrice()}</td>
					<td>2%</td>
					<td> ${ book.getInventory().getPrice() + (0.02 * book.getInventory().getPrice()) }</td>
				</tr>
			</tbody>
		</table>
	
		<div>
		<div>Select Payment Method:</div>
			<div><input type="radio" id="paymentMethhod" name="paymentMethod" value="cash" >Cash on delivery</div>
		</div>
	</form>
	<div><input type="submit" class="btn btn-primary" value="Checkout" /></div>
</t:genericpage>
