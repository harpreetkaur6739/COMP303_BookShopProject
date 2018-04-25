<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="java.util.List" import="com.bookshopweb.model.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
List<Book> books = (List<Book>)request.getAttribute("books");
%>

<t:genericpage>
	<h1>Books</h1>
	<a href="books/create" class="btn btn-success">Create</a>
	<hr />
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Title</th>
				<th>Publish Date</th>
				<th>ISBN</th>
				<th>Actions</th>
		</thead>
		<tbody>
			<%-- this is a loop --%>
			<c:forEach var="b" items="${ books }">
				<tr>
					<td>${ b.getTitle() }</td>
					<td>
						<fmt:formatDate value="${b.getPublishDate()}" pattern="dd/MM/yyyy" />
					</td>
					<td>${ b.getIsbn() }</td>
					<td>
						<div class="btn-group">
							<a href="books/edit?id=${ b.getBookId() }" class="btn btn-primary">Edit</a>
							<a href="books/delete?id=${ b.getBookId() }" class="btn btn-danger">Delete</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:genericpage>
