<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="java.util.List" import="com.bookshopweb.model.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
Book book = (Book) request.getAttribute("book");
%>

<t:genericpage>
	<h1>Book Details</h1>
	
	<div class="row" style="color:red">
		${book.getTitle()}
	</div>
	<div class="row">
		Summary
	</div>
	<div>
		${book.getDetail().getSummary()}
	</div>
	<div class="row">
	Published On: ${book.getPublishDate()}
	</div>
	
</t:genericpage>