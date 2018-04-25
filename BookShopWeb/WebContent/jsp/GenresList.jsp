<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="java.util.List" import="com.bookshopweb.model.Genre" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
List<Genre> genres = (List<Genre>)request.getAttribute("genre");
%>

<t:genericpage>
	<h1>Genres</h1>
	<a href="genres/create" class="btn btn-success">Create</a>
	<hr />
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Actions</th>
		</thead>
		<tbody>
			<%-- this is a loop --%>
			<c:forEach var="g" items="${ genres }">
				<tr>
					<td>${ g.getName() }</td>
					<td>
						<div class="btn-group">
							<a href="genres/edit?id=${ g.getGenreId() }" class="btn btn-primary">Edit</a>
							<a href="genres/delete?id=${ g.getGenreId() }" class="btn btn-danger">Delete</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:genericpage>
