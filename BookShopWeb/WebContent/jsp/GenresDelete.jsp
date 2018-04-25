<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"
	import="com.bookshopweb.model.Genre" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%
Genre genre = (Genre)request.getAttribute("genre");
%>

<t:genericpage>
	<h1>Delete Genre</h1>
	
	<form method="post">
		<div class="form-group row">
			<label for="name" class="col-sm-2 col-form-label">Name</label>
			<div class="col-sm-10">
				<span id="name">${genre.getName()}</span>
			</div>
		</div>
		<div class="form-group row">
			<div class="offset-sm-2 col-sm-10">
				<input type="submit" value="Delete" class="btn btn-danger" />
			</div>
		</div>
	</form>
</t:genericpage>
