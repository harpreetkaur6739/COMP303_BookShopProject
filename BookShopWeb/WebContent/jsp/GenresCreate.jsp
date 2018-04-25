<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<h1>Create Genre</h1>
	
	<form method="post">
		<div class="form-group row">
			<label for="firstName" class="col-sm-2 col-form-label">Name</label>
			<div class="col-sm-10">
				<input id="name" name="name" type="text" placeholder="Enter genre name" required class="form-control" />
			</div>
		</div>
		<div class="form-group row">
			<div class="offset-sm-2 col-sm-10">
				<input type="submit" value="Create" class="btn btn-success" />
			</div>
		</div>
	</form>
</t:genericpage>
