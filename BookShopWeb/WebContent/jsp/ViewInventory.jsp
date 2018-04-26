<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="java.util.List" import="com.bookshopweb.model.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
List<Book> books = (List<Book>)request.getAttribute("books");
%>

<t:genericpage>
<h1>Inventory Details</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Book Id</th>
				<th>Title</th>
				<th>Quantity Available</th>
		</thead>
		<tbody>
			<%-- this is a loop --%>
			<c:forEach var="b" items="${ books }">
				<tr>
					<td>${ b.getBookId() }</td>
					<td>${ b.getTitle() }</td>
					<td>${ b.getInventory().getQuantity()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:genericpage>