<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="java.util.List" import="com.bookshopweb.model.BookWithGenre" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
String bookId = (String)request.getAttribute("bookId");
String query = (String)request.getAttribute("query");
List<BookWithGenre> bookWithGenres = (List<BookWithGenre>)request.getAttribute("bookWithGenres");
%>

<t:genericpage>
	<h1>Manage Book Genres</h1>
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
				<th>Name</th>
				<th>Actions</th>
		</thead>
		<tbody>
			<%-- this is a loop --%>
			<c:forEach var="bg" items="${ bookWithGenres }">
				<tr>
					<td>${ bg.genre.getName() }</td>
					<td>
						<div class="btn-group">
							<form method="post">
								<input type="hidden" name="bId" value="${bookId}" />
								<input type="hidden" name="gId" value="${bg.genre.getGenreId()}" />
								<c:choose>
									<c:when test="${bg.isAdded()}">
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
