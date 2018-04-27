<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="java.util.List" import="com.bookshopweb.model.Transaction" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
List<Transaction> transactions = (List<Transaction>)request.getAttribute("transactions");
%>

<t:genericpage>
<h1>Transactions</h1>
<table class="table table-hover">
		<thead>
			<tr>
				<th>User</th>
				<th>Book Id</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Date</th>
		</thead>
		<tbody>
			<%-- this is a loop --%>
			<c:forEach var="b" items="${ transactions }">
				<tr>
					<td>${ b.getUser() }</td>
					<td>${ b.getBook().getTitle() }</td>
					
					<td>${ b.getQuantity() }</td>
					<td>${ b.getAmount() }</td>
					<td>${ b.getDate() }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:genericpage>
