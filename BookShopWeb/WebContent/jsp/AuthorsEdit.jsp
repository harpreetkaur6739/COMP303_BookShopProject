<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="com.bookshopweb.model.Author" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
Author author = (Author)request.getAttribute("author");
%>

<t:genericpage>
	<h1>Edit Author</h1>
	
	<form method="post">
		<div class="form-group row">
			<label for="firstName" class="col-sm-2 col-form-label">First Name</label>
			<div class="col-sm-10">
				<input id="firstName" name="firstName" type="text" placeholder="Enter first name" required class="form-control" value="${author.getFirstName()}" />
			</div>
		</div>
		<div class="form-group row">
			<label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
			<div class="col-sm-10">
				<input id="lastName" name="lastName" type="text" placeholder="Enter last name" required class="form-control" value="${author.getLastName()}" />
			</div>
		</div>
		<div class="form-group row">
			<div class="offset-sm-2 col-sm-10">
				<input type="submit" value="Save" class="btn btn-success" />
			</div>
		</div>
	</form>
</t:genericpage>
