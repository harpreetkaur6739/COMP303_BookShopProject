<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="java.util.List" import="com.bookshopweb.model.Author" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
List<Author> authors = (List<Author>)request.getAttribute("authors");
%>

<t:genericpage>
	<h1>Authors</h1>
	<a href="authors/create" class="btn btn-success">Create</a>
	<hr />
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Last Name</th>
				<th>First Name</th>
				<th>Actions</th>
		</thead>
		<tbody>
			<%-- this is a loop --%>
			<c:forEach var="a" items="${ authors }">
				<tr>
					<td>${ a.getLastName() }</td>
					<td>${ a.getFirstName() }</td>
					<td>
						<div class="btn-group">
							<a href="authors/edit?id=${ a.getAuthorId() }" class="btn btn-primary">Edit</a>
							<a href="authors/delete?id=${ a.getAuthorId() }" class="btn btn-danger">Delete</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:genericpage>
