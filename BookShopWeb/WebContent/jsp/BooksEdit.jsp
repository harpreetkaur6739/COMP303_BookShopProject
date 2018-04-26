<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="com.bookshopweb.model.Book" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
Book book = (Book)request.getAttribute("book");
%>

<t:genericpage>
	<h1>Edit Book</h1>
	
	<form method="post">
		<div class="form-group row">
			<label for="title" class="col-sm-2 col-form-label">Title</label>
			<div class="col-sm-10">
				<input id="title" name="title" type="text" placeholder="Enter title" required class="form-control" value=${ book.getTitle() } />
			</div>
		</div>
		<div class="form-group row">
			<label for="publishDate" class="col-sm-2 col-form-label">Publish Date</label>
			<div class="col-sm-10">
				<input id="publishDate" name="publishDate" type="text" placeholder="Enter publish date (DD/MM/YYYY)" value=${ book.getPublishDate() } required class="form-control"
					pattern="^(0[1-9]|1[0-9]|2[0-9]|3[0-1])\/(0[1-9]|1[0-2])\/([1-2]\d\d\d)$" />
			</div>
		</div>
		<div class="form-group row">
			<label for="isbn" class="col-sm-2 col-form-label">ISBN</label>
			<div class="col-sm-10">
				<input id="isbn" name="isbn" type="text" placeholder="Enter ISBN" value=${ book.getIsbn() } required class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<label for="rating" class="col-sm-2 col-form-label">Rating</label>
			<div class="col-sm-10">
				<input id="rating" name="rating" type="number" placeholder="Enter rating (1-10)" value=${ book.getRating() } required min="1" max="10" class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<label for="summary" class="col-sm-2 col-form-label">Summary</label>
			<div class="col-sm-10">
				<textarea id="summary" name="summary" placeholder="Enter Summary" value=${ book.getDetail().getSummary() } required class="form-control" ></textarea>
			</div>
		</div>
		<div class="form-group row">
			<div class="offset-sm-2 col-sm-10">
				<input type="submit" value="Save" class="btn btn-success" />
			</div>
		</div>
	</form>
</t:genericpage>
