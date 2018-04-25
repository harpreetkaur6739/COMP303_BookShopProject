<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="java.util.List" import="com.bookshopweb.model.Author" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
String query = (String)request.getAttribute("query");
List<Author> authors = (List<Author>)request.getAttribute("authors");
%>

<t:genericpage>
	<h1>Authors</h1>
	<a href="authors/create" class="btn btn-success">Create</a>
	<hr />
	<form method="get" class="form-group">
		<div class="input-group">
			<input class="form-control" name="q" placeholder="Enter search query" type="text" value="${query}" />
			<span class="input-group-append">
				<button type="submit" class="btn btn-primary">Search</button>
			</span>
		</div>
	</form>
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
