<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>



<t:genericpage>
<h1>Registration</h1>
<form action="register" method="post">
	<table class="table">
	<tbody>
	<tr>
	<td>User Name</td>
	<td><input type="text" name="userName" required /></td>
	</tr>
	<tr>
	<td>Choose a password</td>
	<td><input type="password" name="password" required /></td>
	</tr>
	</tbody>
		
	</table>
	<div><input type="submit" class="btn btn-primary" value="Register" /></div>
</form>
</t:genericpage>