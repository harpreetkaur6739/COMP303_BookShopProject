<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="java.util.List" import="com.bookshopweb.model.BookWithAuthor" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
String bookId = (String)request.getAttribute("bookId");
String query = (String)request.getAttribute("query");
List<BookWithAuthor> bookWithAuthors = (List<BookWithAuthor>)request.getAttribute("bookWithAuthors");
%>

<t:genericpage>
	<h1>Manage Book Authors</h1>
	<hr />
	<form method="get" class="form-group">
		<div class="input-group">
			<input class="form-control" name="q" placeholder="Enter search query" type="text" value="${query}" />
			<input type="hidden" name="bId" value="${bookId}" />
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
			<c:forEach var="ba" items="${ bookWithAuthors }">
				<tr>
					<td>${ ba.author.getLastName() }</td>
					<td>${ ba.author.getFirstName() }</td>
					<td>
						<div class="btn-group">
							<form method="post">
								<input type="hidden" name="bId" value="${bookId}" />
								<input type="hidden" name="aId" value="${ba.author.getAuthorId()}" />
								<c:choose>
									<c:when test="${ba.isAdded()}">
										<input type="hidden" name="op" value="remove" />
										<input type="submit" value="Remove" class="btn btn-danger" />
									</c:when>
									<c:otherwise>
										<input type="hidden" name="op" value="add" />
										<input type="submit" value="Add" class="btn btn-success" />
									</c:otherwise>
								</c:choose>
							</form>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:genericpage>
