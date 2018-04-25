<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="com.bookshopweb.model.Author" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
Author author = (Author)request.getAttribute("author");
%>

<t:genericpage>
	<h1>Delete Author</h1>
	
	<form method="post">
		<div class="form-group row">
			<label for="firstName" class="col-sm-2 col-form-label">First Name</label>
			<div class="col-sm-10">
				<span id="firstName">${author.getFirstName()}</span>
			</div>
		</div>
		<div class="form-group row">
			<label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
			<div class="col-sm-10">
				<span id="lastName">${author.getLastName()}</span>
			</div>
		</div>
		<div class="form-group row">
			<div class="offset-sm-2 col-sm-10">
				<input type="submit" value="Delete" class="btn btn-danger" />
			</div>
		</div>
	</form>
</t:genericpage>
