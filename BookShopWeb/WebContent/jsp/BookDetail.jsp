<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="java.util.List" import="com.bookshopweb.model.Book" import="com.bookshopweb.model.Author"
	import="com.bookshopweb.model.Genre" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
Book book = (Book) request.getAttribute("book");
List<Author> authors = (List<Author>)request.getAttribute("authors");
List<Genre> genres = (List<Genre>)request.getAttribute("genres");
%>

<t:genericpage>
	<h1>Book Details</h1>
	
	
	<h2>
		${book.getTitle()}
		<c:forEach var="g" items="${ genres }">
			<span class="badge badge-primary">${ g.getName() }</span>
		</c:forEach>
	</h2>
	<div class="text-muted">
		Written by
		<c:forEach var="a" varStatus="loop" items="${ authors }">
			<em>${ a.getFirstName() } ${ a.getLastName() }</em>
			<c:if test="${ !loop.isLast() }">, </c:if>
		</c:forEach>
	</div>
	

	<div class="panel panel-default">
		<div class="panel-heading">Summary</div>
    	<div class="panel-body">${book.getDetail().getSummary()}</div>
	</div>
	
	<div class="row">
		Published On: ${book.getPublishDate()}
	</div>
	
</t:genericpage>
