<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="com.bookshopweb.model.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
Book book = (Book)request.getAttribute("book");
%>

<t:genericpage>
	<h1>Delete Book</h1>
	
	<form method="post">
		<div class="form-group row">
			<label for="title" class="col-sm-2 col-form-label">Title</label>
			<div class="col-sm-10">
				<span id="title">${book.getTitle()}</span>
			</div>
		</div>
		<div class="form-group row">
			<label for="publishDate" class="col-sm-2 col-form-label">Publish Date</label>
			<div class="col-sm-10">
				<span id="publishDate">
					<fmt:formatDate value="${book.getPublishDate()}" pattern="dd/MM/yyyy" />
				</span>
			</div>
		</div>
		<div class="form-group row">
			<label for="isbn" class="col-sm-2 col-form-label">ISBN</label>
			<div class="col-sm-10">
				<span id="isbn">${book.getIsbn()}</span>
			</div>
		</div>
		<div class="form-group row">
			<label for="title" class="col-sm-2 col-form-label">Rating</label>
			<div class="col-sm-10">
				<span id="rating">${book.getRating()} out of 10</span>
			</div>
		</div>
		<div class="form-group row">
			<div class="offset-sm-2 col-sm-10">
				<input type="submit" value="Delete" class="btn btn-danger" />
			</div>
		</div>
	</form>
</t:genericpage>
